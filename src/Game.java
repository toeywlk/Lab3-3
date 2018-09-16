import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner kb = new Scanner(System.in);
    private  static int col,row;

    public static void main(String[] args){

        ox = new OX();
        while(true) {
            printTable();
            input();
            ox.put(col,row);
            if(ox.checkWin(col,row)) {
                printWin();
                printScore();
                ox.reset();
                continue;
            }
            if(ox.Draw()){
                printTable();
                printDraw();
                printScore();
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }

    }

    private static void printTable() {
        System.out.print(ox.getTableString());
    }

    private static void printDraw() {
        System.out.println("Draw");
    }

    private static void printScore() {
        System.out.println("X Win : " + ox.getCountX());
        System.out.println("O Win : " + ox.getCountO());
        System.out.println("Draw : " + ox.getCountDraw());
    }

    private static void printWin() {
        System.out.println(ox.getCurrentPlayer() + " Win");
    }

    public static void input(){
        boolean test = true;
        do{
            System.out.print(ox.getCurrentPlayer() + "(Col): ");
            col = kb.nextInt();
            System.out.print(ox.getCurrentPlayer() + "(Row): ");
            row = kb.nextInt();
            test = ox.put(col, row);
            if (!test) {
                System.out.println("Input number : 0-2");
            }
        }while(!test);

    }


}
