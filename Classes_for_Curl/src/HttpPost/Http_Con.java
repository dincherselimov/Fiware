package HttpPost;


import PahoMqttClient.PAHO;

public class Http_Con {

    public static void main(String[] args) throws Exception {

        PAHO paho = new PAHO();

        GET get = new GET();

        POST post = new POST();

        PostSendMeasures postSendMeasures = new PostSendMeasures();

         //call the PahoMqttClient method
        //paho.PahoMqttClient();

        //call the getRequest method
        //get.GetRequest();

        //call the postRequest method
        //post.PostRequest();

        //call the PostSendMeasure method
        //postSendMeasures.PostSendMeasure();

    }
}







