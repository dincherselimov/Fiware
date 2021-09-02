package HttpPost;

public class JsonStrings {

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    //LWM2M IoTA
    private String LWMSendCommand = "{\"contextElements\":[{\"type\":\"Car\",\"isPattern\":\"false\",\"id\":\"Car:car01\",\"attributes\":[{\"name\":\"Battery\",\"type\":\"number\",\"value\":\"50\"}]}],\"updateAction\":\"UPDATE\"}";

    private String LWMSeeEntity = "{\"entities\":[{\"type\":\"Car\",\"isPattern\":\"false\",\"id\":\"Car:car01\"}]}";

    private String LWM2DeviceProvisioning = "{\"devices\":[{\"device_id\":\"car01\",\"entity_type\":\"Car\",\"attributes\":[{\"name\":\"Battery\",\"type\":\"number\"}],\"lazy\":[{\"name\":\"Message\",\"type\":\"string\"}],\"commands\":[{\"name\":\"Position\",\"type\":\"location\"}],\"internal_attributes\":{\"lwm2mResourceMapping\":{\"Battery\":{\"objectType\":7395,\"objectInstance\":0,\"objectResource\":1},\"Message\":{\"objectType\":7395,\"objectInstance\":0,\"objectResource\":2},\"Position\":{\"objectType\":7395,\"objectInstance\":0,\"objectResource\":3}}}}]}";

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    //JSON IoTA
    private String DeviceProvisioning = "{\"devices\":[{\"device_id\":\"sensor7877\",\"entity_name\":\"LivingRoomSensor\",\"entity_type\":\"multiSensor\",\"attributes\":[{\"object_id\":\"t\",\"name\":\"Temperature\",\"type\":\"celsius\"},{\"object_id\":\"l\",\"name\":\"Luminosity\",\"type\":\"lumens\"}]}]}";

    private String SetValues = "{\"value\":\"31.5\"}";

    private String getPublishedInfo = "{\"entities\":[{\"isPattern\":\"false\",\"id\":\"LivingRoomSensor\",\"type\":\"multiSensor\"}]}";

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    public String getLWMSendCommand(){
        return this.LWMSendCommand;
    }

    public String getLWMSeeEntity(){
        return this.LWMSeeEntity;
    }

    public String getLWM2DeviceProvisioning(){
        return this.LWM2DeviceProvisioning;
    }

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


