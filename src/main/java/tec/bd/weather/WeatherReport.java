package tec.bd.weather;

import tec.bd.weather.model.Report;
import tec.bd.weather.provider.IWeatherProvider;

public class WeatherReport {

    private IWeatherProvider weatherProvider;

    public WeatherReport(IWeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public Report getByCity(String city) {
        var report = this.weatherProvider.byCity(city);
        return report;
    }

}
