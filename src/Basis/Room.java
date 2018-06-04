package Basis;

//Default Room Object to inherit

import Server.ClientHandler;
import java.util.ArrayList;

public class Room {

    private String lang = "Du stehst mitten im Nirgendwo - da ist wohl was schiefgegangen!";
    private String kurz = "Nirwana";
    private String westen = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String osten = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String norden = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    private String sueden = "Was soll da bitte sein? Du stehst im Nirwana, da gehts einfach nicht weiter...";
    public ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

    //register to a list of present handlers in the current room
    public void register(ClientHandler clientHandler) {
        clients.add(clientHandler);
        clientsInRoom();
    }
    public ArrayList<String> syntax = new ArrayList<>();
    public String raetselSyntax(){
        return "";
    }
    public String getNPC() {
        return "";
    }
    public String getObj(){ return ""; }

    //communication, limited to the room
    public void say(String text, ClientHandler clientHandler) {
        for (ClientHandler client : clients) {
            client.out.println(clientHandler.name.substring(20) + " sagt: " + text);
        }
    }

    public String syntax(){
        return "Hier gibt es keine speziellen Interaktionen.";
    }

    //output for already present clients if new client enters a room
    public void enterRoom(ClientHandler clientHandler) {
        for (ClientHandler client : clients) {
            if (!client.equals(clientHandler)) {
                client.out.println(clientHandler.name.substring(20) + " naehert sich.");
            }
        }
    }

    //output if client leaves a room
    public void leaveRoom(ClientHandler clientHandler) {
        for (ClientHandler client : clients) {
            if (!client.equals(clientHandler)) {
                client.out.println(clientHandler.name.substring(20) + " entfernt sich.");
            }
        }
    }

    //checking and outputting clients that are present in a given room
    public String clientsInRoom() {
        if (clients.size() == 1) {
            return "Nur du befindest dich in diesem Raum.";
        } else {
            String clientList = "";
            ClientHandler first = clients.get(0);
            clientList = "In diesem Raum befinden sich: " + first.name.substring(20);
            for (int i = 1; i < clients.size(); i++) {
                clientList = clientList + ", " + clients.get(i).name.substring(20);
            }
            return clientList;
        }
    }

    //deleting oneself from the rooms clientlist
    public void unregister(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public String langItems(String i) {
        return "Das hat nicht funktioniert.";
    }

    public String kurzItems(String i) {
        return "Das hat nicht funktioniert.";
    }

    public void roomItems() {}
    public void deleteCup(ClientHandler handler){}
    public void action(ClientHandler handler) throws InterruptedException {}

    public void raetsel(ClientHandler handler) throws InterruptedException {
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
