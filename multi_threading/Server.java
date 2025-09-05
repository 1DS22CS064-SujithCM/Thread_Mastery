import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Multithreaded Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle client in a separate thread
            ClientHandler handler = new ClientHandler(socket);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}

// 🧵 Thread to handle each client
class ClientHandler implements Runnable {
    private Socket socket;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String request = input.readLine();

            if (request.equalsIgnoreCase("exit")) {
                System.out.println("Received exit. Closing client connection.");
                socket.close();
                return;
            }

            int num = Integer.parseInt(request);

            // Simulate processing time
            Thread.sleep(10000); // 10 seconds

            long result = factorial(num);
            output.println("Factorial of " + num + " is " + result);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }
}

