public enum MoveSet {
    
    FLAMETHROWER("flamethrower!", 95, 100, PokemonType.FIRE, AttackCategory.SPECIAL, Target.CHOOSE_ONE, 0),
    LEAF_BLADE("leaf blade!", 90, 100, PokemonType.GRASS, AttackCategory.PHYSICAL, Target.CHOOSE_ONE, 0),
    SPLASH("splash!  But nothing happened...", 0, 100, PokemonType.WATER, AttackCategory.SPECIAL, Target.NO_TARGET, 0),
    WATER_GUN("water gun!", 40, 100,PokemonType.WATER, AttackCategory.SPECIAL, Target.CHOOSE_ONE, 0);

    public String battleText;
    public int attackPower;
    public int attackAcc;
    public PokemonType attackType;
    public AttackCategory attackCategory;

    private MoveSet (String battleText, int attackPower, int attackAcc, PokemonType attackType, AttackCategory attackCategory, Target target, int successRate, StatusCondition ...conditions) {
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackAcc = attackAcc;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
    }
    
    private MoveSet (String battleText, int attackPower, int attackAcc, PokemonType attackType, AttackCategory attackCategory, 
                    Target target, int successRate, StatLevel statLevel, Target target_two, PokemonStat ...pokemonStat) {

    }
	
}