package Server;

import rooms.*;

public class roomHandler {
    private static Hallway eingang = new Hallway();
    private static Cafeteria cafe = new Cafeteria();
    private static Room raum = new Room();
    private static ParkLab parkLab = new ParkLab();
    private static ParkExit parkExit = new ParkExit();


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

    public static Room getRaum() {
        return raum;
    }

    public static void setRaum(Room raum) {
        roomHandler.raum = raum;
    }


    public static ParkLab getParkLab() {
        return parkLab;
    }

    public static void setParkLab(ParkLab parkLab) {
        roomHandler.parkLab = parkLab;
    }

    public static ParkExit getParkExit() {
        return parkExit;
    }

    public static void setParkExit(ParkExit parkExit) {
        roomHandler.parkExit = parkExit;
    }
}
