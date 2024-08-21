/*
17) Write a program that can send “HELLO” messages to the Multicast group
where the receiver should be ready to receive the messages to the port number 
where MulticastSocket is bound.
 */


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class lab17sender {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.0"; // Multicast address
        int port = 4446; // Port number

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            String message = "HELLO";
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);
            System.out.println("Message sent to multicast group: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
