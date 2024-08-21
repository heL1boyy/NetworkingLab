/*
15 : Write a program for a DayTime protocol client using a UDP socket.
 */


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.net.InetAddress;
import java.util.Date;

public class lab15sever {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(1300)) {
            byte[] buffer = new byte[256];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                buffer = currentTime.getBytes();

                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();

                packet = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

