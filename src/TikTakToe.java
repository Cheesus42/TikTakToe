import java.util.Scanner;

public class TikTakToe {
    public static void main(String[] args) {

        //Array zum Speichern und auslesen des Spielstandes
        String[] grid = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

        //boolean zum Prüfen welcher Spieler an der Reihe ist
        boolean pOneTrue = true;
        Scanner sc = new Scanner(System.in);

        //Ausgabe des feldes mit nummerierung
        System.out.println("Platziere einen Stein indem die nummer des jeweiligen feldes eingegeben wird");
        System.out.println("1|2|3");
        System.out.println("4|5|6");
        System.out.println("7|8|9");

        //Gameplayloop läuft, solange keine abbruchbedingung anfällt (Spieler gewinnt oder unentschieden
        while(!Jam(grid)) {
            if (Tie(grid)){
                //Ausgabe bei unentschieden
                System.out.println("Es ist unentschieden");
                break;
            }
            if (!Setzen(pOneTrue, grid, sc.nextInt())){
                //Ausgabe, falls ein feld schon belegt ist
                System.out.println("Dieses Feld ist schon belegt");
                pOneTrue = !pOneTrue;
            }

            //Information für die Spieler wer am zug ist
            if(pOneTrue){
                System.out.println("Spieler o ist am Zug");
            }else{
                System.out.println("Spieler x ist am Zug");
            }

            //Ausgabe des Spielfelds mit Information zu
            System.out.println(grid[0] + "|" + grid[1] + "|" + grid[2] + "  | 1|2|3");
            System.out.println(grid[3] + "|" + grid[4] + "|" + grid[5] + "  | 4|5|6");
            System.out.println(grid[6] + "|" + grid[7] + "|" + grid[8] + "  | 7|8|9");
            pOneTrue = !pOneTrue;
        }

        //Ausgabe, wenn und welcher Spieler gewonnen hat
        if(!pOneTrue && !Tie(grid)) {
            System.out.println("Spieler x hat gewonnen");
        } else if (!Tie(grid)) {
            System.out.println("Spieler o hat gewonnen");
        }
    }
    //Methode zum Setzen eines Steins
    public static boolean Setzen(boolean pOneTrue, String[] grid, int input){
        int feld = input - 1;
        //Prüft ob Feld Frei
        if (grid[feld].equals(" ")) {

            //Spielerwechsel
            if(pOneTrue){
                grid[feld] = "x";
            }else{
                grid[feld] = "o";
            }
            return true;
        }else{
            return false;
        }
    }

    //Methode zum Prüfen einer gewinnbedingung
    public static boolean Jam(String[] grid){
        if(grid[0].equals(grid[1]) && grid[1].equals(grid[2]) && !grid[0].equals(" ")){
            /*
            x|x|x
             | |
             | |
             */
            return true;
        }
        if(grid[3].equals(grid[4]) && grid[4].equals(grid[5]) && !grid[3].equals(" ")){
            /*
             | |
            x|x|x
             | |
             */
            return true;
        }
        if(grid[6].equals(grid[7]) && grid[7].equals(grid[8]) && !grid[6].equals(" ")){
            /*
             | |
             | |
            x|x|x
             */
            return true;
        }
        if(grid[0].equals(grid[3]) && grid[3].equals(grid[6]) && !grid[0].equals(" ")){
            /*
            x| |
            x| |
            x| |
             */
            return true;
        }
        if(grid[1].equals(grid[4]) && grid[4].equals(grid[7]) && !grid[1].equals(" ")){
            /*
             |x|
             |x|
             |x|
             */
            return true;
        }
        if(grid[2].equals(grid[5]) && grid[5].equals(grid[8]) && !grid[2].equals(" ")){
            /*
             | |x
             | |x
             | |x
             */
            return true;
        }
        if(grid[0].equals(grid[4]) && grid[4].equals(grid[8]) && !grid[0].equals(" ")){
            /*
            x| |
             |x|
             | |x
             */
            return true;
        }
        if(grid[2].equals(grid[4]) && grid[4].equals(grid[6]) && !grid[2].equals(" ")){
            /*
             | |x
             |x|
            x| |
             */
            return true;
        }
        //keine Siegbedingung erfüllt: Spiel geht weiter
        return false;
    }
    public static boolean Tie(String[] grid){
        //Abfrage für ein unentschieden
        for (int i = 0; i < 9; i++) {
            if(grid[i].equals(" ")){
                return false;
            }
        }
        return true;
    }
}