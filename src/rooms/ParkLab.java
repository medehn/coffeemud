package rooms;

import Basis.Room;
import Server.roomHandler;

public class ParkLab extends Room {

    private String lang = "Du stehst mitten im Park. Du weisst garnicht mehr richtig wo du lang gegangen bist," +
        "wo war die Cafeteria noch gleich?";
    private String kurz = "Im Park";
    private String osten = "Du gehst durch den Park.";
    private String westen = "Du gehst durch den Park.";
    private String sueden = "Du gehst durch den Park.";
    private String norden = "Du gehst durch den Park.";

    public Room goOst() {
        return roomHandler.getParkExit();
    }

    public Room goWest() {
        return roomHandler.getParkLab();
    }

    public Room goNord() {
        return roomHandler.getParkLab();
    }

    public Room goSud() {
        return roomHandler.getParkLab();
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

    @Override
    public String getSueden() {
        return sueden;
    }

    @Override
    public void setSueden(String sueden) {
        this.sueden = sueden;
    }

    @Override
    public String getNorden() {
        return norden;
    }

    @Override
    public void setNorden(String norden) {
        this.norden = norden;
    }
}


