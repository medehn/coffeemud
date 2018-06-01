package rooms;

import Basis.Room;
import Server.roomHandler;


public class Hallway extends Room {

    private String lang = "Dies ist der Flur, im Osten befindet sich die Cafeteria und im Westen geht es " +
        "nach draussen in den Park.";
    private String kurz = "Flur";
    private String osten = "Du gehst nach Osten in die Cafeteria.";
    private String westen = "Du gehst nach Westen in den Park.";

    public Room goOst() {
        return roomHandler.getCafe();
    }

    public Room goWest() {
        return roomHandler.getParkExit();
    }


    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String getKurz() {
        return kurz;
    }

    @Override
    public void setKurz(String kurz) {
        this.kurz = kurz;
    }

    @Override
    public String getOsten() {
        return osten;
    }

    @Override
    public void setOsten(String osten) {
        this.osten = osten;
    }

    @Override
    public String getWesten() {
        return westen;
    }

    @Override
    public void setWesten(String westen) {
        this.westen = westen;
    }
}
