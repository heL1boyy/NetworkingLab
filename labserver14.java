
// 14 :  Write a program for basic client-server communication using TCP sockets.
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class labserver14 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234...");

            Socket socket = serverSocket.accept();
            System.out.println(" Success : Client connected.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;

            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);
                output.println("Server received: " + clientMessage);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
