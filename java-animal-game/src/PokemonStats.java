public class PokemonStats {
	private int attack;
	private int spAttack;
	private int defense;
	private int spDefense;
	private int speed;
	private int health;
	private int evasiveness; // needs to start at 100
	private boolean status;
	
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