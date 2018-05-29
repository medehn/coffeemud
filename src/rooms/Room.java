package rooms;

//Default Room Object to inherit

import Server.Handler;

public class Room {

    private String lang = "Du stehst mitten im Nirgendwo - da ist wohl was schiefgegangen!";
    private String kurz = "Nirwana";

    private String westen = "Hier kommst du nicht weiter.";
    private String osten = "Hier kommst du nicht weiter.";
    private String norden = "Hier kommst du nicht weiter.";
    private String sueden = "Hier kommst du nicht weiter.";
    private Room exitWesten = null;
    private Room exitOsten = null;
    private Room exitSueden = null;
    private Room exitNorden = null;

    boolean licht = true;

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
