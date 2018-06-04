package rooms;

import Basis.Room;
import Server.roomHandler;
import objects.Barkeeper;
import Basis.BasisObject;
import objects.CoffeeMachine;
import java.util.HashMap;

public class Cafeteria extends Room {

    private String lang = "Die Cafeteria ist ein kleiner, gemuetlicher Raum. Einige Tische laden " +
        "zum Hinsetzen ein, hinter der Theke steht ein Barkeeper, der etwas verzweifelt auf  eine riesige Kaffeemaschine schaut. " +
        "Bestelle doch mal einen Kaffee! Im Westen geht es in den Flur.";

    private String kurz = "Cafeteria";
    private String westen = "Du gehst nach Westen in den Flur.";
    public CoffeeMachine kaffeemaschine = new CoffeeMachine();
    public Barkeeper markus = new Barkeeper();
    public HashMap<String, BasisObject> roomItems = new HashMap<>();

    public void roomItems() {
        roomItems.put("kaffeemaschine", kaffeemaschine);
        roomItems.put("barkeeper", markus);
    }

    //method to display NPCs in the room
    public String getNPC() {
        return markus.getKurz();
    }

    //temporary way of reacting to input concerning objects in rooms, is to be
    //replaced by iterating over a list of instanciated objects and getting their properties
    public String langItems(String i) {
        if (i.equals("kaffeemaschine")) {
            return roomItems.get(i).getLang();
        } else if (i.equals("oeffnungen")) {
            String currentObj = "kaffeemaschine";
            return roomItems.get(currentObj).getDetails1();
        } else if (i.equals("barkeeper")) {
            return markus.getLang();
        } else return "Was genau willst du anschauen?";
    }

    public String kurzItems(String i) {
        return roomItems.get(i).getKurz();
    }

    public String raetsel() {
        String raetselText = "Markus sagt: Du moechtest einen Kaffee? Tut mir leid, die Kaffeemaschine funktioniert gerade nicht." +
            "Ich habe keine Filter mehr - ein Festungszwerg hat mir die Packung mit den Filtern geklaut und ist in " +
            "den Park gerannt. Wenn du mir einen Filter bringst kann ich dir einen Kaffee machen.";
        return raetselText;
    }

    public String raetselSyntax(){
        return "bestelle kaffee";
    }

    public String details() {
        return kaffeemaschine.getKurz();
    }

    public Room goWest() {
        return roomHandler.getEingang();
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
    public String getWesten() {
        return westen;
    }

    @Override
    public void setWesten(String westen) {
        this.westen = westen;
    }

}
