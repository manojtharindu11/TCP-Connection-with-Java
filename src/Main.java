
// Import required packages
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {


        // Connect to the server on localhost at port 8080
        Socket socket = new Socket("localhost", 8080);

        // Send data to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello World");

        // Receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String response = in.readLine();

        System.out.println("Server response : " + response);

        // Close the connection
        socket.close();
    }
}