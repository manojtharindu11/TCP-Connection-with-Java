import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEchoServerSize2 {
    public static void main(String[] args) {
        int port = 8080;
        int numberOfThreads = 2;
        ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);

        try (ServerSocket serverSocket = new ServerSocket((port));) {
            System.out.println("Thread pool server (2 threads) starting on part: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                threadPool.execute(() -> handleClient(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String message = in.readLine();
            System.out.println("Client received: " + message);
            out.println("Echo: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
