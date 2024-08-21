/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class lab17receiver {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.0"; // Multicast address
        int port = 4446; // Port number

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            socket.joinGroup(group);

            System.out.println("Waiting for multicast message...");

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Message received: " + received);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

