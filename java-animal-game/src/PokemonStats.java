public class PokemonStats implements Cloneable {
	protected int attack;
	protected int spAttack;
	protected int defense;
	protected int spDefense;
	protected int speed;
	protected int health;
	protected int evasiveness; // needs to start at 100
	
	public Object clone() throws CloneNotSupportedException {
		PokemonStats statsClone = (PokemonStats) super.clone();
		statsClone.setAttack(this.attack);
		statsClone.setSpAttack(this.spAttack);
		statsClone.setDefense(this.defense);
		statsClone.setSpDefense(this.spDefense);
		statsClone.setSpeed(this.speed);
		statsClone.setHealth(this.health);
		statsClone.setEvasiveness(this.evasiveness);
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

	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}

	public int getEvasiveness() {
		return this.evasiveness;
	}

	public void setEvasiveness(int evasiveness) {
		this.evasiveness = evasiveness;
	}
}