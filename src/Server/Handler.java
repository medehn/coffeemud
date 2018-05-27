package Server;

import rooms.Cafeteria;
import rooms.Hallway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class Handler extends Thread {

    private static HashSet<String> names = new HashSet<String>();
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    private String name;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    public Hallway eingang = new Hallway();
    public Cafeteria cafe = new Cafeteria();

    public Handler(Socket socket) {
        this.socket = socket;
    }

    /**
     * Services this thread's client by repeatedly requesting a
     * screen name until a unique one has been submitted, then
     * acknowledges the name and registers the output stream for
     * the client in a global set, then repeatedly gets inputs and
     * broadcasts them.
     */
    public void run() {
        try {

            // Create character streams for the socket.
            in = new BufferedReader(new InputStreamReader(
                socket.getInputStream(),StandardCharsets.UTF_8));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Request a name from this client.  Keep requesting until
            // a name is submitted that is not already used.  Note that
            // checking for the existence of a name and adding the name
            // must be done while locking the set of names.
            while (true) {
                out.println("Wie heisst du?");
                name = in.readLine();
                System.out.println(name);
                if (name == null) {
                    return;
                }
                if (names.contains(name)){
                    out.println("So heisst schon jemand... ");
                }
                synchronized (names) {
                    if (!names.contains(name)) {
                        names.add(name);
                        break;
                    }
                }
            }

            // Now that a successful name has been chosen, add the
            // socket's print writer to the set of all writers so
            // this client can receive broadcast messages.

            out.println("Alles klar "+name.substring(20)+", es kann losgehen!");
            writers.add(out);
            for (PrintWriter writer : writers) {
                writer.println(name.substring(20)+" erscheint.");
            }

            // Accept messages from this client and broadcast them.
            // Ignore other clients that cannot be broadcasted to.

            while (true) {
                communicate();

            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {

            // This client is going down!  Remove its name and its print
            // writer from the sets, and close its socket.

            if (name != null) {
                names.remove(name);
                for (PrintWriter writer : writers) {
                    writer.println(name.substring(20) + " verschwindet.");
                }
            }
            if (out != null) {
                writers.remove(out);
            }
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    public void communicate() {
        try {
            String line = in.readLine();
            if (line.matches("(?i)sag .*")) {
                for (PrintWriter writer : writers) {
                    writer.println(name.substring(20) + " sagt: " + line.substring(3));
                }
            }
            //if "b" is typed, the long description of the room is prompted.
            else if (line.matches(("b"))) {
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

