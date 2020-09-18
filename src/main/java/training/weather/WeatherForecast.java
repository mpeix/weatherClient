package training.weather;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.api.client.json.Json;
import org.json.JSONArray;
import org.json.JSONObject;
import training.weather.clients.RequestClient;
import training.weather.utils.DateUtils;

public class WeatherForecast {

	public String getCityWeather(String city, Date datetime) throws IOException {
		if (datetime == null) {
			datetime = new Date();
		}
		if (datetime.before(DateUtils.AddDays(new Date(),7))) {
			RequestClient client = new RequestClient();
			JSONArray jsonArray = new JSONArray(client.Get("https://www.metaweather.com/api/location/search/?query=" + city));
			String cityId = jsonArray.getJSONObject(0).get("woeid").toString();
			JSONArray results = new JSONObject(client.Get("https://www.metaweather.com/api/location/" + cityId)).getJSONArray("consolidated_weather");
			for (int i = 0; i < results.length(); i++) {
				if (DateUtils.FormatDate("yyyy-MM-dd", datetime)
					.equals(results.getJSONObject(i).get("applicable_date").toString())) {
					return results.getJSONObject(i).get("weather_state_name").toString();
				}
			}
		}
		return "";
	}
}
