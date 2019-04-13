public enum MoveSet {
    
    FLAMETHROWER("flamethrower!", 95, 100, PokemonType.FIRE, AttackCategory.SPECIAL, Target.CHOOSE_ONE, 0),
    LEAF_BLADE("leaf blade!", 90, 100, PokemonType.GRASS, AttackCategory.PHYSICAL, Target.CHOOSE_ONE, 0),
    SPLASH("splash!  But nothing happened...", 0, 100, PokemonType.WATER, AttackCategory.SPECIAL, Target.NO_TARGET, 0),
    WATER_GUN("water gun!", 40, 100,PokemonType.WATER, AttackCategory.SPECIAL, Target.CHOOSE_ONE, 0);

    public String battleText = "";
    public int attackPower = 0;
    public int attackAcc = 0;
    public PokemonType attackType;
    public AttackCategory attackCategory;
    public Target target;
    public Target target2;
    public int successRate;
    public StatLevel statLevel;
    public StatusChange[] statusChanges;
    public int recoilDamage;
    public int minDamage;
    public int maxDamage;

    private MoveSet (String battleText, int attackPower, int attackAcc, PokemonType attackType, AttackCategory attackCategory, 
                    Target target, int successRate, StatLevel statLevel, StatusChange ...statusChanges) {
        // Used for ordinary moves (e.g. Scratch, Water Gun) or moves with chance for side effects (Sludge Bomb, Mud Slap, Thunderbolt) 
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackAcc = attackAcc;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
        this.successRate = successRate;
        this.statLevel = statLevel;
        this.statusChanges = statusChanges;
    }

    private MoveSet (String battleText, int attackPower, PokemonType attackType, AttackCategory attackCategory, 
                    Target target, int successRate, StatLevel statLevel, StatusChange ...statusChanges) {
        // Used for moves whose side effects activate upon a hit (e.g. Dynamic Punch) or moves like Thunder Wave, Toxic
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
        this.successRate = successRate;
        this.statLevel = statLevel;
        this.statusChanges = statusChanges;
    }
    
    private MoveSet (String battleText, int attackPower, int attackAcc, PokemonType attackType, AttackCategory attackCategory, 
                    Target target, int successRate, StatLevel statLevel, Target target2, StatusChange ...statusChanges) {
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackPower = attackAcc;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
        this.successRate = successRate;
        this.statLevel = statLevel;
        this.target2 = target2;
        this.statusChanges = statusChanges;

        // Used for moves whose side effects contains a separate target (e.g. Close Combat, Draco Meteor, Memento)
    }

    private MoveSet (String battleText, int attackPower, int attackAcc, PokemonType attackType, AttackCategory attackCategory, 
                    Target target, int recoilDamage) {
        // Used for moves with a recoil (e.g. Wood Hammer, Flare Blitz, Brave Bird)
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
        this.recoilDamage = recoilDamage;
    }

    private MoveSet (String battleText, int minDamage, int maxDamage, int attackAcc, PokemonType attackType, 
                    AttackCategory attackCategory, Target target) {
        // Used for moves with varying amounts of damage (e.g. Magnitude, Rollout, Bulletseed)
        this.battleText = battleText;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.attackAcc = attackAcc;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
    }
	
}