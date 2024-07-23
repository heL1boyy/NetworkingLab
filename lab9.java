/*
lab9 : WAP that uses the HEAD request method and prints the last time a file on a server was modified 
(Given URL: http://scst.edu.np/uploads/content image/BCA Course Structure.png)
 */
package networkprogramming;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class HeadRequestExample {
    public static void main(String[] args) {
        String urlString = "http://scst.edu.np/wp-content/uploads/2022/07/s-1-e1716269987777.jpg";
        
        try {
            // Create a URL object
            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method to HEAD
            connection.setRequestMethod("HEAD");

            // Connect to the server
            connection.connect();

            // Get the last modified time from the header
            long lastModified = connection.getLastModified();

            if (lastModified == 0) {
                System.out.println("Last modified information is not available.");
            } else {
                Date date = new Date(lastModified);
                System.out.println("Last Modified: " + date);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
