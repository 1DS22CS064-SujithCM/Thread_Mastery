import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public void run() throws IOException {
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");

        System.out.println("Connecting to server on port " + port + "...");
        Socket socket = new Socket(address, port);
        System.out.println("Connected to: " + socket.getRemoteSocketAddress());

        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send message to server
        String message = "Hello World from client: " + socket.getLocalSocketAddress();
        toSocket.println(message);
        System.out.println("Sent to server: " + message);

        // Receive response
        String response = fromSocket.readLine();
        System.out.println("Received from server: " + response);

        // Cleanup
        toSocket.close();
        fromSocket.close();
        socket.close();
        System.out.println("Connection closed.");
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
