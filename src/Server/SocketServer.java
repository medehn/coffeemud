package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;


public class SocketServer {

    public ServerSocket server;
    Socket client;
    public BufferedReader in;
    public PrintWriter out;
    ArrayList clients;
    private final static Logger log = Logger.getLogger(SocketServer.class.getName());


    public void listenSocket() {
        try {
            //Setting up the Server
            server = new ServerSocket(4321);
            log.info("verbunden!");
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

    protected void finalize(){
        //closing all threads and sockets
        try{
            server.close();
            log.info("Alle geschlossen");


        } catch (IOException e) {
            System.out.println("Could not close socket");
            System.exit(-1);
        }
    }


}

