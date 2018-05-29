package rooms;

//Default Room Object to inherit

import Server.roomHandler;

public class Room {

    private String lang = "Du stehst mitten im Nirgendwo - da ist wohl was schiefgegangen!";
    private String kurz = "Nirwana";

    private String westen = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String osten = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String norden = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String sueden = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";

    private Room exitWesten = roomHandler.getRaum();
    private Room exitOsten = roomHandler.getRaum();
    private Room exitSueden = roomHandler.getRaum();
    private Room exitNorden = roomHandler.getRaum();
    public Room getHere = roomHandler.getRaum();

    boolean licht = true;

    public Room goWest(){
        return exitWesten;
    };
    public Room goOst(){
        return exitOsten;
    };
    public Room goSud(){
        return exitSueden;
    };
    public Room goNord(){
        return exitNorden;
    };

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setKurz(String kurz) {
        this.kurz=kurz;
    }

    public String getKurz() {
        return kurz;

    }

    public String getWesten() {
        return westen;
    }

    public void setWesten(String westen) {
        this.westen = westen;
    }

    public String getOsten() {
        return osten;
    }

    public void setOsten(String osten) {
        this.osten = osten;
    }

    public String getNorden() {
        return norden;
    }

    public void setNorden(String norden) {
        this.norden = norden;
    }

    public String getSueden() {
        return sueden;
    }

    public void setSueden(String sueden) {
        this.sueden = sueden;
    }

    public Room getExitWesten() {
        return exitWesten;
    }

    public void setExitWesten(Room exitWesten) {
        this.exitWesten = exitWesten;
    }

    public Room getExitOsten() {
        return exitOsten;
    }

    public void setExitOsten(Room exitOsten) {
        this.exitOsten = exitOsten;
    }

    public Room getExitSueden() {
        return exitSueden;
    }

    public void setExitSueden(Room exitSueden) {
        this.exitSueden = exitSueden;
    }

    public Room getExitNorden() {
        return exitNorden;
    }

    public void setExitNorden(Room exitNorden) {
        this.exitNorden = exitNorden;
    }
}
