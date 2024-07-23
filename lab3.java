/*
 * WAP to get and print the IP address of the given named host

a. www.scst.edu.np

b. www.google.com

c. www.facebook.com:
 */

package networkprogramming;
import java.net.*;
public class HostIpAddress {

    public static void main(String[] args) {
        printIpAddress("www.scst.edu.np");
        printIpAddress("www.google.com");
        printIpAddress("www.facebook.com");

    }
    
    public static void printIpAddress(String host){
        try{
            InetAddress add = InetAddress.getByName(host);
            System.out.println(add);
        }
        catch(UnknownHostException e ){
            System.out.println("erorr : " + e.getMessage());
        }
    }
}
