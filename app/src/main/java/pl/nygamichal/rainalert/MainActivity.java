package pl.nygamichal.rainalert;

import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Trigger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getCanonicalName();
    FirebaseJobDispatcher firebaseJobDispatcher;
    @BindView(R.id.switchBackgroud)
    Switch switchBackground;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
        sharedPreferences = getSharedPreferences("pl.nygamichal.rainalert", MODE_PRIVATE);
        firebaseJobDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(MainActivity.this));
        switchBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putBoolean("background",switchBackground.isChecked()).apply();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        firebaseJobDispatcher.cancelAll();//user zmieni preferencje, wiec ma wylayczc wszystkie poprzednie powiadomienia i prypomnienia
        //Intent intent = new Intent(this, WeatherService.class);
        //startService(intent);
        switchBackground.setChecked(sharedPreferences.getBoolean("background",false));
    }

    @Override
    protected void onPause() {
        if (switchBackground.isChecked())
        {
            Job.Builder job = firebaseJobDispatcher.newJobBuilder().setRecurring(true).setTag("weather").setTrigger(Trigger.executionWindow(2,6)).setService(WeatherService.class);
            firebaseJobDispatcher.schedule(job.build());
        }
        super.onPause();
    }
}