package HttpPost;


import PahoMqttClient.PAHO;

public class Http_Con {

    /**
     * In this class methods from different classes(POST,GET) are invoked and compiled
     */
    public static void main(String[] args) throws Exception {

        PAHO paho = new PAHO();

        GET get = new GET();

        POST post = new POST();

        PostSendMeasures postSendMeasures = new PostSendMeasures();

         //call the PahoMqttClient method
        //paho.PahoMqttClient();

        //call the postRequest method
        //post.PostRequest();

        //call the getRequest method
        //get.GetRequest();

        //call the PostSendMeasure method
        //postSendMeasures.PostSendMeasure();

    }
}







