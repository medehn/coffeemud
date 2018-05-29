package rooms;

import Server.roomHandler;
import objects.CoffeeMachine;

public class Cafeteria extends Room {

    private String lang = "Die Cafeteria ist ein kleiner, gemuetlicher Raum. Einige Tische laden " +
        "zum Hinsetzen ein, hinter der Theke erblickst du eine riesige Kaffeemaschine. " +
        "Im Westen geht es in den Flur.";

    private String kurz = "Cafeteria";
    private String westen = "Du gehst nach Westen in den Flur.";

    public CoffeeMachine kaffeeMaschine = new CoffeeMachine();

    //TODO add more items, iterate over via handler to use and look etc
    public void items(){
        items.add(kaffeeMaschine);
    }

    public Room goWest() {
        return roomHandler.getEingang();
    }

    public String kaffee(){

        return kaffeeMaschine.getLang();
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
