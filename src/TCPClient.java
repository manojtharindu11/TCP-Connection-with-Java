import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) {
        int port = 8088;
        String host = "localhost";
        int numberOfRequests = 1000;
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < numberOfRequests; i++) {
            try {
                Socket socket = new Socket(host,port);
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter writer = new PrintWriter(outputStream,true);

                String message = "Hello, server! Request number: "+(i+1);
                writer.println(message);
                String response = reader.readLine();
                System.out.println(response);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Total time for: "+numberOfRequests+" requests: "+elapsedTime+" ms");
        System.out.println("Average time for: "+elapsedTime/(double) numberOfRequests+" ms");
    }
}
