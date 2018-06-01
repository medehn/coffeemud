package objects;

import Basis.BasisObject;

public class CoffeeMachine extends BasisObject {

    private String lang = "Vor dir steht ein Monstrum von einer Kaffeemaschine. Auf der Oberseite befinden sich vier" +
        "Oeffnungen, du vermutest, dass in eine davon Wasser und in die andere der Kaffee eingefuellt wird." +
        "Eine Bedienflaeche ausgestattet mit vielen Knoepfen blinkt froehlich vor sich hin. Am unteren Ende scheint" +
        "es vier Auslaesse zu geben, aus denen dann vermutlich der Kaffee herauskommt.";

    private String kurz = "Eine Kaffeemaschine";
    private String details1 = "Vier Oeffnungen, davon sind zwei fest verschlossen.";


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

    public String getDetails1() {
        return details1;
    }

    public void setDetails1(String details1) {
        this.details1 = details1;
    }
}
