package training.weather;

import java.io.IOException;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import training.weather.clients.RequestClient;
import training.weather.utils.DateUtils;
import training.weather.utils.JsonUtils;

public class WeatherForecast {

	public String getCityWeather(String city, Date datetime) throws IOException {
		if (datetime == null) {
			datetime = new Date();
		}
		if (datetime.before(DateUtils.AddDays(new Date(),7))) {
			RequestClient client = new RequestClient();
			JSONArray jsonArray = new JSONArray(client.Get("https://www.metaweather.com/api/location/search/?query=" + city));
			String cityId = JsonUtils.GetJsonValue(jsonArray.getJSONObject(0),"woeid");
			JSONArray results = new JSONObject(client.Get("https://www.metaweather.com/api/location/" + cityId)).getJSONArray("consolidated_weather");

			String dateFormatted = DateUtils.FormatDate("yyyy-MM-dd", datetime);
			JSONObject requestedDayWeather = JsonUtils.GetJsonObjectFromKeyValue(results,"applicable_date", dateFormatted);
			return JsonUtils.GetJsonValue(requestedDayWeather,"weather_state_name" );
		}
		return "";
	}
}
