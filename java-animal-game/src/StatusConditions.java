public interface StatusConditions {
	default void inflictDamage (Animal animal) {
		animal.setHealth(animal.getHealth()-10); //Induces 10 damage
	}
	
	default void inflictDamage (Animal animal, int damage) {
		animal.setHealth(animal.getHealth()-damage);
	}
	
	public void declareStatus();
}
