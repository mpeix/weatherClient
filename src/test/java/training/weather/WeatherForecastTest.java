package training.weather;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class WeatherForecastTest {

	@Test
	public void GetCityWeatherTest() throws IOException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String forecast = weatherForecast.getCityWeather("Madrid", toDate(LocalDate.now().plusDays(1)));
		assertNotNull(forecast);
	}

	private Date toDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}