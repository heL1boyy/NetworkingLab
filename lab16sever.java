/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class lab16sever {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(4445)) {
            byte[] buffer = new byte[256];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();

                packet = new DatagramPacket(buffer, packet.getLength(), clientAddress, clientPort);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

