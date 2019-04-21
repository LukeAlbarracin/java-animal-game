import java.util.ArrayList;
import java.util.Scanner;
public class App {
    static boolean turnIsOver = false;
    static ArrayList<Pokemon> partyOne;
    static ArrayList<Pokemon> partyTwo;
    static int battleSize = 1; // Up to 3     
    public static void main (String args[]) {
        Pokemon mew1 = new Mew();
        Pokemon mew2 = new Mew();

        Moves[] moves = {Moves.GROWL, Moves.FLAMETHROWER, Moves.WATER_GUN};
        MainPage mp = new MainPage(moves);
        mp.run();
       
       System.out.println("Welcome to Pokemon!\n");   
       simMove(mew1, mew2);
       System.out.println("Remaining health of " + mew2.getBasePokemonStats().getTempHealth());
    }

    private static void simMove (Pokemon p, Pokemon target) {
        System.out.println("------------");
        for (int i = 0; i < p.moveSet.length; i++) {
            System.out.println("Move [" + (i+1) + "] : " + p.moveSet[i].getBattleText().toUpperCase());
        }
        System.out.println("------------");
        int moveNumber = Integer.parseInt(new Scanner(System.in).nextLine());

        p.useMove(moveNumber, target);
    }
}

