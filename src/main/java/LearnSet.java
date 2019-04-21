public class LearnSet extends Pair<Moves, Integer> {
    public LearnSet (final Moves move, final Integer level) {
        super(move, level);
    }

    public Moves getMove() {
        return $1;
    }

    public Integer getLevel() {
        return $2;
    }
}