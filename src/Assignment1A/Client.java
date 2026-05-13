package Assignment1A;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;

        try {

            String host = "localhost";
            int port = 25000;

            // Create socket connection
            socket = new Socket(host, port);

            System.out.println("Connected to server");

            // Output stream
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            // Number to send
            String message = "5";

            // Send number to server
            bw.write(message + "\n");
            bw.flush();

            System.out.println("Message sent to server: " + message);

            // Input stream
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // Receive response
            String response = br.readLine();

            System.out.println("Response from server: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}