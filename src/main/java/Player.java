import java.util.ArrayList;
public class Player {
    private ArrayList<PokeName> pokemonParty = new ArrayList<PokeName>();
    private String name = "";
   
    public Player (String name) {
        this.name = name;
    }

    public void addToParty(String name, PokeName monster) {
        // incorporate name somewhere
        this.pokemonParty.add(monster);
    }

    public ArrayList<PokeName> getPokemonParty () {
        return this.pokemonParty;
    }

    public String getName() {
        return this.name;
    }




}