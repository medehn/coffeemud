package rooms;

public class Park extends Room {
    private String lang = "Du stehst im Park. Ein paar Sitzbaenke stehen verteilt, du kannst eine " +
        "Runde spazieren gehen wenn du willst! Am suedoestlichen Ende des Parkes ist der Eingang" +
        "zur Cafeteria.";
    private String kurz = "Im Park";


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
