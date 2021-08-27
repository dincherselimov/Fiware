package Curl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.Test;


/**
 * This class shows how to send a POST Request with JSON using Java 11 HttpClient API.
 */
public class HttpPost {

    @Test
    public void PostReq() throws IOException, InterruptedException {
         //URL to Fiware IoT Agent
        String postEndpoint = "http://192.168.0.104:4041/iot/devices";
        //String postEndpoint = "http://192.168.0.104:1026/v1/queryContext";

        // JSON input data
        String inputJson = "{\n" +
                        "    \"devices\": [\n" +
                        "        {\n" +
                        "            \"device_id\": \"sensor01\",\n" +
                        "            \"entity_name\": \"LivingRoomSensor\",\n" +
                        "            \"entity_type\": \"multiSensor\",\n" +
                        "            \"attributes\": [\n" +
                        "                  { \"object_id\": \"t\", \"name\": \"Temperature\", \"type\": \"celsius\" },\n" +
                        "                  { \"object_id\": \"l\", \"name\": \"Luminosity\", \"type\": \"lumens\" }\n" +
                        "            ]\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";

//                "{\n" +
//                        "    \"entities\": [\n" +
//                        "        {\n" +
//                        "            \"isPattern\": \"false\",\n" +
//                        "            \"id\": \"LivingRoomSensor\",\n" +
//                        "            \"type\": \"multiSensor\"\n" +
//                        "        }\n" +
//                        "    ]\n" +
//                        "}";

        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .header("Fiware-Service", "myHome")
                .header("Fiware-ServicePath","/environment")
                .header("Cache-Control", "no-cache")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());


    }
}