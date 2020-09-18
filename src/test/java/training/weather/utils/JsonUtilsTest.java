package training.weather.utils;
import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class JsonUtilsTest {
    String jsonTestString = "{ \"company\": \"BMW\", \"name\":\"Serie2\", \"wheels\":\"4\", \"driver\" :  [{\"name\" : \"Colin\", \"WordTitles\":\"1\" }, {\"name\":\"Sebastian\",\"WordTitles\":\"9\" } ] }";

    @Test
    public  void GetJsonValueTest(){
        String carName = JsonUtils.GetJsonValue(new JSONObject(jsonTestString), "name");
        assertEquals(carName,"Serie2");
    }

    @Test
    public  void GetJsonObjectFromKeyValueTest(){
        JSONArray drivers = new JSONArray((new JSONObject(jsonTestString).get("driver")).toString());
        JSONObject sLoeb = drivers.getJSONObject(1);
        assertEquals(sLoeb, JsonUtils.GetJsonObjectFromKeyValue(drivers,"name","Sebastian"));
    }
}
