package Curl;


public class Devices implements Comparable<Devices>{

    private String device_id;
    private String entity_name;
    private String entity_type;
    private String attributes;

    public Devices(String device_id, String entity_name, String entity_type, String attributes){
        this.device_id = device_id;
        this.entity_name = entity_name;
        this.entity_type = entity_type;
        this.attributes = attributes;
    }
    public String getDevice_id() {
        return device_id;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public String getEntity_type() {
        return entity_type;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }


    @Override
    public int compareTo(Devices o) {
        return this.getDevice_id().compareTo(o.getDevice_id());
    }

    @Override
    public String toString() {
        return "Device[device_id=" + device_id + ", entity_name=" + entity_name + ", " +
                "entity_type=" + entity_type + ", attributes=" + attributes+"]";
    }
}
