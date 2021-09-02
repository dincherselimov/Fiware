package HttpPost;

public class JsonStrings {
    private String DeviceProvisioning = """
            {
                "devices": [
                    {
                        "device_id": "sensor7877",
                        "entity_name": "LivingRoomSensor",
                        "entity_type": "multiSensor",
                        "attributes": [
                              { "object_id": "t", "name": "Temperature", "type": "celsius" },
                              { "object_id": "l", "name": "Luminosity", "type": "lumens" }
                        ]
                    }
                ]
            }""";

    private String SetValues =
            """
            {
            "value" : "300"
            }""";

    private String getPublishedInfo = """
            {
                "entities": [
                    {
                        "isPattern": "false",
                        "id": "LivingRoomSensor",
                        "type": "multiSensor"
                    }
                ]
            }""";

    public String getGetPublishedInfo(){
        return this.getPublishedInfo;
    }

    public String getDeviceProvisioning(){
        return this.DeviceProvisioning;
    }

    public String getSetValues(){
        return  this.SetValues;
    }
}


