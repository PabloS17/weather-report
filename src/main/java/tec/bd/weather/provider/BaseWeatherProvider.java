package tec.bd.weather.provider;

import tec.bd.weather.model.Report;

public abstract class BaseWeatherProvider<T> implements IWeatherProvider {

    protected abstract Report fromProviderReport(T providerReport);

}
