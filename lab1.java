
package networkprogramming;
import java.net.*;
public class IpAddress {
    private static String getMacAddress(InetAddress ip) throws SocketException{
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        byte[] macArray = network.getHardwareAddress();
        StringBuilder sb = new StringBuilder();
       for (int i = 0 ; i <macArray.length ; i++){
           sb.append(String.format("%02X%s", macArray[i], 
                   (i < macArray.length - 1) ? "-" : ""));
       }
        return sb.toString();
    }
    public static void main(String[] args) {
        try{
            InetAddress add = InetAddress.getLocalHost();
            String address = add.getHostAddress();
            String mac = getMacAddress(add);
            System.out.println("IP Address : " + address);
            System.out.println("Mac Address : " + mac);
        }catch(SocketException | UnknownHostException e){
            System.out.println(e);
        }
    }
}
