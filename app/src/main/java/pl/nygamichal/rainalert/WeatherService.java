package pl.nygamichal.rainalert;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import pl.nygamichal.rainalert.api.Weather;
import pl.nygamichal.rainalert.api.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherService extends JobService {
    public static final String TAG = MainActivity.class.getCanonicalName();
    public WeatherService() {
    }

    @Override
    public boolean onStartJob(JobParameters job) {
        RainAlertApp.weatherApi.getWeather(RainAlertApp.API_KEY,"Krakow,pl").enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d(TAG, "onResponse: ");
                if (response.isSuccessful())
                {
                    if (response.body() != null && response.body().weather != null)
                    {
                        if (response.body().weather.size() >0)
                        {
                            if (response.body().weather.get(0).description.contains("rain"))
                            {
                                showNotification(response.body().weather.get(0));
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
        return false;
    }

    private void showNotification(Weather weather) {
        Intent intent = new Intent(WeatherService.this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(WeatherService.this, 123, intent , PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(WeatherService.this).setContentTitle("Rain alarm!").setContentText(weather.description).setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pIntent).setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(123, notificationBuilder.build());
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        return false;
    }
}
