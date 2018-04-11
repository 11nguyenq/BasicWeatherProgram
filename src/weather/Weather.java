package Weather;

import java.io.*;
import java.util.*;
import java.net.*;

class Weather {

    public static void getWeatherByCityID(int cityid) {
        System.out.println("Calling Function getWeatherByCityID");
            // Need URL for weather api
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?id=" + cityid + "&APPID=7ce120bf3772ee412e861e41b944a692";
            // instantiate variable url
        URL url = null;
            // instantiate Stringbuilder
        StringBuilder result = new StringBuilder();

        try {
              // Open connection to URL
            url = new URL(urlString);
            HttpURLConnection service = (HttpURLConnection) url.openConnection();
            service.setRequestMethod("GET");
              // Read data from API and Write
            BufferedReader rd = new BufferedReader(new InputStreamReader(service.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            // Close Buffered Reader
            rd.close();
            
            System.out.print(result.toString());
        } 
        catch (MalformedURLException e) {
            System.out.println("error with the string format");
        }
        catch (IOException ioe) {
            System.out.println("Got IO Exception");

            if (url != null) {
                ArrayList<String> strings = new ArrayList<String>();
                for (String string : strings) {
                    System.out.println(string);
                }
            } else {
                System.out.println("Value is null!");
            }
        }
    }

    public static void main(String[] args) {
        Weather.getWeatherByCityID(4058076);
        Weather.getWeatherByCityID(5506956);
        Weather.getWeatherByCityID(5368381);
        // You can find list of City ID's here: http://bulk.openweathermap.org/sample/
    }
}
