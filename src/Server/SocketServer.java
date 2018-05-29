package Server;

import java.net.ServerSocket;
import java.util.logging.Logger;

public class SocketServer extends Thread {

//

    public static void main(String[] args) throws Exception {
        System.out.println("The server is running.");
        ServerSocket listener = new ServerSocket(4321);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }
}
