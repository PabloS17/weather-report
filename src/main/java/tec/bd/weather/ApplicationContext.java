package tec.bd.weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tec.bd.weather.openweather.IOpenWeatherResource;
import tec.bd.weather.openweather.OpenWeather;
import tec.bd.weather.provider.IWeatherProvider;

public class ApplicationContext {

    private final static String BASE_URL = "https://api.openweathermap.org";

    private IOpenWeatherResource openWeatherResource;

    private IWeatherProvider openWeatherProvider;

    private WeatherReport weatherReport;


    public ApplicationContext() {

    }

    public IWeatherProvider getOpenWeatherProvider() {
        return openWeatherProvider;
    }

    public WeatherReport getWeatherReport() {
        return weatherReport;
    }

    public static ApplicationContext init() {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.openWeatherResource = initOpenWeatherResource();
        applicationContext.openWeatherProvider = initOpenWeatherProvider(applicationContext.openWeatherResource);
        applicationContext.weatherReport = initWeatherReport(applicationContext.openWeatherProvider);
        return applicationContext;
    }

    private static IOpenWeatherResource initOpenWeatherResource() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IOpenWeatherResource.class);
    }

    private static IWeatherProvider initOpenWeatherProvider(IOpenWeatherResource openWeatherResource) {
        return new OpenWeather(openWeatherResource);
    }

    private static WeatherReport initWeatherReport(IWeatherProvider weatherProvider) {
        return new WeatherReport(weatherProvider);
    }



}
