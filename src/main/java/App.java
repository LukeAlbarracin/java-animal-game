import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class App {
    static boolean turnIsOver = false;
    static ArrayList<Pokemon> partyOne;
    static ArrayList<Pokemon> partyTwo;
    static int battleSize = 1; // Up to 3     
    public static void main (String args[]) {
        //DamageCalculator calc = DamageCalculator.getInstance();
        
        Pokemon mew1 = new Mew();
        Pokemon mew2 = new Mew();


       //System.out.println("Health: " + mew1.getTempPokemonStats().getHealth());
       System.out.println("Welcome to Pokemon!");
       System.out.println("-----");
       System.out.println();
       System.out.println("Move 1 : Growl");
       System.out.println("Move 2 : Water Gun");
       System.out.println("Move 3 : Flamethrower");
       System.out.println("Move 4 : Leaf Blade");

       Scanner sc = new Scanner(System.in);
       System.out.println("Choose an above move");
       String s = sc.nextLine();
       int foo = Integer.parseInt(s);
       sc.close();
       mew1.useMove(foo, mew2);

       System.out.println("Remaining health of " + mew2.getBasePokemonStats().getHealth());
       
       //System.out.println("Mew 2 health : " + mew2.getHealth1());
            
    }
}

