import java.util.Random;
import java.util.ArrayList;
public abstract class Pokemon implements BattleConditions {
	protected PokemonType pokemonType;
	protected String name;
	protected boolean status;
	protected ArrayList<StatusCondition> conditions; 
	protected MoveSet[] moveSet = {MoveSet.LEAF_BLADE, MoveSet.WATER_GUN, MoveSet.FLAMETHROWER, MoveSet.SPLASH};
	protected int attack;
	protected int spAttack;
	protected int defense;
	protected int spDefense;
	protected int speed;
	protected int health;
	protected int level;
	protected int evasiveness; // needs to start at 100
	protected int turnsAsleep = 0;
	protected int turnsConfused = 0;
	protected int turnsFrozen = 0;

	public void useMove(int move, Pokemon target) {
		int index = move - 1;
		MoveSet chosenMove = moveSet[index];
	}

	public int damageAlgorithm (int attackerLevel, int attackPower, int arbAttack, int arbDef) {
		Random rand = new Random();
		int temp = rand.nextInt(256) + 217;
		return (int) (((((((((2 * attackerLevel)/ 5) + 2) * arbAttack * attackPower) / arbDef) /50) +2) * temp) / 255);
	}

	public void simStats (int level, int attack, int spAttack, int defense, int spDefense, int speed, int health) {
		final double statSlope = 1.5;
		this.attack = (int) (attack * statSlope);
		this.spAttack = (int) (spAttack * statSlope);
		this.defense = (int) (defense * statSlope);
		this.spDefense = (int) (speed * statSlope);
		this.speed = (int) (speed * statSlope);
		this.health = (int) (attack * statSlope);
	}

	public void simStatusCondition () {
		for (StatusCondition condition : conditions) {
			switch (condition) {
				case POISONED :
					condition.simPoison(this);
					break;
				case BURNED :
					condition.simBurn(this);
					break;
				case ASLEEP :
					condition.simSleep(this, this.turnsAsleep);
					break;
				case CONFUSED :
					condition.simConfusion(this, this.turnsConfused);
					break;
				case PARALYZED :
					condition.simParalysis(this);
					break;
				case FROZEN :
					condition.simFreeze(this, this.turnsFrozen);
					break;
				default :
					System.out.println("Error : EXTRA ITEM IN 'CONDITIONS' ARRAYLIST");
					break;
			}
		} 
	}

	public void setConditions (StatusCondition condition) {
		if (!conditions.contains(condition)) {
			if (condition == StatusCondition.BURNED && this.pokemonType == PokemonType.FIRE) {
				System.out.println(getName() + " cannot be burned...");
			} else if (condition == StatusCondition.POISONED && this.pokemonType == PokemonType.POISON) {
				System.out.println(getName() + " cannot be poisoned...");
			} else {
				this.conditions.add(condition);
			}	
		}
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getSpAttack() {
		return this.spAttack;
	}

	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}
	
	public int getDefense() {
		return this.defense;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpDefense() {
		return this.spDefense;
	}

	public void setSpDefense(int spDefense) {
		this.spDefense = spDefense;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getEvasiveness() {
		return this.evasiveness;
	}

	public void setEvasiveness(int evasiveness) {
		this.evasiveness = evasiveness;
	}
}






