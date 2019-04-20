import java.util.ArrayList;
public class Pokemon {
	protected int ownerNumber; // SHOULD BE ABLE TO CHANGE FROM CONSTRUCTOR
	protected PokeType pokemonType;
	protected boolean status = true;
	protected PokeStats baseStats;
	protected String pokemonName;
	protected ArrayList<StatusCondition> conditions = new ArrayList<StatusCondition>();
	protected Moves[] moveSet = {Moves.GROWL, Moves.WATER_GUN, Moves.FLAMETHROWER, Moves.LEAF_BLADE};
	 
	void useMove(int moveNumber, Pokemon enemy) {
		Moves chosenMove = moveSet[moveNumber-1];
		int[] allTargets = chosenMove.getTarget().getAllTargets();

		for (int i = 0; i < allTargets.length; i++) {
			if (allTargets[i] == 3) {
				DamageEngine engine = DamageEngine.getInstance();
				engine.calcDamage(this, enemy, chosenMove); 
			} 
		} 

		if (chosenMove.getSecondaryTarget() == Target.SELF_INFLICT) {
			reduceHealth(chosenMove.getAttackPower());
		} else if (chosenMove.getSecondaryTarget() == Target.RECOIL) {
			reduceHealth(chosenMove.getRecoilDamage());
			System.out.println("It's hit with recoil");
		}
		
	}

	public void levelUp () {
		baseStats.levelUp();
	} // UPDATE CODE ... should be moved to PokemonStats class???
	
	private void resetStats () {}

	public void reduceHealth (int damage) {
		baseStats.getTempStats().setTempHealth(baseStats.getTempHealth() - damage);
	}

	public void setTempPokemonStats(StatusChange statusChange, Increment statLevel) {
		this.baseStats.getTempStats().matchStat(statusChange, statLevel);
	}

	public int getLevel() {
		return getBasePokemonStats().getLevel();
	}

	public PokeStats getBasePokemonStats() {
		if (this.baseStats == null) {
			return new PokeStats();
		}
		return this.baseStats;
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