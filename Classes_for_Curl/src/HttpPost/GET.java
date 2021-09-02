package HttpPost;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GET {

    public void GetRequest() {
        BufferedReader reader;
        String lines;
        StringBuilder responseContent = new StringBuilder();
        try {
            //set the url
            URL url = new URL("http://192.168.0.104:4041/iot/devices");

            //open the connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

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
}