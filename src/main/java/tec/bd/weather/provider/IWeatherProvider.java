package tec.bd.weather.provider;

import tec.bd.weather.model.Report;

public interface IWeatherProvider {

    Report byCity(String city);

    Report byZipCode(String zipCode);

}
