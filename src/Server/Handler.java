package Server;

import rooms.Room;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Handler extends Thread {

    private final static Logger log = Logger.getLogger(SocketServer.class.getName());
    private static HashSet<String> names = new HashSet<String>();
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    public String name;
    private String input;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Room currentRoom;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            //always enter in cafeteria
            currentRoom = roomHandler.getCafe();
            // Create character streams for the socket.
            in = new BufferedReader(new InputStreamReader(
                socket.getInputStream(), StandardCharsets.UTF_8));
            out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                //Graphic to start Mud
                out.println("WILLKOMMEN im");
                out.println("");
                graphics();
                out.println("");
                out.println("Dies ist ein MUD - ein Multi User Dungeon. Tippe \"hilfe\", um dir eine Liste der Kommandos ausgeben zu lassen,");
                out.println("Sieh dich um, unterhalte dich, hab Spass! Falls du Bugs findest darfst du sie gern behalten.");
                out.println("Da dieses MUD noch im Aufbau ist freut sich Mel ueber Inputs,  und Ideen!");
                out.println("");
                //sleep for delayed output
                TimeUnit.MILLISECONDS.sleep(1000);
                // Request a name from this client.  Keep requesting until
                // a name is submitted that is not already used.  Note that
                // checking for the existence of a name and adding the name
                // must be done while locking the set of names.
                out.println("Wie heisst du?");
                name = in.readLine();
                System.out.println(name);
                if (name == null) {
                    return;
                }
                if (names.contains(name)) {
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
            out.println("Alles klar " + name.substring(20) + ", es kann losgehen!");
            writers.add(out);
            for (PrintWriter writer : writers) {
                writer.println(name.substring(20) + " hat sich soeben eingeloggt.");
            }
            //After logging in, chat-method and moving is initiated
            while (true) {
                input = in.readLine();

                communicate();
                move();
                commonInput();

            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //remove client if he closes the connection
            if (name != null) {
                names.remove(name);
                for (PrintWriter writer : writers) {
                    writer.println(name.substring(20) + " hat die Verbindung soeben getrennt.");
                }
            }
            if (out != null) {
                writers.remove(out);
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // communication is managed in this method, currently working on regex
    private void communicate() throws IOException {

        //for chatting with other clients syntax needs to be "sag sometext" which would then broadcast "sometext" to
        //all users that have logged in, broadcast is transmitted to all rooms for now
        if (input.matches("(?i)sag .*")) {
            for (PrintWriter writer : writers) {
                writer.println(name.substring(20) + " sagt: " + input.substring(3));
            }
            //TODO create room-internal communication via list of registered users
        }

    }

    private void commonInput() {
        currentRoom.roomObjects();
        // if "b" is typed, the long description of the room is prompted - only for the current client!
        if (input.matches(("b"))) {
            out.println(currentRoom.getKurz());
            out.println(currentRoom.getLang());
            out.println(currentRoom.clientsInRoom());
        }

        // who-List
        else if (input.matches(("wer"))) {

            out.println("Momentan sind eingeloggt:");
            for (String name : names) {
                out.println(name.substring(20));
            }
        }

        else if (input.matches(("hilfe"))) {
            out.println("Liste der Kommandos:");
            out.println("b = betrachte deine Umgebung.");
            out.println("b GEGENSTAND = betrachte einen Gewissen Gegenstand oder ein Detail genauer.");
            out.println("sag TEXT = sende TEXT als Chat-Mitteilung an alle eingeloggten User.");
            out.println("wer = Liste der momentan eingeloggten User");
            out.println("n,o,s,w = Norden, Osten, Süden, Westen - mit jeweils einem Befehl bewegst du dich in die jeweilige Richtung");

        }
        //watching at details
        if (input.length() > 3) {
            String key = input.substring(2);
            if (input.matches("b " + key)) {
                out.println(currentRoom.langItems(key));
            } else {
                out.println("");
            }

        }
    }

    //This method coordinates movements between rooms
    private void move() throws IOException {

        //TODO add message for entering/leaving a room to show others

        //exits towards other rooms
        if (input.matches(("w"))) {
            //if there is an exit west
            if (currentRoom.goWest() != null) {
                //print the movement-msg
                out.println(currentRoom.getWesten());
                //set the current room to the room that is west of the last
                currentRoom.unregister(this);
                currentRoom = currentRoom.goWest();
                //print room description
                out.println(currentRoom.getKurz());
                out.println(currentRoom.getLang());
                //registering to a list of clients held by the room and creating a list of present clients
                out.println(currentRoom.register(this));
                //if there is no exit:
            } else {
                out.println("Da geht es nicht weiter.");
            }
        }

        if (input.matches(("o"))) {
            if (currentRoom.goOst() != null) {
                out.println(currentRoom.getOsten());
                currentRoom.unregister(this);
                currentRoom = currentRoom.goOst();
                out.println(currentRoom.getKurz());
                out.println(currentRoom.getLang());
                out.println(currentRoom.register(this));
            } else {
                out.println("Da geht es nicht weiter.");
            }
        }

        if (input.matches(("s"))) {
            if (currentRoom.goSud() != null) {
                out.println(currentRoom.getSueden());
                currentRoom.unregister(this);
                currentRoom = currentRoom.goSud();
                out.println(currentRoom.getKurz());
                out.println(currentRoom.getLang());
                out.println(currentRoom.register(this));
            } else {
                out.println("Da geht es nicht weiter.");
            }
        }

        if (input.matches(("n"))) {
            if (currentRoom.goNord() != null) {
                out.println(currentRoom.getNorden());
                currentRoom.unregister(this);
                currentRoom = currentRoom.goNord();
                out.println(currentRoom.getKurz());
                out.println(currentRoom.getLang());
                out.println(currentRoom.register(this));
            } else {
                out.println("Da geht es nicht weiter.");
            }
        }
    }


    //Method to display Ascii graphic to start the game
    private void graphics() {
        int width = 80;
        int height = 10;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Arial", Font.BOLD, 12));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Coffee Mud", 1, 10);

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {
                sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
            }
            if (sb.toString().trim().isEmpty()) {
                continue;
            }
            out.println(sb);
        }
        out.println();
    }
}

