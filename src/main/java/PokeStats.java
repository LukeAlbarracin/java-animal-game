public class PokeStats implements Cloneable {
	protected int attack;
	protected int spAttack;
	protected int defense;
	protected int spDefense;
	protected int speed;
	protected int health;
	// needs to start at 100
	
	public PokeStats () {
		this.attack = 10;
		this.spAttack = 10;
		this.defense = 10;
		this.spDefense = 10;
		this.speed = 10;
		this.health = 25;
	}

	public PokeStats (int attack, int spAttack, int defense, int spDefense, int speed, int health) {
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
	
	public void setHealth(int health) {
		this.health = health;
	}
}