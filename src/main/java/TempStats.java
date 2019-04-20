import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class TempStats implements Cloneable {
	final int EVASIVENESS = 100;
	final int I_VALUE = new Random().nextInt(32);
	int tempHealth;
	HashMap<Stats,StatsMods> statMods = new HashMap<>(Map.of(Stats.ATTACK, StatsMods.DEFAULT,
																	Stats.SP_ATTACK, StatsMods.DEFAULT,
																	Stats.DEFENSE, StatsMods.DEFAULT,
																	Stats.SP_DEFENSE, StatsMods.DEFAULT,
																	Stats.SPEED, StatsMods.DEFAULT,
																	Stats.EVASIVENESS, StatsMods.DEFAULT,
																	Stats.ACCURACY, StatsMods.DEFAULT));
	HashMap<Stats,Integer> effortValues = new HashMap<>(Map.of(Stats.ATTACK, 0,
																	  Stats.SP_ATTACK, 0,
																	  Stats.DEFENSE, 0,
																	  Stats.SP_DEFENSE, 0,
																	  Stats.SPEED, 0,
																	  Stats.HEALTH, 0));

	public Object clone() throws CloneNotSupportedException {
		TempStats replica = (TempStats) super.clone();
		replica.tempHealth = this.tempHealth;
		replica.statMods = this.statMods;
		replica.effortValues = this.effortValues;
		return replica;
	} 

	void setMod(Stats stat, StatsMods statStage, Increment statLevel) {
		statMods.put(stat, statStage.getNextStage(statStage.getIndex(statStage), statLevel.levelChange));
	}

	void matchStat (StatusChange statusChange, Increment statLevel) {
		// HANDLE IF +- 6 STAGES, AND FOR STAGE 0 MAKE SURE NOTHING HAPPENS
		switch (statusChange) {
			case ATTACK :
				setMod(Stats.ATTACK, this.statMods.get(Stats.ATTACK), statLevel);
				break;
			case SPECIAL_ATTACK :
				setMod(Stats.SP_ATTACK, this.statMods.get(Stats.SP_ATTACK), statLevel);
				break;
			case DEFENSE :
				setMod(Stats.DEFENSE, this.statMods.get(Stats.DEFENSE), statLevel);
				break;
			case SPECIAL_DEFENSE :
				setMod(Stats.SP_DEFENSE, this.statMods.get(Stats.SP_DEFENSE), statLevel);
				break;
			case SPEED :
				setMod(Stats.SPEED, this.statMods.get(Stats.SPEED), statLevel);
				break;
			case EVASIVENESS :
				setMod(Stats.EVASIVENESS, statMods.get(Stats.EVASIVENESS), statLevel);
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

	void setTempHealth (int health) {
		this.tempHealth = health;
	}

}

/* import java.util.HashMap;
import java.util.Random;
public class TempStats extends PokeStats {
    private StatsModifier attackMod = StatsModifier.UNCHANGED;
	private StatsModifier spAttackMod = StatsModifier.UNCHANGED;
	private StatsModifier defenseMod = StatsModifier.UNCHANGED;
	private StatsModifier spDefenseMod = StatsModifier.UNCHANGED;
	private StatsModifier speedMod = StatsModifier.UNCHANGED;
	private StatsModifier evasivenessMod = StatsModifier.UNCHANGED;
	private final int evasiveness = 100;
	private int iValue; // individual value
	private HashMap<Stats, Integer> effortValues = new HashMap<>();
	

	public TempStats() {
		attackMod = StatsModifier.UNCHANGED;
		spAttackMod = StatsModifier.UNCHANGED;
		defenseMod = StatsModifier.UNCHANGED;
		spDefenseMod = StatsModifier.UNCHANGED;
		speedMod = StatsModifier.UNCHANGED;
		evasivenessMod = StatsModifier.UNCHANGED;
		this.iValue = new Random().nextInt(32);
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
		return (int) (super.getAttack() * this.attackMod.getValue());
	}

	@Override
	public int getSpAttack() {
		return (int) (super.getSpAttack() * this.spAttackMod.getValue());
	}

	@Override
	public int getDefense() {
		return (int) (super.getDefense() * this.defenseMod.getValue());
	}

	@Override
	public int getSpDefense() {
		return (int) (super.getSpDefense() * this.spDefenseMod.getValue());
	}

	@Override
	public int getSpeed() {
		return (int) (super.getSpeed() * this.speedMod.getValue());
	}

	@Override
	public void setHealth(int health) {
		super.health = health;
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

*/