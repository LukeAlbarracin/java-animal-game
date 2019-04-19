public enum StatStage {
    MINUS_SIX(.25), MINUS_FIVE(.28), MINUS_FOUR(.33), MINUS_THREE(.40), MINUS_TWO(.50), MINUS_ONE(.66), UNCHANGED(0),
    PLUS_ONE(1.50), PLUS_TWO(2.00), PLUS_THREE(2.50), PLUS_FOUR(3.00), PLUS_FIVE(3.50), PLUS_SIX(4.00);

    private double value;

    private StatStage (double specMod) {
        this.value = specMod;
    }

    public double getValue() {
        return this.value;
    }

    public int getIndex(StatStage statStage) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].value == statStage.value) {
                return i;
            }
        }
        return 0;
    }

    public StatStage getNextStage(int index, int slider) {
        try {
            return values()[index+slider-6];
        } catch (Exception e) {
            System.out.println("Error in Stat Stage class... Probably out of bounds...");
            return values()[6];
        }
    }

}