package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {


        // Create a server socket listening on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("basic.Server is listening on port 8080");


        // Accept a client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("basic.Client connected!");
        // Communicate with the client


        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        // Read the client's message


        String message = in.readLine();
        System.out.println("basic.Client says: " + message);


        // Send a response to the client
        out.println("Hello, basic.Client!");


        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}
