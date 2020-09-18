package training.weather;

import java.io.IOException;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import training.weather.clients.RequestClient;
import training.weather.utils.Constants;
import training.weather.utils.DateUtils;
import training.weather.utils.JsonUtils;

public class WeatherForecast {

	public String getCityWeather(String city, Date datetime) throws IOException {
		if (datetime == null) {
			datetime = new Date();
		}
		if (datetime.before(DateUtils.AddDays(new Date(),Constants.ForecastDays))) {
			RequestClient reqClient = new RequestClient();
			JSONArray cityInfo = new JSONArray(reqClient.Get(Constants.SearchUrl + city));
			if(cityInfo.length() > 0){
				String cityId = JsonUtils.GetJsonValue(cityInfo.getJSONObject(0), Constants.CityIdKey);
				JSONArray results = new JSONObject(reqClient.Get(Constants.LocationUrl + cityId)).getJSONArray(Constants.ConsolidatedKey);

				String dateFormatted = DateUtils.FormatDate(Constants.ApplicableDateFormat, datetime);
				JSONObject requestedDayWeather = JsonUtils.GetJsonObjectFromKeyValue(results,Constants.ApplicableDateKey, dateFormatted);
				return JsonUtils.GetJsonValue(requestedDayWeather, Constants.WeatherStateNameKey);
			}
		}
		return "";
	}
}
