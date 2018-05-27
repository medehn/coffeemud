package rooms;

public class Room {

    private String lang = "Du stehst mitten im Nirgendwo - da ist wohl was schiefgegangen!";
    private String kurz = "Nirwana";

    boolean licht = true;


    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setKurz(String kurz) {
        this.kurz=kurz;
    }

    public String getKurz() {
        return kurz;

    }
}
