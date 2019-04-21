public enum PokeName {
    CHIMCHAR (44, 58, 44, 58, 44, 61, new LearnSet(Moves.FLAMETHROWER, 25)),
    MONFERNO (64, 78, 52, 78, 52, 81),
    INFERNAPE (76, 104, 71, 104, 71, 108),
    PIPLUP (53, 51, 53, 61, 56, 40),
    PRINPLUP (64, 66, 68, 81, 76, 50),
    EMPOLEON (84, 86, 88, 111, 101, 60),
    TURTIG (55, 68, 64, 45, 55, 31),
    GROTLE (75, 89, 85, 55, 65, 36),
    TORTERRA (95, 109, 105, 75, 86, 56),
    MEW (100, 100, 100, 100, 100, 100);

    public Pokemon pokemon;

    private PokeName (int health, int attack, int defense, int spAttack, int spDefense, 
                      int speed, LearnSet ...learnSets) {
        this.pokemon = new Pokemon(health, attack, defense, spAttack, spDefense, speed);
    }
}