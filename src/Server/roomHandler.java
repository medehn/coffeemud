package Server;

import rooms.Cafeteria;
import rooms.Hallway;
import rooms.Park;
import rooms.Room;

public class roomHandler {
    private static Hallway eingang = new Hallway();
    private static Cafeteria cafe = new Cafeteria();
    private static Park park = new Park();
    private static Room raum = new Room();

    public static Hallway getEingang() {
        return eingang;
    }

    public static void setEingang(Hallway eingang) {
        roomHandler.eingang = eingang;
    }

    public static Cafeteria getCafe() {
        return cafe;
    }

    public static void setCafe(Cafeteria cafe) {
        roomHandler.cafe = cafe;
    }

    public static Park getPark() {
        return park;
    }

    public static void setPark(Park park) {
        roomHandler.park = park;
    }

    public static Room getRaum() {
        return raum;
    }

    public static void setRaum(Room raum) {
        roomHandler.raum = raum;
    }
}
