package rooms;

import Basis.Room;
import Server.ClientHandler;
import Server.roomHandler;
import objects.Barkeeper;
import Basis.BasisObject;
import objects.CoffeeMachine;
import objects.Cup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Cafeteria extends Room {

    private String lang = "Die Cafeteria ist ein kleiner, gemuetlicher Raum. Einige Tische laden " +
        "zum Hinsetzen ein, hinter der Theke steht ein Barkeeper, der etwas verzweifelt auf eine riesige Kaffeemaschine schaut. " +
        "Bestelle doch mal einen Kaffee! Im Westen geht es in den Flur.";

    private String kurz = "Cafeteria";

    private String westen = "Du gehst nach Westen in den Flur.";
    public CoffeeMachine kaffeemaschine = new CoffeeMachine();
    public Barkeeper markus = new Barkeeper();
    public Cup kaffee = new Cup();
    public HashMap<String, BasisObject> roomItems = new HashMap<>();
    public ArrayList<String> raetselText = new ArrayList<>();

    public void roomItems() {
        roomItems.put("kaffeemaschine", kaffeemaschine);
        roomItems.put("barkeeper", markus);
        roomItems.put("kaffee", kaffee);
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
        } else if (i.equals("kaffee")) {
            return markus.getLang();
        } else return "Was genau willst du anschauen?";
    }

    public String kurzItems(String i) {
        return roomItems.get(i).getKurz();
    }

    public void raetsel(ClientHandler handler) throws InterruptedException {
        String raetselObj = "Ein Kaffeefilter";
        if (handler.clientObj.contains(kaffee.getKurz())) {
            handler.out.println("Markus schaut dich schief an und sagt: \"Ernsthaft? Du hast ja schon eine Tasse Kaffee in der Hand!\"");
        } else if (handler.clientObj.isEmpty()) {
            handler.out.println("");
            handler.out.println("Markus sagt: \"Du moechtest einen Kaffee? Tut mir leid, die Kaffeemaschine funktioniert gerade nicht.");
            TimeUnit.MILLISECONDS.sleep(1000);
            handler.out.println("Ich habe keine Filter mehr - ein Festungszwerg hat mir die Packung mit den Filtern geklaut und ist in den Park gerannt.");
            TimeUnit.MILLISECONDS.sleep(1000);
            handler.out.println("Wenn du mir einen Filter bringst kann ich dir einen Kaffee machen.\"");

        }
        if (handler.clientObj.contains(raetselObj)) {
            handler.out.println("");
            handler.out.println("Markus sagt: \"Du moechtest einen Kaffee? Tut mir leid, die Kaffeemaschine funktioniert gerade nicht. " +
                "Ich habe keine Filter mehr... ");
            TimeUnit.MILLISECONDS.sleep(1000);
            handler.out.println("Moment mal! Du hast ja da einen Kaffeefilter bei dir!\" - er greift ueber die Theke und nimmt dir " +
                "den Filter aus der Hand.");
            TimeUnit.MILLISECONDS.sleep(1000); handler.out.println("\"Wunderbar, endlich kann ich wieder Kaffee kochen!\"");
            handler.out.println("Er hantiert an der Maschine herum bis " +
                "diese endlich anspringt und einen wunderbar duftenden Kaffee auslaesst.");
            TimeUnit.MILLISECONDS.sleep(3000);
            handler.out.println("\"Hier, bitte, der ist fuer dich, geht aufs Haus!\" sagt er" +
                " und drueckt dir eine Tasse Kaffee in die Hand.");
            TimeUnit.MILLISECONDS.sleep(1000);
            handler.out.println("- und flucht laut \"NEIN! Verdammt! Der Filter ist zerrissen! Das wars wieder mit Kaffee.");
            handler.out.println("");
            handler.clientObj.remove(raetselObj);
            handler.clientObj.add(kaffee.getKurz());
        }

    }

    public String syntax() {
        return "Probiere doch mal: \"bestell kaffee\"";
    }

    public void deleteCup(ClientHandler handler) {
        handler.clientObj.remove(kaffee.getKurz());

    }

    public String raetselSyntax() {
        return "bestell kaffee";
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
