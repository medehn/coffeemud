package rooms;

public class Cafeteria extends Room {
    private String lang = "Die rooms.Cafeteria ist ein kleiner, gemuetlicher Raum. Einige Tische laden" +
        "zum Hinsetzen ein, hinter der Theke steht der Kellner und wartet auf deine Bestellung." +
        "Im Sueden gehts zum Flur, im Norden ist die Kantine.";
    private String kurz = "Cafeteria";


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
}
