
/*
 * Test the characteristics of a given IP address

a. 127.0.0.1

b. 0::1 (loopback | global | unicast)
 */
package networkprogramming;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPAddressCharacteristics {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ip = scanner.nextLine();

        try {
            InetAddress address = InetAddress.getByName(ip);
            
            // Determine if the IP address is IPv4 or IPv6
            if (address.getHostAddress().contains(":")) {
                System.out.println("The IP address " + ip + " is IPv6.");
            } else {
                System.out.println("The IP address " + ip + " is IPv4.");
            }
            
            // Determine characteristics of the IP address
            if (address.isLoopbackAddress()) {
                System.out.println("The IP address " + ip + " is a loopback address.");
            } else if (address.isSiteLocalAddress()) {
                System.out.println("The IP address " + ip + " is a site-local address.");
            } else if (address.isLinkLocalAddress()) {
                System.out.println("The IP address " + ip + " is a link-local address.");
            } else if (isGlobalUnicast(address)) {
                System.out.println("The IP address " + ip + " is a global unicast address.");
            } else {
                System.out.println("The IP address " + ip + " has an unknown characteristic.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address.");
        }

        scanner.close();
    }
    
    // Check if an IP address is a global unicast address
    private static boolean isGlobalUnicast(InetAddress address) {
        return !address.isLoopbackAddress() && 
               !address.isLinkLocalAddress() && 
               !address.isSiteLocalAddress() && 
               !address.isMulticastAddress();
    }
}

