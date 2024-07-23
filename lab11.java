/*
lab11 : Write a program to find the TCP/UDP ports running in your local machine. 
(Hint: Use class name: LowPortScanner((1-1024)) Hint: Scan up to 65535,
and use DatagramSocket for UDP and socket for TCP)
 */
package networkprogramming;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

public class LowPortScanner {
    public static void main(String[] args) {
        int startPort = 1;
        int endPort = 1024;

        System.out.println("Scanning TCP ports...");
        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress("localhost", port), 200);
                System.out.println("TCP port " + port + " is open");
            } catch (IOException e) {
                // Port is closed or not responding
            }
        }

        System.out.println("\nScanning UDP ports...");
        for (int port = startPort; port <= endPort; port++) {
            try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
                datagramSocket.setSoTimeout(200);
                datagramSocket.connect(new InetSocketAddress("localhost", port));
                System.out.println("UDP port " + port + " is open");
            } catch (IOException e) {
                // Port is closed or not responding
            }
        }
    }
}

