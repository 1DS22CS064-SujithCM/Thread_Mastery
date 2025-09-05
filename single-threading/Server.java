import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started... waiting for client");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String request = input.readLine();
            int num = Integer.parseInt(request);

            // 🧮 Perform task: factorial
            long result = factorial(num);
            Thread.sleep(10000); // Simulates a 10-second task

            output.println("Factorial of " + num + " is " + result);

            socket.close();
        }
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }
}
