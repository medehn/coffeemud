package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasisObject {

    private String lang;
    private String kurz;
    private String smell;
    private String feel;
    private String hear;
    private boolean alive;
    private int weight;

    HashMap<String,String> items = new HashMap<String,String>();
    public void itemList(){
    }

    public String details() {
        return "Da ist was schiefgegangen.";
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getKurz() {
        return kurz;
    }

    public void setKurz(String kurz) {
        this.kurz = kurz;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public String getHear() {
        return hear;
    }

    public void setHear(String hear) {
        this.hear = hear;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
