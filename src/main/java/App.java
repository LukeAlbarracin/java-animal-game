import java.util.ArrayList;
public class App {
    static boolean turnIsOver = false;
    static ArrayList<Pokemon> partyOne;
    static ArrayList<Pokemon> partyTwo;
    static int battleSize = 1; // Up to 3     
    public static void main (String args[]) {
        //DamageCalculator calc = DamageCalculator.getInstance();
        
        Pokemon mew1 = new Mew();
        Pokemon mew2 = new Mew();

       mew1.useMove(1, mew2);
       System.out.println("Hello Pokemon!!!");
       //System.out.println("Mew 2 health : " + mew2.getHealth1());
            
    }
}

