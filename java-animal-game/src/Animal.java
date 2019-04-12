public abstract class Animal {
	protected String _name;
	protected int _health;
	protected int _shield;
	protected boolean _status;
	protected int _attack;
	protected int _defense;
	protected int _speed;
	protected int _level;
	
	public int getLevel() {
		return _level;
	}
	
	public void setLevel(int level) {
		_level = level;
	}
	
	public int getAttack() {
		return _attack;
	}
	
	public void setAttack(int attack) {
		_attack = attack;
	}
	
	public int getDefense() {
		return _defense;
	}
	
	public void setDefense(int defense) {
		_defense = defense;
	}
	
	public int getSpeed() {
		return _speed;
	}
	
	public void setSpeed(int speed) {
		_speed = speed;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public int getHealth() {
		return _health;
	}
	
	public void setHealth(int health) {
		_health = health;
	}
	
	public int getShield() {
		return _shield;
	}
	
	public void setShield(int shield) {
		_shield = shield;
	}
	
	public boolean getStatus() {
		return _status;
	}
	
	public void setStatus(boolean status) {
		_status = status;
	}
	
	
	
	
}
