package Curl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class POST {

    /**
     * HTTP POST Request with HTTPUrlConnection
     * @throws IOException
     */
    public void PostRequest() throws IOException {

        // Set the URL
        String url = "http://192.168.0.104:1026/v1/queryContext";
        URL obj = new URL(url);

        //open the connection
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        //set the method type(POST OR GET)
        connection.setRequestMethod("POST");

        //set hte request properties(headers etc.)
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Fiware-Service", " myHome");
        connection.setRequestProperty("Fiware-ServicePath", "/environment");


        //Json formatted input string
        String jsonString = "{\n" +
                "    \"entities\": [\n" +
                "        {\n" +
                "            \"isPattern\": \"false\",\n" +
                "            \"id\": \"LivingRoomSensor\",\n" +
                "            \"type\": \"multiSensor\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        //make sure that will be able to write content to the connection output stream
        connection.setDoOutput(true);

        //Returns an output stream that writes to this connection
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        //Returns an input stream that reads from this open connection
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            //Printing the result
            System.out.println(response.toString());
        }
    }

}
