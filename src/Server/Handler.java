package Server;

import rooms.Cafeteria;
import rooms.Hallway;

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

    public void run() {
        try {

            // Create character streams for the socket.
            in = new BufferedReader(new InputStreamReader(
                socket.getInputStream(), StandardCharsets.UTF_8));
            out = new PrintWriter(socket.getOutputStream(), true);


            while (true) {

                //Graphic to start Mud
                graphics();

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
                writer.println(name.substring(20) + " erscheint.");
            }

            // Accept messages from this client and broadcast them.

            while (true) {
                communicate();
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

    // communication is managed in this method, currently working on regex
    public void communicate() {
        try {
            String line = in.readLine();
            //for chatting with other clients syntax needs to be "sag sometext" which would then broadcast "sometext" to
            //all users that have logged in
            if (line.matches("(?i)sag .*")) {
                for (PrintWriter writer : writers) {
                    writer.println(name.substring(20) + " sagt: " + line.substring(3));
                }
            }
            //if "b" is typed, the long description of the room is prompted - only for the current client!
            else if (line.matches(("b"))) {
                out.println(eingang.getKurz());
                out.println(eingang.getLang());
            }
        } catch (IOException e) {
            System.out.println("Reading failed (Main)");
            System.exit(-1);
        }
    }

    //method to create Welcoming graphics at startup
    public void graphics() {
        int width = 80;
        int height = 10;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Arial", Font.BOLD, 14));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Coffe Mud", 5, 10);

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

