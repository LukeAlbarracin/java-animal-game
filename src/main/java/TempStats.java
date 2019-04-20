public class TempStats extends PokeStats {
    private StatsModifier attackMod = StatsModifier.UNCHANGED;
	private StatsModifier spAttackMod = StatsModifier.UNCHANGED;
	private StatsModifier defenseMod = StatsModifier.UNCHANGED;
	private StatsModifier spDefenseMod = StatsModifier.UNCHANGED;
	private StatsModifier speedMod = StatsModifier.UNCHANGED;
	private StatsModifier evasivenessMod = StatsModifier.UNCHANGED;
	private final int evasiveness = 100;

	public TempStats() {
		attackMod = StatsModifier.UNCHANGED;
		spAttackMod = StatsModifier.UNCHANGED;
		defenseMod = StatsModifier.UNCHANGED;
		spDefenseMod = StatsModifier.UNCHANGED;
		speedMod = StatsModifier.UNCHANGED;
		evasivenessMod = StatsModifier.UNCHANGED;
	}

	public TempStats(StatsModifier attackMod, StatsModifier spAttackMod, StatsModifier defenseMod, StatsModifier spDefenseMod,
					StatsModifier speedMod, StatsModifier evasivenessMod) {
		this.attackMod = attackMod;
		this.spAttackMod = spAttackMod;
		this.defenseMod = spDefenseMod;
		this.speedMod = speedMod;
		this.evasivenessMod = evasivenessMod;
	}

	public void setMod(StatsModifier statStage, Increment statLevel) {
		statStage = statStage.getNextStage(statStage.getIndex(statStage), statLevel.levelChange);
	}

	public void matchStat (StatusChange statusChange, Increment statLevel) {
		// HANDLE IF +- 6 STAGES, AND FOR STAGE 0 MAKE SURE NOTHING HAPPENS
		switch (statusChange) {
			case ATTACK :
				setMod(this.attackMod, statLevel);
				break;
			case SPECIAL_ATTACK :
				setMod(this.spAttackMod, statLevel);
				break;
			case DEFENSE :
				setMod(this.defenseMod, statLevel);
				break;
			case SPECIAL_DEFENSE :
				setMod(this.spDefenseMod, statLevel);
				break;
			case SPEED :
				setMod(this.speedMod, statLevel);
				break;
			case EVASIVENESS :
				setMod(this.evasivenessMod, statLevel);
				break;
			default :
				break;
		}
		if (statLevel.levelChange != 0) {
			System.out.println(" " + statusChange.battleText + " " + statLevel.statText);
			System.out.println("-------------");
		} else {
			System.out.println(" did not change...");
			System.out.println("-------------");
		}
	}

	@Override
	public int getAttack() {
		return (int) (super.attack * this.attackMod.getValue());
	}

	@Override
	public int getSpAttack() {
		return (int) (super.spAttack * this.spAttackMod.getValue());
	}

	@Override
	public int getDefense() {
		return (int) (super.defense * this.defenseMod.getValue());
	}

	@Override
	public int getSpDefense() {
		return (int) (super.spDefense * this.spDefenseMod.getValue());
	}

	@Override
	public int getSpeed() {
		return (int) (super.speed * this.speedMod.getValue());
	}

	@Override
	public void setHealth(int health) {
		super.health = health;
	}

	public int getHealth() {
		return this.health;
	}

	public int getEvasiveness() {
		return (int) (this.evasiveness * this.evasivenessMod.getValue());
	}

	public void resetStats() {
		this.attackMod = StatsModifier.UNCHANGED;
		this.spAttackMod = StatsModifier.UNCHANGED;
		this.defenseMod = StatsModifier.UNCHANGED;
		this.spDefenseMod = StatsModifier.UNCHANGED;
		this.speedMod = StatsModifier.UNCHANGED;
		this.evasivenessMod = StatsModifier.UNCHANGED;	
	}

}