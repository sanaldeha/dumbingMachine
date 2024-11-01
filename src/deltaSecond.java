public class deltaSecond {

    private int zustand;
    private int ausgabe;
    private int richtung;

    deltaSecond(int zustand, int eingabe, int richtung) {
        this.zustand = zustand;
        this.ausgabe = eingabe;
        this.richtung = richtung;
    }

    public int getZustand() {
        return zustand;
    }

    public int getAusgabe() {
        return ausgabe;
    }

    public int getRichtung() {
        return richtung;
    }

    public boolean isEqual(deltaSecond second){
        if(this.zustand == second.getZustand() && this.ausgabe == second.getAusgabe() && this.richtung == second.getRichtung()){
            return true;
        }
        return false;
    }
}
