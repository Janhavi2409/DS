package Assignment1A;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {

            int port = 25000;

            // Create server socket
            serverSocket = new ServerSocket(port);

            System.out.println("Server started");
            System.out.println("Waiting for client...");

            // Accept client connection
            socket = serverSocket.accept();

            System.out.println("Client connected");

            // Input stream
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // Read number from client
            String number = br.readLine();

            System.out.println("Message received from client: " + number);

            // Convert string to integer
            int num = Integer.parseInt(number);

            // Double the number
            int result = num * 2;

            // Convert result to string
            String response = String.valueOf(result);

            // Output stream
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            // Send response to client
            bw.write(response + "\n");
            bw.flush();

            System.out.println("Response sent to client: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                socket.close();
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}