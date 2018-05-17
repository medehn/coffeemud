
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer {

    public ServerSocket server;
    Socket client;
    public BufferedReader in;
    public PrintWriter out;


    public void listenSocket() {
        try {
            server = new ServerSocket(4321);
        } catch (IOException e) {
            System.out.println("Could not listen to port 4321");
            System.exit(-1);
        }

        try {
            client = server.accept();
        } catch (IOException e) {
            System.out.println("Acception failed");
            System.exit(-1);
        }

        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Reading failed");
            System.exit(-1);
        }

    }


}

