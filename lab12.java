/*
lab12 : Write a program to display the socket information. (address, port, local address, local port) Write a

program to Implement your own daytime server.
 */
package networkprogramming;

import java.io.IOException;
import java.net.Socket;

public class SocketInfo {
    public static void main(String[] args) {
        String hostname = "example.com"; // Change to any hostname you want to connect
        int port = 80; // Common HTTP port

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to " + socket.getRemoteSocketAddress());
            System.out.println("Remote Address: " + socket.getInetAddress());
            System.out.println("Remote Port: " + socket.getPort());
            System.out.println("Local Address: " + socket.getLocalAddress());
            System.out.println("Local Port: " + socket.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
