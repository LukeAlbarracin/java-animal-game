import java.util.HashMap;
import java.util.Random;
public class PokeStats implements Cloneable {
	private int attack;
	private int spAttack;
	private int defense;
	private int spDefense;
	private int speed;
	private int health;
	private int level;
	private TempStats tempStats = new TempStats();
	
	public PokeStats () {
		this.attack = 10;
		this.spAttack = 10;
		this.defense = 10;
		this.spDefense = 10;
		this.speed = 10;
		this.health = 25;
		this.level = 25;
	}

	public PokeStats (int level, int attack, int spAttack, int defense, int spDefense, int speed, int health) {
		this.level = level;
		this.attack = attack;
		this.spAttack = spAttack;
		this.defense = defense;
		this.spDefense = spDefense;
		this.speed = speed;
		this.health = health;
	}

	public Object clone() throws CloneNotSupportedException {
		PokeStats statsClone = (PokeStats) super.clone();
		statsClone.setAttack(this.attack);
		statsClone.setSpAttack(this.spAttack);
		statsClone.setDefense(this.defense);
		statsClone.setSpDefense(this.spDefense);
		statsClone.setSpeed(this.speed);
		statsClone.setHealth(this.health);
		return statsClone;
	} 

	public void levelUp () {
		// Do some math stuff
	}

	public TempStats getTempStats() {
		return this.tempStats;
	}

	public int getAttack() {
		Stats stat = Stats.ATTACK;
		int eValue = (tempStats.effortValues.containsKey(stat) ? 0 : tempStats.effortValues.get(stat));
		double mod = (tempStats.statMods.containsKey(stat) ? 1 : tempStats.statMods.get(stat).getValue());
		return (int) ((((this.attack * 2 + tempStats.iValue + (eValue/4)) * (this.level/100)) + 5) * mod);
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getSpAttack() {
		Stats stat = Stats.SP_ATTACK;
		int eValue = (tempStats.effortValues.containsKey(stat) ? 0 : tempStats.effortValues.get(stat));
		double mod = (tempStats.statMods.containsKey(stat) ? 1 : tempStats.statMods.get(stat).getValue());
		return (int) ((((this.spAttack * 2 + tempStats.iValue + (eValue/4)) * (this.level/100)) + 5) * mod);
	}

	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}
	
	public int getDefense() {
		Stats stat = Stats.DEFENSE;
		int eValue = (tempStats.effortValues.containsKey(stat) ? 0 : tempStats.effortValues.get(stat));
		double mod = (tempStats.statMods.containsKey(stat) ? 1 : tempStats.statMods.get(stat).getValue());
		return (int) ((((this.defense * 2 + tempStats.iValue + (eValue/4)) * (this.level/100)) + 5) * mod);
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpDefense() {
		Stats stat = Stats.SP_DEFENSE;
		int eValue = (tempStats.effortValues.containsKey(stat) ? 0 : tempStats.effortValues.get(stat));
		double mod = (tempStats.statMods.containsKey(stat) ? 1 : tempStats.statMods.get(stat).getValue());
		return (int) ((((this.spDefense * 2 + tempStats.iValue + (eValue/4)) * (this.level/100)) + 5) * mod);
	}

	public void setSpDefense(int spDefense) {
		this.spDefense = spDefense;
	}
	
	public int getSpeed() {
		Stats stat = Stats.SPEED;
		int eValue = (tempStats.effortValues.containsKey(stat) ? 0 : tempStats.effortValues.get(stat));
		double mod = (tempStats.statMods.containsKey(stat) ? 1 : tempStats.statMods.get(stat).getValue());
		return (int) ((((this.speed * 2 + tempStats.iValue + (eValue/4)) * (this.level/100)) + 5) * mod);
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getHealth() {
		Stats stat = Stats.HEALTH;
		int eValue = (tempStats.effortValues.containsKey(stat) ? 0 : tempStats.effortValues.get(stat));
		return (int) (((tempStats.tempHealth * 2 + (eValue/4)) * (this.level/100)) + this.level + 10);
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getTempHealth() {
		return tempStats.tempHealth;
	}

	public int getLevel() {
		return this.level;
	}
}