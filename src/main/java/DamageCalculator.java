import java.util.Random;
class DamageCalculator {
	private static DamageCalculator calc;

	public static DamageCalculator getInstance() {
		return calc;
	}

	private DamageCalculator() {}

	public void calcDamage (Pokemon attacker, Pokemon target, MoveSet chosenMove) {
		if (chosenMove.getAttackCategory() == AttackCategory.PHYSICAL) {
			int damage = calcDamage(attacker.getPokemonLevel(), chosenMove.getAttackPower(), attacker.getTempPokemonStats().getAttack(), target.getTempPokemonStats().getDefense());
			initiateAttack (attacker, target, chosenMove, damage);
		} else if (chosenMove.getAttackCategory() == AttackCategory.SPECIAL) {
			int damage = calcDamage(attacker.getPokemonLevel(), chosenMove.getAttackPower(), attacker.getTempPokemonStats().getSpAttack(), target.getTempPokemonStats().getSpDefense());
			initiateAttack (attacker, target, chosenMove, damage);
		}
	}

	private int calcDamage(int pokemonLevel, int attackPower, int arbAttack, int arbDef) {
		int rand = new Random().nextInt(256) + 39;
		return (int) (((((((((2*pokemonLevel)/5)+2)*arbAttack*attackPower)/arbDef)/50)+2)*rand)/255);
	}
	
	private void initiateAttack(Pokemon attacker, Pokemon target, MoveSet chosenMove, int damage) {
		int rand = new Random().nextInt(100);
		if (rand >= chosenMove.getAttackAcc()) {
			System.out.println(attacker.getPokemonName() + "'s attack missed...'");
		} else {
			// MAKE SOUND EFFECT?
			target.reduceHealth(damage);
			calculateEffects(target, chosenMove);
		}
	}
	
	private void calculateEffects (Pokemon target, MoveSet chosenMove) {
		int rand = new Random().nextInt(100);
		if (chosenMove.getSuccessRate() > rand) {
			for (int i = 0; i < chosenMove.getStatusChanges().length; i++) {
				if (chosenMove.getStatusChanges()[i].statusCondition != StatusCondition.DEFAULT_STATE) {
					target.setConditions(chosenMove.getStatusChanges()[i].statusCondition);
				} else {
					target.setTempPokemonStats(chosenMove.getStatusChanges()[i], chosenMove.getStatLevel());
				}
			}
		}

	}
}

	
