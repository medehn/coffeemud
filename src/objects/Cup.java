package objects;

import Basis.BasisObject;

public class Cup extends BasisObject {
    private String kurz = "Eine Tasse Kaffee.";
    private String lang = "Eine heisse Tasse Kaffee. Wie koestlich!";

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
