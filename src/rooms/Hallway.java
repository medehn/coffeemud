package rooms;

import Server.Handler;

public class Hallway extends Room{

    private String lang = "Dies ist der Flur, im Osten befindet sich die Cafeteria.";
    private String kurz = "Flur";
    private String osten = "Du gehst nach Osten in die Cafeteria.";
    private String westen = "Du gehst nach Westen in den Park.";
    private Room exitOsten = Handler.cafe;
    private Room exitWesten = Handler.park;

    @Override
    public Room getExitWesten() {
        return exitWesten;
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
    public void setExitWesten(Room exitWesten) {
        this.exitWesten = exitWesten;
    }


    @Override
    public Room getExitOsten() {
        return exitOsten;
    }

    @Override
    public void setExitOsten(Room exitOsten) {
        this.exitOsten = exitOsten;
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
}
