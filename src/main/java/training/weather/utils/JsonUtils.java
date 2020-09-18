package training.weather.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils {
    /**
     * From a received JsonObject gets a value searching by key
     * @param json JsonObject to look in
     * @param key Key to find in JsonObject
     * @return The value for given key
     */
    public  static  String GetJsonValue(JSONObject json, String key){
        return  json.get(key).toString();
    }


    /**
     * Looks in Json array object. Returns the first JsonObject which matches the key value given
     * @param jsonArr JsonArray to loop
     * @param key Key to find
     * @param value Value to find for given key
     * @return JsonObject which has a key=key and a value=value
     */
    public static JSONObject GetJsonObjectFromKeyValue(JSONArray jsonArr, String key, String value){
        boolean found = false;
        int counter = 0;
        JSONObject result = null;
        while (!found || counter < jsonArr.length()){
            if (value.equals(GetJsonValue(jsonArr.getJSONObject(counter),key))) {
                result = jsonArr.getJSONObject(counter);
                found = true;
            }
            counter++;
        }
        return  result;
    }
}
