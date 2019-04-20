import java.util.Random;
class DamageEngine {
	private static DamageEngine _instance;

	private DamageEngine() {}

	public static DamageEngine getInstance() {
		if (_instance == null) {
			System.out.println("Instance is null");
			_instance = new DamageEngine();
		} 
		return _instance;
	}

	public void calcDamage (Pokemon attacker, Pokemon target, Moves chosenMove) {
		if (chosenMove.getAttackCategory() == AttackCategory.PHYSICAL) {
			int damage = calcDamage(attacker.getPokemonLevel(), chosenMove.getAttackPower(), attacker.getTempPokemonStats().getAttack(), target.getTempPokemonStats().getDefense());
			initiateAttack (attacker, target, chosenMove, damage);
		} else if (chosenMove.getAttackCategory() == AttackCategory.SPECIAL) {
			int damage = calcDamage(attacker.getPokemonLevel(), chosenMove.getAttackPower(), attacker.getTempPokemonStats().getSpAttack(), target.getTempPokemonStats().getSpDefense());
			initiateAttack (attacker, target, chosenMove, damage);
		}
	}

	private int calcDamage(int level, int attackPower, int xAttack, int xDefense) {
		int rand = new Random().nextInt(256) + 39;
		System.out.println("xDefense: " + xDefense);
		return (int) (((((((((2*level)/5)+2)*xAttack*attackPower)/xDefense)/50)+2)*rand)/255);
	}
	
	private void initiateAttack(Pokemon user, Pokemon target, Moves chosenMove, int damage) {
		int rand = new Random().nextInt(100);
		if (rand >= chosenMove.getAttackAcc()) {
			System.out.println(user.getPokemonName() + "'s attack missed...'");
		} else {
			// MAKE SOUND EFFECT?
			target.reduceHealth(damage);
			calculateEffects(target, chosenMove);
		}
	}
	
	private void calculateEffects (Pokemon target, Moves chosenMove) {
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

	

