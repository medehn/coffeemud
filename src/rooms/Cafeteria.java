package rooms;

import Server.roomHandler;
import objects.BasisObject;
import objects.CoffeeMachine;

import java.util.ArrayList;
import java.util.HashMap;

public class Cafeteria extends Room {

    private String lang = "Die Cafeteria ist ein kleiner, gemuetlicher Raum. Einige Tische laden " +
        "zum Hinsetzen ein, hinter der Theke erblickst du eine riesige Kaffeemaschine. " +
        "Im Westen geht es in den Flur.";

    private String kurz = "Cafeteria";
    private String westen = "Du gehst nach Westen in den Flur.";
    public CoffeeMachine kaffeemaschine = new CoffeeMachine();

    public HashMap<String, BasisObject> roomItems = new HashMap<>();

    public void roomObjects(){
        roomItems.put("kaffeemaschine",kaffeemaschine);;
    }

    public String getItems(String i){
         return roomItems.get(i).getLang();
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
