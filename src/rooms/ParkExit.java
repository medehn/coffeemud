package rooms;

import Server.roomHandler;
import objects.Dwarf;

public class ParkExit extends Room {
    private String lang = "Du stehst am Anfang des Parks. Ein paar Sitzbaenke stehen verteilt, du kannst eine " +
        "Runde spazieren gehen wenn du willst! Der Park erstreckt sich nach Norden, Osten und Sueden." +
        " Im Osten geht es durch einen Flur zur Cafeteria.";
    private String kurz = "Im Park";
    private String osten = "Du gehst nach Osten in den Flur.";
    private String westen = "Du gehst durch den Park.";
    private String sueden = "Du gehst durch den Park.";
    private String norden = "Du gehst durch den Park.";
    public Dwarf Festungszwerk = new Dwarf();

    public String getNPC(){
        return Festungszwerk.getKurz();
    }
    public String raetselSyntax(){
        return "belausche zwerg";
    }

    public String raetsel() {
        String raetselText = "Der Zwerg murmelt: Hahahaha, das war so einfach... diese Filter, die kann ich bestimmt benutzen, " +
            "um meinen naechsten Fusel zu filtern... HE! Guck nicht so! Was willst du von mir!";

        return raetselText;
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
