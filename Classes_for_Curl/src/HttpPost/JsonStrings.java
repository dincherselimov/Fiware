package HttpPost;

/**
 * This class stores all these string as we assume to use them as a part of curl command
 * Accessing them with getters
 * Mainly invoked in POST.java class
 */
public class JsonStrings {
    //Working with ngsi-v2(request 2)
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    private String ngsi_v2 = "{\"id\":\"urn:ngsi-ld:Store:001\",\"type\":\"Store\",\"address\":{\"type\":\"PostalAddress\",\"value\":{\"streetAddress\":\"Bornholmer Straße 65\",\"addressRegion\":\"Berlin\",\"addressLocality\":\"Prenzlauer Berg\",\"postalCode\":\"10439\"},\"metadata\":{\"verified\":{\"value\":true,\"type\":\"Boolean\"}}},\"location\":{\"type\":\"geo:json\",\"value\":{\"type\":\"Point\",\"coordinates\":[13.3986,52.5547]}},\"name\":{\"type\":\"Text\",\"value\":\"Bösebrücke Einkauf\"}}";
    private String obtain_data = "options=keyValues";
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    //Provisioning a group via Ultralight iotA
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    private String Iotul = "{\"services\":[{\"apikey\":\"4jggokgpepnvsb2uv4s40d59ovv\",\"cbroker\":\"http://orion:1026\",\"entity_type\":\"Thing\",\"resource\":\"/iot/d\"}]}";

    //provisioning a ultralight iotA device
    private String UlDevice = "{\"devices\":[{\"device_id\":\"motion066\",\"entity_name\":\"urn:ngsi-ld:Motion:066\",\"entity_type\":\"Motion\",\"timezone\":\"Europe/Berlin\",\"attributes\":[{\"object_id\":\"c\",\"name\":\"count\",\"type\":\"Integer\"}],\"static_attributes\":[{\"name\":\"refStore\",\"type\":\"Relationship\",\"value\":\"urn:ngsi-ld:Store:066\"}]}]}";
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    //LWM2M IoTA
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    private String LWMSendCommand = "{\"contextElements\":[{\"type\":\"Car\",\"isPattern\":\"false\",\"id\":\"Car:car01\",\"attributes\":[{\"name\":\"Battery\",\"type\":\"number\",\"value\":\"50\"}]}],\"updateAction\":\"UPDATE\"}";

    private String LWMSeeEntity = "{\"entities\":[{\"type\":\"Car\",\"isPattern\":\"false\",\"id\":\"Car:car01\"}]}";

    private String LWM2DeviceProvisioning = "{\"devices\":[{\"device_id\":\"car01\",\"entity_type\":\"Car\",\"attributes\":[{\"name\":\"Battery\",\"type\":\"number\"}],\"lazy\":[{\"name\":\"Message\",\"type\":\"string\"}],\"commands\":[{\"name\":\"Position\",\"type\":\"location\"}],\"internal_attributes\":{\"lwm2mResourceMapping\":{\"Battery\":{\"objectType\":7395,\"objectInstance\":0,\"objectResource\":1},\"Message\":{\"objectType\":7395,\"objectInstance\":0,\"objectResource\":2},\"Position\":{\"objectType\":7395,\"objectInstance\":0,\"objectResource\":3}}}}]}";

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    //JSON IoTA
    private String DeviceProvisioning = "{\"devices\":[{\"device_id\":\"sensor33333\",\"entity_name\":\"CRoomSensor\",\"entity_type\":\"multiSensor\",\"attributes\":[{\"object_id\":\"t\",\"name\":\"Temperature\",\"type\":\"celsius\"},{\"object_id\":\"l\",\"name\":\"Luminosity\",\"type\":\"lumens\"}]}]}";

    private String SetValues = "{\"value\":\"31.5\"}";

    private String getPublishedInfo = "{\"entities\":[{\"isPattern\":\"false\",\"id\":\"CRoomSensor\",\"type\":\"multiSensor\"}]}";

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    public String getObtain_data(){return this.obtain_data;}

    public String getNgsi_v2(){return this.ngsi_v2;}

    public String getUlDevice(){
        return this.UlDevice;
    }

    public String getIotul() {
        return  this.Iotul;
    }

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


