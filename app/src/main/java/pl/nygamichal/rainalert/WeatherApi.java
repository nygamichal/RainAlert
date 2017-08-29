package pl.nygamichal.rainalert;

import pl.nygamichal.rainalert.api.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 08.08.2017.
 */

public interface WeatherApi {
    @GET("weather")
    Call<WeatherResponse> getWeather(@Query("APPID") String appid, @Query("q") String location);

    @GET("weather")
    Call<WeatherResponse> getWeather(@Query("APPID") String appid, @Query("lat") Double lat, @Query("lon") Double lon);
}
