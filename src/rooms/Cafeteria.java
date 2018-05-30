package rooms;

import Server.roomHandler;
import objects.Barkeeper;
import objects.BasisObject;
import objects.CoffeeMachine;

import java.util.ArrayList;
import java.util.HashMap;

public class Cafeteria extends Room {

    private String lang = "Die Cafeteria ist ein kleiner, gemuetlicher Raum. Einige Tische laden " +
        "zum Hinsetzen ein, hinter der Theke steht ein Barkeeper, der etwas verzweifelt auf  eine riesige Kaffeemaschine schaut. " +
        "Im Westen geht es in den Flur.";

    private String kurz = "Cafeteria";
    private String westen = "Du gehst nach Westen in den Flur.";
    public CoffeeMachine kaffeemaschine = new CoffeeMachine();
    public Barkeeper markus = new Barkeeper();

    public HashMap<String, BasisObject> roomItems = new HashMap<>();

    public void roomObjects(){
        roomItems.put("kaffeemaschine",kaffeemaschine);;
        roomItems.put("barkeeper", markus);
    }

    public String langItems(String i) {
        if (i.equals("kaffeemaschine")) {
            return roomItems.get(i).getLang();
        } else if (i.equals("oeffnungen")) {
            String currentObj = "kaffeemaschine";
            return roomItems.get(currentObj).getDetails1();
        }else if(i.equals("barkeeper")) {
            return markus.getLang();

        }else return "Was genau willst du anschauen?";
    }
    public String kurzItems(String i){
        return roomItems.get(i).getKurz();
    }


    public String details(){
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
