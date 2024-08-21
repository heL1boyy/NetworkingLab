//14 :  Write a program for basic client-server communication using TCP sockets.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class labclient14 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String userInput;

            while ((userInput = consoleReader.readLine()) != null) {
                output.println(userInput);
                System.out.println("Server response: " + input.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
