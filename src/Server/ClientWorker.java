package Server;

import rooms.Cafeteria;
import rooms.Hallway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWorker implements Runnable {

    private Socket client;
    private BufferedReader in = null;
    private PrintWriter out = null;
    public Hallway eingang = new Hallway();
    public Cafeteria cafe = new Cafeteria();

    public ClientWorker(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("in or out failed");
            System.exit(-1);
        }

        while (true) {
            communicate();

        }
    }

    public void communicate(){
        try {
            String line = in.readLine();
            //talking - if a message starts with "sag:" only the message is printed out
            //TODO: Broadcast the message
            if (line.matches("(?i)sag .*")) {
                out.println(line.substring(3));
            }
            //if "b" is typed, the long description of the room is prompted.
            else if (line.matches(("b"))){
                out.println(eingang.getKurz());
                out.println(eingang.getLang());
            }
//                out.println(line);
        } catch (IOException e) {
            System.out.println("Reading failed (Main)");
            System.exit(-1);
        }
    }



}

