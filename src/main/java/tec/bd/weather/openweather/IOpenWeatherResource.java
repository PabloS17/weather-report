package tec.bd.weather.openweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import tec.bd.weather.openweather.OpenWeatherReport;

import java.util.Map;

public interface IOpenWeatherResource {

    @GET("/data/2.5/weather")
    Call<OpenWeatherReport> get(@QueryMap Map<String, String> options);
}
