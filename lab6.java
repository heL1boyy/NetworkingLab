/*
 WAP to parse the given URL/split the given URL (Hint: Parse protocol or scheme, user info, host

address, port, path, ref, query string)

a."http://www.example.com:80/index.html"	

b." ftp://mp3:mp3@138.247.121.61:21000/c%3a/"
 */
package networkprogramming;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a URL: ");
        String urlString = scanner.nextLine();

        try {
            URL url = new URL(urlString);

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("User Info: " + (url.getUserInfo() != null ? url.getUserInfo() : "Not present"));
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + (url.getPort() != -1 ? url.getPort() : "Default"));
            System.out.println("Path: " + (url.getPath() != null ? url.getPath() : "Not present"));
            System.out.println("Reference (Fragment): " + (url.getRef() != null ? url.getRef() : "Not present"));
            System.out.println("Query: " + (url.getQuery() != null ? url.getQuery() : "Not present"));

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL.");
        }

        scanner.close();
    }
}
