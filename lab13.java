// 13. Write a program to display the socket information (address, port, local address, local port). Write a program to implement your own daytime server.//13  Write a program for a daytime server using Thread pool.


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class lab13 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10); // Create a thread pool with 10 threads

        try (ServerSocket serverSocket = new ServerSocket(1300)) {
            System.out.println("Daytime Server with Thread Pool is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                executor.execute(new DaytimeTask(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DaytimeTask implements Runnable {
    private Socket clientSocket;

    public DaytimeTask(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(currentTime);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

