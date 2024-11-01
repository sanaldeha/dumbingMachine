import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            //read file
            File instructions = new File("src/logTwoRoundUp.TM");
            Scanner scanner = new Scanner(instructions);

            //get info from the file, skip alphabets for this task
            int zustaendeCount = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();
            scanner.nextLine();
            int anfangsZustand = Integer.parseInt(scanner.nextLine());
            int endZustand = Integer.parseInt(scanner.nextLine());

            //pack delta uebergaenge into classes deltaFirst and deltaSecond, and make a hashmap
            HashMap<deltaFirst,deltaSecond> deltaTable = new HashMap<deltaFirst,deltaSecond>();
            while(scanner.hasNextLine()){
                String delta = scanner.nextLine();
                String[] strArray = delta.split(" ");
                int[] intArray = new int[strArray.length];
                for(int i = 0; i < strArray.length; i++) {
                    if(strArray[i].length() == 1){
                        intArray[i] = strArray[i].charAt(0) - '0';
                    } else {
                        intArray[i] = Integer.parseInt(strArray[i]);
                    }
                }
                deltaFirst deltafirst = new deltaFirst(intArray[0], intArray[1]);
                deltaSecond deltasecond = new deltaSecond(intArray[2], intArray[3], intArray[4]);
                deltaTable.put(deltafirst, deltasecond);
            }

            //input
            scanner = new Scanner(System.in);
            System.out.println("GIVE IT TO ME");
            String temp = scanner.nextLine();
            if(temp.isEmpty()){
                return;
            }
            //arbitrary amount of blanks before and after the input
            String temp2 = "BBBBBBBBBB" + temp + "BBBBBBBBBB";
            char[] band = temp2.toCharArray();
            scanner.close();

            turingMaschine turing = new turingMaschine(zustaendeCount,anfangsZustand,endZustand,deltaTable);
            turing.runItBaby(band);


        } catch (FileNotFoundException e) {
            System.out.println("MAL");
        }
    }
}