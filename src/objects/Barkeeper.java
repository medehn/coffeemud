package objects;

import Basis.BasisObject;

public class Barkeeper extends BasisObject {

    private String kurz = "Markus, der Barkeeper.";
    private String lang = "Das ist der Barkeeper dieser Cafeteria - Markus.";

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
