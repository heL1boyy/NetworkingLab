/*
lab8 : List three predefined cookie Policy in java? WAP in java
, A cookie policy that blocks all .gov cookies but allows other domains.
 */
package networkprogramming;

import java.net.HttpCookie;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class CustomCookiePolicy {
    public static void main(String[] args) {
        // Create an HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create an HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://example.com"))
                .build();

        try {
            // Send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Get cookies from the response headers
            List<String> cookiesHeader = response.headers().firstValue("Set-Cookie").stream().collect(Collectors.toList());

            // Filter cookies
            List<String> filteredCookies = cookiesHeader.stream()
                    .filter(cookie -> !cookie.contains(".gov"))
                    .collect(Collectors.toList());

            // Print filtered cookies
            filteredCookies.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

