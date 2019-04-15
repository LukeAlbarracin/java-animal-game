public class PokemonStatMod extends PokemonStats {
    private StatStage attackMod = StatStage.UNCHANGED;
	private StatStage spAttackMod = StatStage.UNCHANGED;
	private StatStage defenseMod = StatStage.UNCHANGED;
	private StatStage spDefenseMod = StatStage.UNCHANGED;
	private StatStage speedMod = StatStage.UNCHANGED;
	private StatStage healthMod = StatStage.UNCHANGED;
	private StatStage evasivenessMod = StatStage.UNCHANGED;	

	public void setMod(StatStage statStage, int slider) {
		statStage = statStage.getNextStage(statStage.getIndex(statStage), slider);
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