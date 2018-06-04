package objects;

import Basis.BasisObject;

public class Filter extends BasisObject {
    private String lang = "Ein Kaffeefilter, wie er fuer grosse Kaffeemaschinen verwendet werden kann. Er ist zwar etwas " +
        "zerknuellt, sieht aber noch nutzbar aus.";
    private String kurz = "Ein Kaffeefilter";

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
