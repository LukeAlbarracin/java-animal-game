import java.util.ArrayList;
public class Pokemon {
	private final int ownerNumber = 1; // SHOULD BE ABLE TO CHANGE FROM CONSTRUCTOR
	private int pokemonLevel;
	private PokemonType pokemonType;
	private boolean status;
	private PokemonStats basePokemonStats;
	private PokemonStatMod tempPokemonStats;
	private String pokemonName;
	private ArrayList<StatusCondition> conditions; 
	private MoveSet[] moveSet = {};
	
	private void useMove(int moveNumber, Pokemon enemy) {
		MoveSet chosenMove = moveSet[moveNumber];
		int[] allTargets = chosenMove.getTarget().getAllTargets();
	
		for (int i = 0; i < allTargets.length; i++) {
			if (allTargets[i] == 3) {
				 App.damageCalc.calcDamage(this, enemy, chosenMove);
			} 
		} 

		if (chosenMove.getSecondaryTarget() == Target.SELF_INFLICT) {
			tempPokemonStats.setHealth(tempPokemonStats.getHealth() - chosenMove.getAttackPower());
		} else if (chosenMove.getSecondaryTarget() == Target.RECOIL) {
			tempPokemonStats.setHealth(tempPokemonStats.getHealth() - chosenMove.getAttackPower());
			System.out.println("It's hit with recoil");
		}
		
	}


	public void levelUp () {
		basePokemonStats.levelUp();
		tempPokemonStats.levelUp();
	} // UPDATE CODE ... should be moved to PokemonStats class???
	
	private void resetStats () {}

	public void reduceHealth (int damage) {
		tempPokemonStats.setHealth(tempPokemonStats.getHealth() - damage);
	}

	public PokemonStats getTempPokemonStats() {
		return this.tempPokemonStats;
	}

	public PokemonStats getBasePokemonStats() {
		return this.basePokemonStats;
	}
	
	public void setConditions (StatusCondition condition) {
		if (!conditions.contains(condition)) {
			this.conditions.add(condition);
		}
	}
	
	public String getPokemonName() {
		return this.pokemonName;
	}
	
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	
	public int getPokemonLevel() {
		return this.pokemonLevel;
	}
	
	public void setLevel(int pokemonLevel) {
		this.pokemonLevel = pokemonLevel;
	}

	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}

/*
	public void simStatusCondition () {
		for (StatusCondition condition : conditions) {
			switch (condition) {
				case POISONED :
					condition.simPoison(this);
					break;
				case BURNED :
					condition.simBurn(this);
					break;
				case ASLEEP :
					condition.simSleep(this, this.turnsAsleep);
					break;
				case CONFUSED :
					condition.simConfusion(this, this.turnsConfused);
					break;
				case PARALYZED :
					condition.simParalysis(this);
					break;
				case FROZEN :
					condition.simFreeze(this, this.turnsFrozen);
					break;
				default :
					System.out.println("Error : EXTRA ITEM IN 'CONDITIONS' ARRAYLIST");
					break;
			}
		}
	} */

/* else if (App.battleSize == 2) {
			for (int i = 0; i < allTargets.length; i++) {
				if (allTargets[i] < 2) {
					this.calculateDamage(this, ownParty.get(allTargets[i]), chosenMove.getAttackPower(), chosenMove.getAttackCategory());
				} else if (allTargets[i] > 2 && allTargets[i] < 5) {
					this.calculateDamage(this, enemyParty.get(allTargets[i]-3), chosenMove.getAttackPower(), chosenMove.getAttackCategory());
				}
			}
		} else {
			for (int i = 0; i < allTargets.length; i++) {
				if (allTargets[i] < 3) {
					this.calculateDamage(this, ownParty.get(allTargets[i]), chosenMove.getAttackPower(), chosenMove.getAttackCategory());
				} else if (allTargets[i] > 2) {
					this.calculateDamage(this, enemyParty.get(allTargets[i]-3), chosenMove.getAttackPower(), chosenMove.getAttackCategory());
				}
			}
		} */