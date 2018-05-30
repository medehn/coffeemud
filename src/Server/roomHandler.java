package Server;

import rooms.*;

public class roomHandler {

    //Instances of rooms
    private static Hallway eingang = new Hallway();
    private static Cafeteria cafe = new Cafeteria();
    private static ParkLab parkLab = new ParkLab();
    private static ParkExit parkExit = new ParkExit();

    public static Hallway getEingang() {
        return eingang;
    }

    public static Cafeteria getCafe() {
        return cafe;
    }

    public static ParkLab getParkLab() {
        return parkLab;
    }

    public static ParkExit getParkExit() {
        return parkExit;
    }

}
