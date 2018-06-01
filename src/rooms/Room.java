package rooms;

//Default Room Object to inherit

import Server.Handler;

import java.util.ArrayList;

public class Room {

    private String lang = "Du stehst mitten im Nirgendwo - da ist wohl was schiefgegangen!";
    private String kurz = "Nirwana";
    private String westen = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String osten = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String norden = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String sueden = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    public ArrayList<Handler> clients = new ArrayList<Handler>();

    //register to a list of present handlers in the current room
    public void register(Handler handler) {
        clients.add(handler);
        clientsInRoom();
    }

    public String raetselSyntax(){
        return "";
    }
    public String getNPC() {
        return "";
    }

    //communication, limited to the room
    public void say(String text) {
        for (Handler client : clients) {
            client.out.println(client.name.substring(20) + " sagt: " + text);
        }
    }

    //output for already present clients if new client enters a room
    public void enterRoom(Handler handler) {
        for (Handler client : clients) {
            if (client.equals(handler)) {
                break;
            } else {
                client.out.println(client.name.substring(20) + " naehert sich.");
            }
        }
    }

    //output if client leaves a room
    public void leaveRoom(Handler handler) {
        for (Handler client : clients) {
            if (client.equals(handler)) {
                break;
            } else {
                client.out.println(client.name.substring(20) + " entfernt sich.");

            }
        }
    }

    //checking and outputting clients that are present in a given room
    public String clientsInRoom() {
        if (clients.size() == 1) {
            return "Nur du befindest dich in diesem Raum.";
            //TODO add output for NPCs
        } else {
            String clientList = "";
            Handler first = clients.get(0);
            clientList = "In diesem Raum befinden sich: " + first.name.substring(20);
            for (int i = 1; i < clients.size(); i++) {
                clientList = clientList + ", " + clients.get(i).name.substring(20);
            }
            return clientList;
        }
    }

    //deleting oneself from the rooms clientlist
    public void unregister(Handler handler) {
        clients.remove(handler);
    }

    public String langItems(String i) {
        return "Das hat nicht funktioniert.";
    }

    ;

    public String kurzItems(String i) {
        return "Das hat nicht funktioniert.";
    }

    public void roomItems() {
    }

    public String raetsel() {
        return "Da gibt es nichts.";
    }

    public Room goWest() {
        return null;
    }

    public Room goOst() {
        return null;
    }

    public Room goSud() {
        return null;
    }

    public Room goNord() {
        return null;
    }

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
