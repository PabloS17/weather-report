package tec.bd.weather.openweather;

import retrofit2.Call;
import tec.bd.weather.provider.BaseWeatherProvider;
import tec.bd.weather.model.Report;

import java.util.Map;

public class OpenWeather extends BaseWeatherProvider<OpenWeatherReport> {

    private IOpenWeatherResource openWeatherResource;

    public OpenWeather(IOpenWeatherResource openWeatherResource) {
        this.openWeatherResource = openWeatherResource;
    }

    @Override
    public Report byCity(String city) {
        try {
            var options = Map.of("q", city, "appId", "c559e941a0da745aa0139aef272bf16c");
            Call<OpenWeatherReport> openWeatherReportCall = this.openWeatherResource.get(options);
            OpenWeatherReport openWeatherReport = openWeatherReportCall.execute().body();
            return this.fromProviderReport(openWeatherReport);
        } catch (Exception e) {
            throw new RuntimeException("Error when calling remote provider", e);
        }
    }

    @Override
    public Report byZipCode(String zipCode) {
        return null;
    }


    @Override
    protected Report fromProviderReport(OpenWeatherReport providerReport) {
        var report = new Report();
        report.setCity(providerReport.getName());
        report.setHumidity(providerReport.getMain().getHumidity());
        report.setTemperature(providerReport.getMain().getTemp());
        report.setPressure(providerReport.getMain().getPressure());
        report.setMaxTemperature(providerReport.getMain().getTempMax());
        report.setMinTemperature(providerReport.getMain().getTempMin());
        return report;
    }
}
