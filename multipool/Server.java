import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Thread Pool Server started...");

        // Create a fixed thread pool of size 5
        ExecutorService pool = Executors.newFixedThreadPool(5);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Submit task to the thread pool
            pool.execute(new ClientHandler(socket));
        }
    }
}

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
            System.out.println("Processing request for: " + num);

            // Simulate delay
            Thread.sleep(10000);

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
