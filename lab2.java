/*
 * WAP that lists all the network interfaces of your machine (ie localhost).
 */

package networkprogramming;

import java.net.*;
import java.util.*;

public class ListNetworkInterface {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Network interface : " + networkInterface.getName());
            }
        } catch (SocketException e) {
            System.out.println("error :" + e.getMessage());
        }
    }
}
