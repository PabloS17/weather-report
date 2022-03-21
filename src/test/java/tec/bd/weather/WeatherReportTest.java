package tec.bd.weather;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherReportTest {

    @Mock
    IWeatherProvider weatherProvider;

    @InjectMocks
    WeatherReport weatherReport;

    @Test
    public void GetWeatherReportByCity() throws Exception {

        var report = mock(Report.class);
        given(report.getCity()).willReturn("Alajuela");
        given(report.getTemperature()).willReturn(26f);
        given(report.getHumidity()).willReturn(26f);
        given(report.getMaxTemperature()).willReturn(27f);
        given(report.getMinTemperature()).willReturn(25f);
        given(report.getPressure()).willReturn(100f);

//        var report = new Report();
//        report.setCity("Alajuela");

        given(weatherProvider.byCity(anyString())).willReturn(report);

        var actual = weatherReport.getByCity("Alajuela");

        verify(weatherProvider, times(1)).byCity("Alajuela");

        assertThat(actual.getCity()).isEqualTo(report.getCity());
        assertThat(actual.getTemperature()).isEqualTo(report.getTemperature());
        assertThat(actual.getHumidity()).isEqualTo(report.getHumidity());
        assertThat(actual.getPressure()).isEqualTo(report.getPressure());
        assertThat(actual.getMaxTemperature()).isEqualTo(report.getMaxTemperature());
        assertThat(actual.getMinTemperature()).isEqualTo(report.getMinTemperature());
    }


}
