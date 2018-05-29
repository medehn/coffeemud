package objects;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine extends BasisObject {
    private String kurz = "Eine Kaffeemaschine";
    private String lang = "Vor dir steht ein Monstrum von einer Kaffeemaschine. Auf der Oberseite befinden sich vier" +
        "Oeffnungen, du vermutest, dass in eine davon Wasser und in die andere der Kaffee eingefuellt wird." +
        "Eine Bedienflaeche ausgestattet mit vielen Knoepfen blinkt froehlich vor sich hin. Am unteren Ende scheint" +
        "es vier Auslaesse zu geben, aus denen dann vermutlich der Kaffee herauskommt. ";

    String oeffnungen = "Vier Oeffnungen, davon sind zwei fest verschlossen.";

    public void details() {
         List<String> details = new ArrayList<String>();
         details.add(oeffnungen);

    }


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
