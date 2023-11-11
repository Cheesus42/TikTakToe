import java.util.Scanner;

public class TikTakToe {
    public static void main(String[] args) {
        String[] grid = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        boolean pOneTrue = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Platziere einen Stein indem die nummer des jeweiligen feldes eingegeben wird");
        System.out.println("1|2|3");
        System.out.println("4|5|6");
        System.out.println("7|8|9");
        while(!Jam(grid)) {
            if (Tie(grid)){
                System.out.println("Es ist unentschieden");
                break;
            }
            if (!Setzen(pOneTrue, grid, sc.nextInt())){
                System.out.println("Dieses Feld ist schon belegt");
                pOneTrue = !pOneTrue;
            }
            if(pOneTrue){
                System.out.println("Spieler o ist am Zug");
            }else{
                System.out.println("Spieler x ist am Zug");
            }
            System.out.println(grid[0] + "|" + grid[1] + "|" + grid[2] + "  | 1|2|3");
            System.out.println(grid[3] + "|" + grid[4] + "|" + grid[5] + "  | 4|5|6");
            System.out.println(grid[6] + "|" + grid[7] + "|" + grid[8] + "  | 7|8|9");
            pOneTrue = !pOneTrue;
        }
        if(!pOneTrue && !Tie(grid)) {
            System.out.println("Spieler x hat gewonnen");
        } else if (!Tie(grid)) {
            System.out.println("Spieler o hat gewonnen");
        }
    }
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
    public static boolean Jam(String[] grid){
        if(grid[0].equals(grid[1]) && grid[1].equals(grid[2]) && !grid[0].equals(" ")){
            return true;
        }
        if(grid[3].equals(grid[4]) && grid[4].equals(grid[5]) && !grid[3].equals(" ")){
            return true;
        }
        if(grid[6].equals(grid[7]) && grid[7].equals(grid[8]) && !grid[6].equals(" ")){
            return true;
        }
        if(grid[0].equals(grid[3]) && grid[3].equals(grid[6]) && !grid[0].equals(" ")){
            return true;
        }
        if(grid[1].equals(grid[4]) && grid[4].equals(grid[7]) && !grid[1].equals(" ")){
            return true;
        }
        if(grid[2].equals(grid[5]) && grid[5].equals(grid[8]) && !grid[2].equals(" ")){
            return true;
        }
        if(grid[0].equals(grid[4]) && grid[4].equals(grid[8]) && !grid[0].equals(" ")){
            return true;
        }
        if(grid[2].equals(grid[4]) && grid[4].equals(grid[6]) && !grid[2].equals(" ")){
            return true;
        }
        for (int i = 0; i < 9; i++) {
            if(grid[i].equals(" ")){
                return false;
            }
        }
        return false;
    }
    public static boolean Tie(String[] grid){
        for (int i = 0; i < 9; i++) {
            if(grid[i].equals(" ")){
                return false;
            }
        }
        return true;
    }
}