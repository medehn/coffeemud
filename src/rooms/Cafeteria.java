package rooms;

import Server.roomHandler;

public class Cafeteria extends Room {

    private String lang = "Die Cafeteria ist ein kleiner, gemuetlicher Raum. Einige Tische laden" +
        "zum Hinsetzen ein, hinter der Theke steht der Kellner und wartet auf deine Bestellung." +
        "Im Westen geht es in den Flur.";

    private String kurz = "Cafeteria";
    private String westen = "Du gehst nach Westen in den Flur.";


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
