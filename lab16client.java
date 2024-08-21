/*
16. Write a socket program for UDP Echo Client and Echo Server.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class lab16client {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");

            byte[] sendBuffer = "Hello, Server!".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 4445);
            socket.send(sendPacket);

            byte[] receiveBuffer = new byte[256];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Echo from server: " + received);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
