


/*WAP to determine whether an IP address is v4 or v6? (Possibly to the command line argument) */
package networkprogramming;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ip = scanner.nextLine();

        try {
            InetAddress address = InetAddress.getByName(ip);
            if (address instanceof java.net.Inet4Address) {
                System.out.println("The IP address " + ip + " is IPv4.");
            } else if (address instanceof java.net.Inet6Address) {
                System.out.println("The IP address " + ip + " is IPv6.");
            } else {
                System.out.println("Unknown IP address type.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address.");
        }

        scanner.close();
    }
}
