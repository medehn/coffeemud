package objects;

import Basis.BasisObject;

public class Dwarf extends BasisObject {
    private String kurz = "Ein Festungszwerg.";
    private String lang = "Eine seltsame Kreatur steht vor dir. Klein, rote Nase, zerschlissene Kleidung, Bart..." +
        "Ein Zwerg! Er riecht nach billigem Fusel und schaut dich frech an. Er steht auf einer zerknuellten Packung " +
        "mit etwas, was entfernt an Kaffeefilter erinnert. Falls du einen brauchst, versuche doch einfach" +
        " mal, einen zu nehmen.";

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
