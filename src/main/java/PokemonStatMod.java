public class PokemonStatMod extends PokemonStats {
    private StatStage attackMod = StatStage.UNCHANGED;
	private StatStage spAttackMod = StatStage.UNCHANGED;
	private StatStage defenseMod = StatStage.UNCHANGED;
	private StatStage spDefenseMod = StatStage.UNCHANGED;
	private StatStage speedMod = StatStage.UNCHANGED;
	private StatStage healthMod = StatStage.UNCHANGED;
	private StatStage evasivenessMod = StatStage.UNCHANGED;	

	public PokemonStatMod() {
		this.attack = 15;
		this.spAttack = 10;
		this.defense = 15;
		this.spDefense = 10;
		this.speed = 10;
		this.health = 25;
		this.evasiveness = 100;
	}

	public void setMod(StatStage statStage, StatLevel statLevel) {
		statStage = statStage.getNextStage(statStage.getIndex(statStage), statLevel.levelChange);
	}

	public void setVagueStat (StatusChange statusChange, StatLevel statLevel) {
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
			case HEALTH :
				setMod(this.healthMod, statLevel);
				break;
			case EVASIVENESS :
				setMod(this.evasivenessMod, statLevel);
				break;
			default :
				break;

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
	public int getHealth() {
		return (int) (super.health * this.healthMod.getValue());
	}

	@Override
	public int getEvasiveness() {
		return (int) (super.evasiveness * this.evasivenessMod.getValue());
	}

	public void resetStats() {
		this.attackMod = StatStage.UNCHANGED;
		this.spAttackMod = StatStage.UNCHANGED;
		this.defenseMod = StatStage.UNCHANGED;
		this.spDefenseMod = StatStage.UNCHANGED;
		this.speedMod = StatStage.UNCHANGED;
		this.healthMod = StatStage.UNCHANGED;
		this.evasivenessMod = StatStage.UNCHANGED;	
	}

}