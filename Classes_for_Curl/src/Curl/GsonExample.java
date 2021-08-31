package Curl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class GsonExample {
    public static void main(String[] args) {
        HashMap<Integer, Devices> devicesHashMap = new HashMap<>();

        devicesHashMap.put(1, new Devices("sensor01", "Alex","multiSensor", """
                [
                                                  { "object_id": "t", "name": "Temperature", "type": "celsius" },
                                                  { "object_id": "l", "name": "Luminosity", "type": "lumens" }
                                            ]"""));

        //Deep clone
        Gson gson = new Gson();
        String jsonString = gson.toJson(devicesHashMap);

        Type type = new TypeToken<HashMap<Integer, Devices>>(){}.getType();
        HashMap<Integer, Devices> clonedMap = gson.fromJson(jsonString, type);

        System.out.println(clonedMap);
    }
}
