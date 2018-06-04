// This class sets up the Server for the connection to telnet
//

package Server;

import java.net.ServerSocket;

public class SocketServer extends Thread {

    public static void main(String[] args) throws Exception {
        System.out.println("The server is running.");
        ServerSocket listener = new ServerSocket(4321);
        try {
            while (true) {
                new ClientHandler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }
}
