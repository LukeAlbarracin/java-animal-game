import java.util.ArrayList;
public class Pokemon {
	protected int ownerNumber = 1; // SHOULD BE ABLE TO CHANGE FROM CONSTRUCTOR
	protected int pokemonLevel;
	protected PokeType pokemonType;
	protected boolean status = true;
	protected PokeStats baseStats;
	protected TempStats tempStats; 
	protected String pokemonName;
	protected ArrayList<StatusCondition> conditions = new ArrayList<StatusCondition>();
	protected Moves[] moveSet = {Moves.SPLASH, Moves.WATER_GUN};
	 
	void useMove(int moveNumber, Pokemon enemy) {
		Moves chosenMove = moveSet[moveNumber];
		int[] allTargets = chosenMove.getTarget().getAllTargets();
	
		System.out.println("enemy:" + ((enemy == null) ? "is null": "not null"));
		System.out.println("chose move: " + ((chosenMove == null) ? "is null": "not null"));

		for (int i = 0; i < allTargets.length; i++) {
			if (allTargets[i] == 3) {
				DamageEngine engine = DamageEngine.getInstance();
				System.out.println("engine: " + ((engine == null) ? "is null": "not null"));
				engine.calcDamage(this, enemy, chosenMove); 
				
			} 
		} 

		System.out.println("Get here.");

		if (chosenMove.getSecondaryTarget() == Target.SELF_INFLICT) {
			tempStats.setHealth(tempStats.getHealth() - chosenMove.getAttackPower());
		} else if (chosenMove.getSecondaryTarget() == Target.RECOIL) {
			tempStats.setHealth(tempStats.getHealth() - chosenMove.getAttackPower());
			System.out.println("It's hit with recoil");
		}
		
	}

	public void levelUp () {
		baseStats.levelUp();
		tempStats.levelUp();
	} // UPDATE CODE ... should be moved to PokemonStats class???
	
	private void resetStats () {}

	public void reduceHealth (int damage) {
		tempStats.setHealth(tempStats.getHealth() - damage);
	}

	public TempStats getTempPokemonStats() {
		return this.tempStats;
	}

	public void setTempPokemonStats(StatusChange statusChange, Increment statLevel) {
		this.tempStats.setVagueStat(statusChange, statLevel);
	}

	public PokeStats getBasePokemonStats() {
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
	
	public int getPokemonLevel() {
		return this.pokemonLevel;
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