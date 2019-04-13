import java.util.Random;
public interface BattleConditions {

	public int damageAlgorithm(int level, int attackPower, int attack, int defense);

	default int calculateDamage (Pokemon attacker, Pokemon target, int attackPower, AttackCategory attackCategory) {
		if (attackCategory == AttackCategory.PHYSICAL) {
			return damageAlgorithm(attacker.level, attackPower, attacker.attack, target.defense);
		} else if (attackCategory == AttackCategory.SPECIAL) {
			return damageAlgorithm(attacker.level, attackPower, attacker.spAttack, target.spDefense);
		} else if (attackCategory == AttackCategory.SPECIAL_WITH_UNIQUE_EFFECTS){
			// Attacks like seismic toss, dragon rage 
			return attackPower;
		} else {
			return 0;
		}
	}

	default void initiateAttack(Pokemon attacker, Pokemon target, int accuracy, int calculatedDamage) {
		Random rand = new Random();
		int temp = rand.nextInt(100);
		if (accuracy < temp) {
			successfulHit(attacker, target, accuracy, calculatedDamage);
		} else {
			failedHit(attacker);
		}
	}
	
	default void successfulHit(Pokemon attacker, Pokemon target, int accuracy, int calculatedDamage) {
		target.setHealth(target.getHealth() - calculatedDamage);
		if (target.getHealth() <= 0) {
			target.setHealth(0);
			target.setStatus(false);
		}
		System.out.println(attacker.getName() + " hit " + target.getName() + " for " + calculatedDamage);
		System.out.println(target.getName() + " now has " + target.getHealth());
	}
	
	default void failedHit(Pokemon attacker) {
		System.out.println(attacker.getName() + " has missed their attack");
	}
}
