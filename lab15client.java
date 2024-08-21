

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class lab15client {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] buffer = new byte[256];

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 1300);
            socket.send(packet);

            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Daytime from server: " + received);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

