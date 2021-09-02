package HttpPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PostSendMeasures {

    /**
     * HTTP POST Request with HTTPUrlConnection
     */
    public void PostSendMeasure() throws IOException {
        JsonStrings strings = new JsonStrings();

        // Set the URL
        String url = "http://192.168.0.104:1026/v1/contextEntities/LivingRoomSensor/attributes/Temperature";
        URL obj = new URL(url);

        //open the connection
        HttpURLConnection connection_sec = (HttpURLConnection) obj.openConnection();

        //set the method type(POST OR GET)
        connection_sec.setRequestMethod("POST");

        //set hte request properties(headers etc.)
        connection_sec.setRequestProperty("Content-Type", "application/json");
        connection_sec.setRequestProperty("Accept", "application/json");
        connection_sec.setRequestProperty("Fiware-Service", " myHome");
        connection_sec.setRequestProperty("Fiware-ServicePath", "/environment");


        //Json formatted input string
        String jsonString = strings.getSetValues();

        //make sure that will be able to write content to the connection output stream
        connection_sec.setDoOutput(true);

        //Returns an output stream that writes to this connection
        try (OutputStream os = connection_sec.getOutputStream()) {
            byte[] input = jsonString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        //Returns an input stream that reads from this open connection
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection_sec.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            //Printing the result
            System.out.println(response.toString());
            System.out.println("Code Successfully Compiled");
        }
    }
}



