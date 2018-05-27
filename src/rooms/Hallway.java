package rooms;

public class Hallway extends Room{

    private String lang = "Dies ist der Flur, im Norden befindet sich die Cafeteria.";
    private String kurz = "Flur";

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
