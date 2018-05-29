package rooms;

import Server.Handler;

public class Cafeteria extends Room {

    private String lang = "Die Cafeteria ist ein kleiner, gemuetlicher Raum. Einige Tische laden" +
        "zum Hinsetzen ein, hinter der Theke steht der Kellner und wartet auf deine Bestellung." +
        "Im Westen geht es in den Flur.";

    private String kurz = "Cafeteria";
    private String westen = "Du gehst nach Westen in den Flur.";
    private Room exitWesten = Handler.eingang;


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

    public String getWesten() {
        return westen;
    }

    public void setWesten(String westen) {
        this.westen = westen;
    }

    public Room getExitWesten() {
        return exitWesten;
    }

    public void setExitWesten(Room exitWesten) {
        this.exitWesten = exitWesten;
    }
}
