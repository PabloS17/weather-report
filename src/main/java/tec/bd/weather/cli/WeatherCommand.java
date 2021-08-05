package tec.bd.weather.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import retrofit2.Call;
import retrofit2.Retrofit;
import tec.bd.weather.ApplicationContext;
import tec.bd.weather.openweather.OpenWeatherReport;
import retrofit2.converter.gson.GsonConverterFactory;
import tec.bd.weather.openweather.IOpenWeatherResource;

import java.io.IOException;
import java.util.Map;

@Command(name = "city", description = "Get weather forecast for city")
public class WeatherCommand implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherCommand.class);

    private static ApplicationContext APP_CONTEXT = ApplicationContext.init();

    @Parameters(paramLabel = "<city name>", description = "city name to be resolved")
    private String cityName;

    @Override
    public void run() {

        var weatherReport = APP_CONTEXT.getWeatherReport();
        var report = weatherReport.getByCity(cityName);
        System.out.println(report);

    }
}
