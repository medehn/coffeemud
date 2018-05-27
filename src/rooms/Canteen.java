package rooms;

public class Canteen extends Room {
    private String lang = "An einer langen Theke kann man hier Essen bestellen, mehrere Tische bieten" +
        "Platz um das Essen gemuetlich zu verspeisen. Im Sueden befindet sich die Cafeteria.";
    private String kurz = "Kantine";


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
