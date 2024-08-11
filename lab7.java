
package networkprogramming;

import java.net.MalformedURLException;
import java.net.URL;

public class CompareHostnames {
    public static void main(String[] args) {
        try {
            // Create URL objects for the given URLs
            URL url1 = new URL("http://www.ibiblio.org");
            URL url2 = new URL("http://helios.ibiblio.org");

            // Compare hostnames
            if (url1.getHost().equals(url2.getHost())) {
                System.out.println("The hostnames are the same.");
            } else {
                System.out.println("The hostnames are different.");
            }

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL.");
        }
    }
}
