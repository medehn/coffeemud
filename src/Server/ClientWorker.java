package Server;

import rooms.Cafeteria;
import rooms.Hallway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;

public class ClientWorker implements Runnable {

    private Socket client;
    private String name;
    private static HashSet<String> names = new HashSet<String>();
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    private BufferedReader in = null;
    private PrintWriter out = null;

    public Hallway eingang = new Hallway();
    public Cafeteria cafe = new Cafeteria();

    public ClientWorker(Socket client) {
        this.client = client;
    }


    private String getName() {
        return name;
    }

    //starting reader and writer up from Client
    @Override
    public void run() {

        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

            while (true) {
                String line = in.readLine();
                communicate();

            }

        } catch (IOException e) {
            System.out.println("in or out failed");
            System.exit(-1);
        }

    }
    //communication via telnet
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
            } else if (line.startsWith("SUBMITNAME")) {
                out.println(getName());
            } else if (line.startsWith("MESSAGE")) {
                out.println(line.substring(8) + "\n");
            }
//                out.println(line);
        } catch (IOException e) {
            System.out.println("Reading failed (Main)");
            System.exit(-1);
        }
    }



}

