public enum StatusChange {
    ATTACK, SPECIAL_ATTACK, DEFENSE, SPECIAL_DEFENSE, SPEED, HEALTH, ACCURACY, EVASIVENESS,
    INFLICT_POISON (StatusCondition.POISONED), INFLICT_BURN (StatusCondition.BURNED), 
    INFLICT_SLEEP (StatusCondition.ASLEEP), INFLICT_CONFUSION (StatusCondition.CONFUSED), 
    INFLICT_PARALYSIS (StatusCondition.PARALYZED), FREEZE (StatusCondition.FROZEN);

    public StatusCondition statusCondition = StatusCondition.DEFAULT_STATE;
    //public StatLevel statLevel = StatLevel.NOTHING;

    private StatusChange (StatusCondition statusCondition) {
        this.statusCondition = statusCondition;
    }

    private StatusChange () {}
}