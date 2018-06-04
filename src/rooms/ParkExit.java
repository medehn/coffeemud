package rooms;

import Basis.BasisObject;
import Basis.Room;
import Server.ClientHandler;
import Server.roomHandler;
import objects.Dwarf;
import objects.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ParkExit extends Room {
    private String lang = "Du stehst am Anfang des Parks. " +
        "Ein paar Sitzbaenke stehen verteilt. Der Park erstreckt sich nach Norden, Osten und Sueden." +
        " Im Osten geht es durch einen Flur zur Cafeteria.";
    private String kurz = "Im Park";
    private String osten = "Du gehst nach Osten in den Flur.";
    private String westen = "Du gehst durch den Park.";
    private String sueden = "Du gehst durch den Park.";
    private String norden = "Du gehst durch den Park.";
    private Dwarf Festungszwerk = new Dwarf();
    private Filter Kaffeefilter = new Filter();
    private HashMap<String, BasisObject> roomItems = new HashMap<>();

    public void roomItems() {
        roomItems.put("festungszwerg", Festungszwerk);
        roomItems.put("kaffeefilter", Kaffeefilter);
    }

    public String getNPC() {
        return Festungszwerk.getKurz();
    }

    public String getObj() {
        return Kaffeefilter.getKurz();
    }

    public String langItems(String i) {
        if (i.equals("festungszwerg")) {
            return roomItems.get(i).getLang();
        } else if (i.equals("kaffeefilter")) {
            return roomItems.get(i).getLang();
        } else return "Was genau willst du anschauen?";
    }

    public String raetselSyntax() {
        return "nimm kaffeefilter";
    }

    public String raetsel(ClientHandler handler) {
        Random ran = new Random();
        ArrayList<String> pickFilter= new ArrayList<>();
        pickFilter.add("Du versuchst einen Filter aus der Packung zu nehmen und erwischst auch einen - aber der Zwerg "+
            "steigt dir dabei kraeftig auf die Finger. AU!");
        pickFilter.add("Du schnappst dem Zwerg einen Filter unter den Fuessen weg.");
        String raetselText = pickFilter.get(ran.nextInt(pickFilter.size()));
        return raetselText;
    }

    public String syntax(){
        return "Probiere: nimm kaffeefilter";
    }
    public Room goOst() {
        return roomHandler.getEingang();
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
