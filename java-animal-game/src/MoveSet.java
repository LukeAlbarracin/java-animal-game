public enum MoveSet {
    FLAMETHROWER("flamethrower!", 95, 100, PokemonType.FIRE, AttackCategory.SPECIAL),
    LEAF_BLADE("leaf blade!", 90, 100, PokemonType.GRASS, AttackCategory.PHYSICAL),
    SPLASH("splash!  But nothing happened.", 0, 100, PokemonType.WATER, AttackCategory.SPECIAL),
    WATER_GUN("water gun!", 40, 100,PokemonType.WATER, AttackCategory.SPECIAL);
    
    public String battleText;
    public int attackPower;
    public int attackAcc;
    public PokemonType attackType;
    public AttackCategory attackCategory;

    private MoveSet (String battleText, int attackPower, int attackAcc, PokemonType attackType, AttackCategory attackCategory) {
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackAcc = attackAcc;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
	}
	
}