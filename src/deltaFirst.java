public class deltaFirst {
    private int zustand;
    private int eingabe;

    public deltaFirst(int zustand, int eingabe){
        this.zustand = zustand;
        this.eingabe = eingabe;
    }

    public boolean isEqual(deltaFirst first){
        if(this.zustand == first.getZustand() && this.eingabe == first.getEingabe()){
            return true;
        }
        return false;
    }

    public int getEingabe() {
        return eingabe;
    }

    public int getZustand() {
        return zustand;
    }

    public String toString(){
        return "zustand: " + zustand + ", eingabe: " + eingabe;
    }
}
