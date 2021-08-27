package Curl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Http_Con {

    private static HttpURLConnection connection;

    public static void main(String[] args) throws IOException {

        Http_Con connection = new Http_Con();
        //call the getRequest method
        connection.GetRequest();
        //call the postRequest
        connection.PostRequest();

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
        connection.setRequestProperty("Fiware-Service"," myHome");
        connection.setRequestProperty("Fiware-ServicePath","/environment");


        //make sure that will be able to write content to the connection output stream
        connection.setDoOutput(true);

        //Json formatted input string
        String jsonInputString = "";

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
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


}

