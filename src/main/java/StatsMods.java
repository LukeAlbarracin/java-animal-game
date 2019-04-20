public enum StatsMods {
    MINUS_SIX(.25, 0), MINUS_FIVE(.28, 1), MINUS_FOUR(.33, 2), MINUS_THREE(.40, 3), MINUS_TWO(.50, 4), 
    MINUS_ONE(.66, 5), DEFAULT(1, 6), PLUS_ONE(1.50, 7), PLUS_TWO(2.00, 8), PLUS_THREE(2.50, 9), 
    PLUS_FOUR(3.00, 10), PLUS_FIVE(3.50, 11), PLUS_SIX(4.00, 12);

    private double value;
    private int index;

    private StatsMods (double specMod, int index) {
        this.value = specMod;
        this.index = index;
    }

    public double getValue() {
        return this.value;
    }

    public int getIndex(StatsMods statStage) {
        return this.index;
    }

    public StatsMods getNextStage(int index, int slider) {
        try {
            return values()[index+slider];
        } catch (Exception e) {
            System.out.println("Out of Bounds error caught...");
            return values()[6];
        }
    }

}