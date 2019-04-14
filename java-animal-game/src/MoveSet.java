public enum MoveSet {
    
    FLAMETHROWER("flamethrower!", 95, 100, PokemonType.FIRE, AttackCategory.SPECIAL, Target.CHOOSE_ONE, 0),
    LEAF_BLADE("leaf blade!", 90, 100, PokemonType.GRASS, AttackCategory.PHYSICAL, Target.CHOOSE_ONE, 0),
    SPLASH("splash!  But nothing happened...", 0, 100, PokemonType.WATER, AttackCategory.SPECIAL, Target.NO_TARGET, 0),
    WATER_GUN("water gun!", 40, 100,PokemonType.WATER, AttackCategory.SPECIAL, Target.CHOOSE_ONE, 0);

    private String battleText = "";
    private int attackPower = 0;
    private int attackAcc = 0;
    private PokemonType attackType = PokemonType.NO_TYPE;
    private AttackCategory attackCategory;
    private Target target = Target.NO_TARGET;
    private Target target2 = Target.NO_TARGET;
    private int successRate = 0;
    private StatLevel statLevel = StatLevel.NOTHING;
    private int turnsDelayed = 0;
    private StatusChange[] statusChanges = {};
    private int recoilDamage = 0;
    private int minDamage = 0;
    private int maxDamage = 0;

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

    private MoveSet (String battleText, int attackPower, int attackAcc, PokemonType attackType, 
                    AttackCategory attackCategory, Target target, int turnsDelayed, StatusChange ...statusChanges) {
            this.battleText = battleText;
            this.attackPower = attackPower;
            this.attackAcc = attackAcc;
            this.attackType = attackType;
            this.attackCategory = attackCategory;
            this.target = target;
            this.turnsDelayed = turnsDelayed;
            this.statusChanges = statusChanges;
        }

    public String getBattleText() {
        return this.battleText;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getAttackAcc() {
        return this.attackAcc;
    }

    public PokemonType getAttackType() {
        return this.attackType;
    }

    public AttackCategory getAttackCategory() {
        return this.attackCategory;
    }

    public Target getTarget() {
        return this.target;
    }

    public Target getTarget2() {
        return this.target2;
    }

    public int getSuccessRate() {
        return this.successRate;
    }

    public StatLevel getStatLevel() {
        return this.statLevel;
    }

    public int getTurnsDelayed() {
        return this.turnsDelayed;
    }

    public StatusChange[] getStatusChanges() {
        return this.statusChanges;
    }

    public int getRecoilDamage() {
        return this.recoilDamage;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }
	
}