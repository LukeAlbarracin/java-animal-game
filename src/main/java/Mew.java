import java.util.ArrayList;
public class Mew extends Pokemon {
    public Mew() {
        super.ownerNumber = 1;
        super.pokemonType = PokeType.PSYCHIC;
        super.pokemonName = "Mew";
        super.status = true;
        super.baseStats = new PokeStats();
    }
}