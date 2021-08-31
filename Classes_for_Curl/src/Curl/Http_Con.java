package Curl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class Http_Con {

    private static HttpURLConnection connection;

    public static void main(String[] args) throws Exception {

        Http_Con connection = new Http_Con();
        //call the getRequest method
        connection.GetRequest();

        //call the postRequest method
        connection.PostRequest();

        //call the sendPost method
        connection.sendPost();


    }

    public void GetRequest() {
        BufferedReader reader;
        String lines;
        StringBuilder responseContent = new StringBuilder();
        try {
            //set the url
            URL url = new URL("http://192.168.0.104:4041/iot/devices");
            //open the connection
            connection = (HttpURLConnection) url.openConnection();

            //set the request method and timeout
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            //set request properties(in this case headers)
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Fiware-Service", " myHome");
            connection.setRequestProperty("Fiware-ServicePath", "/environment");

            //get the response code(200 should be OK)
            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((lines = reader.readLine()) != null) {
                    responseContent.append(lines);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((lines = reader.readLine()) != null) {
                    responseContent.append(lines);
                }
                reader.close();
            }
            //print the response content(result)
            System.out.println(responseContent.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //variant 1 za post
    public void PostRequest() throws IOException {
        //set the url
        String url = "http://192.168.0.104:4041/iot/devices";
        URL obj = new URL(url);
        //open the connection
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        //set the method type(POST OR GET)
        connection.setRequestMethod("POST");

        //set hte request properties(headers etc.)
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Fiware-Service", " myHome");
        connection.setRequestProperty("Fiware-ServicePath", "/environment");


        //Json formatted input string
        String jsonString = """
                {
                  "devices": [
                    {
                      "device_id": "sensor7777",
                      "entity_name": "LivingRoomSensor",
                      "entity_type": "multiSensor",
                      "attributes": [
                        {
                          "object_id": "t",
                          "name": "Temperature",
                          "type": "celsius"
                        },
                        {
                          "object_id": "l",
                          "name": "Luminosity",
                          "type": "lumens"
                        }
                      ]
                    }
                  ]
                }""";
        //Gson gson = new Gson();
        //convert java object to JSON format
        //String json = gson.toJson(devices1);

        //System.out.println(json);

        //make sure that will be able to write content to the connection output stream
        connection.setDoOutput(true);


        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            //print the result
            System.out.println(response.toString());
        }
    }


    // variant 2 za post
    public void sendPost() throws IOException {

        String url2 = "http://192.168.0.104:4041/iot/devices";

        HttpURLConnection httpClient = (HttpURLConnection) new URL(url2).openConnection();

        //add request header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


        //set hte request properties(headers etc.)
        httpClient.setRequestProperty("Content-Type", "application/json; utf-8");
        httpClient.setRequestProperty("Accept", "application/json");
        httpClient.setRequestProperty("Fiware-Service", " myHome");
        httpClient.setRequestProperty("Fiware-ServicePath", "/environment");


        String urlParameters = "{\n" +
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

        // Send post request
        httpClient.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url2);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            //print result
            System.out.println(response.toString());
        }
    }
}

