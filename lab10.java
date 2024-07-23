/*
lab10 : Write a client side program for daytime service using socket. (Specify host name: https://ntppool.org/zone/np.)
 */
package networkprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DaytimeClient {
    public static void main(String[] args) {
        String hostname = "time.nist.gov"; // Example of a daytime server
        int port = 13; // Daytime protocol runs on port 13

        try (Socket socket = new Socket(hostname, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String currentTime;
            while ((currentTime = reader.readLine()) != null) {
                System.out.println("Current time from server: " + currentTime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

