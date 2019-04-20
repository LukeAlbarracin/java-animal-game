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
		this.tempStats.tempHealth = this.health;
	}

	public PokeStats (int level, int attack, int spAttack, int defense, int spDefense, int speed, int health) {
		this.level = level;
		this.attack = attack;
		this.spAttack = spAttack;
		this.defense = defense;
		this.spDefense = spDefense;
		this.speed = speed;
		this.health = health;
		this.tempStats.tempHealth = this.health;
	}

	public Object clone() throws CloneNotSupportedException {
		PokeStats replica = (PokeStats) super.clone();
		replica.setAttack(this.attack);
		replica.setSpAttack(this.spAttack);
		replica.setDefense(this.defense);
		replica.setSpDefense(this.spDefense);
		replica.setSpeed(this.speed);
		replica.setHealth(this.health);
		replica.setTempStats(((this.tempStats.clone() == null) ? new TempStats() : this.tempStats.clone()));
		return replica;
	} 

	public void levelUp () {
		this.level++;
	}

	public TempStats getTempStats() {
		return this.tempStats;
	}

	public void setTempStats (Object tempStats) {
		if (tempStats instanceof TempStats) {
			this.tempStats = (TempStats) tempStats;
		} else {
			System.out.println("Error in cloning method of PokeStats / TempStats. Null Pointer...");
		}
	}

	public int getAttack() {
		Stats stat = Stats.ATTACK;
		int eValue = (tempStats.effortValues.containsKey(stat) ? tempStats.effortValues.get(stat) : 0);
		double mod = (tempStats.statMods.containsKey(stat) ? tempStats.statMods.get(stat).getValue() : 1);
		return (int) ((((this.attack * 2 + tempStats.I_VALUE + (eValue/4)) * (this.level/100)) + 5) * mod);
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getSpAttack() {
		Stats stat = Stats.SP_ATTACK;
		int eValue = (tempStats.effortValues.containsKey(stat) ? tempStats.effortValues.get(stat) : 0);
		double mod = (tempStats.statMods.containsKey(stat) ? tempStats.statMods.get(stat).getValue() : 1);
		return (int) ((((this.spAttack * 2 + tempStats.I_VALUE + (eValue/4)) * (this.level/100)) + 5) * mod);
	}

	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}
	
	public int getDefense() {
		Stats stat = Stats.DEFENSE;
		int eValue = (tempStats.effortValues.containsKey(stat) ? tempStats.effortValues.get(stat) : 0);
		double mod = (tempStats.statMods.containsKey(stat) ? tempStats.statMods.get(stat).getValue() : 1);
		return (int) ((((this.defense * 2 + tempStats.I_VALUE + (eValue/4)) * (this.level/100)) + 5) * mod);
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpDefense() {
		Stats stat = Stats.SP_DEFENSE;
		int eValue = (tempStats.effortValues.containsKey(stat) ? tempStats.effortValues.get(stat) : 0);
		double mod = (tempStats.statMods.containsKey(stat) ? tempStats.statMods.get(stat).getValue() : 1);
		return (int) ((((this.spDefense * 2 + tempStats.I_VALUE + (eValue/4)) * (this.level/100)) + 5) * mod);
	}

	public void setSpDefense(int spDefense) {
		this.spDefense = spDefense;
	}
	
	public int getSpeed() {
		Stats stat = Stats.SPEED;
		int eValue = (tempStats.effortValues.containsKey(stat) ? tempStats.effortValues.get(stat) : 0);
		double mod = (tempStats.statMods.containsKey(stat) ? tempStats.statMods.get(stat).getValue() : 1);
		return (int) ((((this.speed * 2 + tempStats.I_VALUE + (eValue/4)) * (this.level/100)) + 5) * mod);
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getHealth() {
		Stats stat = Stats.HEALTH;
		int eValue = (tempStats.effortValues.containsKey(stat) ? tempStats.effortValues.get(stat) : 0);
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