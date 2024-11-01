import java.util.HashMap;

public class turingMaschine {
    private int[] zustaende;
    private int head = 10;
    private int aktuellZustand;
    private int endZustand;
    private final int anfangsZustand;
    private HashMap<deltaFirst,deltaSecond> deltaMap;

    public turingMaschine(int zustaende, int anfangsZustand, int endZustand, HashMap<deltaFirst,deltaSecond> deltaMap) {
        this.zustaende = new int[zustaende];
        for(int i = 0; i < zustaende; i++){
            this.zustaende[i] = i+1;
        }
        this.endZustand = endZustand;
        this.deltaMap = deltaMap;
        this.anfangsZustand = anfangsZustand;
        aktuellZustand = anfangsZustand;
    }

    public void runItBaby(char[] band){
        //make a new temp with current status and head char at head, then compare to deltafirsts in keyset of hashmap
        deltaFirst temp = new deltaFirst(aktuellZustand, band[head] - '0');

        for(deltaFirst tempp : deltaMap.keySet()){
            if(tempp.isEqual(temp)){
                temp = tempp;
            }
        }

        //while not invalid or done, continue task by changing the position of head and the
        //character at the head, etc.

        while(deltaMap.get(temp) != null && aktuellZustand != this.endZustand){
           deltaSecond tempTwo = deltaMap.get(temp);
           band[head] = (char)(tempTwo.getAusgabe() + '0');
           aktuellZustand = tempTwo.getZustand();
           if((char)(tempTwo.getRichtung() + '0') == ('R')){
               head++;
           } else if((char)(tempTwo.getRichtung() + '0') == ('L')){
               head--;
           }
           temp = new deltaFirst(aktuellZustand, band[head] - '0');
           System.out.println(String.valueOf(band));


            //update temp for the next check
            for(deltaFirst tempp : deltaMap.keySet()){
                if(tempp.isEqual(temp)){
                    temp = tempp;
                }
            }

        }
    }
}
