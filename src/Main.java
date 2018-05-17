import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        SocketServer Server = new SocketServer();
        Server.listenSocket();

        while (true) {
            ClientWorker w;
            try {
                // server.accept returns a client conn
                w = new ClientWorker(Server.server.accept());
                Thread t = new Thread(w);
                t.start();
            } catch (IOException e) {
                System.out.println("Accept failed: 4321");
                System.exit(-1);
            }
        }


    }
}
