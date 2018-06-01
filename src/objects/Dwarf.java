package objects;

public class Dwarf extends BasisObject {
    private String kurz = "Ein Zwerg.";
    private String lang = "Eine seltsame Kreatur steht vor dir. Klein, rote Nase, zerschlissene Kleidung, Bart..." +
        "Ein Zwerg! Er riecht nach billigem Fusel und schaut dich frech an. Er murmelt irgendetwas. Belausche ihn doch mal!";

    @Override
    public String getKurz() {
        return kurz;
    }

    @Override
    public void setKurz(String kurz) {
        this.kurz = kurz;
    }

    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public void setLang(String lang) {
        this.lang = lang;
    }
}
