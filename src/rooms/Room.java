package rooms;

//Default Room Object to inherit

import Server.Handler;
import objects.BasisObject;

import java.util.ArrayList;

public class Room {

    private String lang = "Du stehst mitten im Nirgendwo - da ist wohl was schiefgegangen!";
    private String kurz = "Nirwana";

    private String westen = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String osten = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String norden = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String sueden = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";

    public ArrayList<Handler> clients = new ArrayList<Handler>();
    public ArrayList<BasisObject> items = new ArrayList<BasisObject>();

    public String register(Handler handler){
        clients.add(handler);
        String clientList = "";
        Handler first = clients.get(0);
        clientList = "In diesem Raum befinden sich: "+first.name.substring(20);
        for (int i=1; i<clients.size(); i++){
            clientList = clients.get(i).name.substring(20)+", "+clientList;
        }
        return clientList;
    }

    public void unregister(Handler handler){
        clients.remove(handler);
    }

    boolean licht = true;

    public Room goWest() {
        return null;
    }

    ;

    public Room goOst() {
        return null;
    }

    ;

    public Room goSud() {
        return null;
    }

    ;

    public Room goNord() {
        return null;
    }

    ;

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setKurz(String kurz) {
        this.kurz = kurz;
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

}
