import java.util.Random;
public interface BattleConditions {
	default void initiateAttack(Animal attacker, Animal target, int accuracy, int calculatedDamage) {
		Random rand = new Random();
		int temp = rand.nextInt(100);
		if (accuracy < temp) {
			successfulHit(attacker, target, accuracy, calculatedDamage);
		} else {
			failedHit();
		}
	}
	
	default void successfulHit(Animal attacker, Animal target, int accuracy, int calculatedDamage) {
		target.setHealth(target.getHealth() - calculatedDamage);
		if (target.getHealth() <= 0) {
			target.setHealth(0);
			target.setStatus(false);
		}
		System.out.println(attacker.getName() + " hit " + target.getName() + " for " + calculatedDamage);
		System.out.println(target.getName() + " now has " + target.getHealth());
	}
	
	default void failedHit() {
		System.out.println(attacker.getName() + " has missed their attack");
	}
}