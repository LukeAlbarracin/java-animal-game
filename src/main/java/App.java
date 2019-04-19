import java.util.ArrayList;
public class App {
    static boolean turnIsOver = false;
    static DamageCalculator damageCalc;
    static ArrayList<Pokemon> partyOne;
    static ArrayList<Pokemon> partyTwo;
    static int battleSize = 1; // Up to 3     
    public static void main (String args[]) {
        DamageCalculator calc = DamageCalculator.getInstance();
        
        Pokemon mew1 = new Mew();
        Pokemon mew2 = new Mew();

        //while (mew2.getTempPokemonStats().getHealth() > 1) {
        //calc.calcDamage(mew1, mew2, MoveSet.WATER_GUN);
            
    }
}

