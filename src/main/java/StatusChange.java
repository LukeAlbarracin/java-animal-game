public enum StatusChange {
    ATTACK("attack"), SPECIAL_ATTACK("special attack"), DEFENSE("defense"), 
    SPECIAL_DEFENSE("special defense"), SPEED("speed"), HEALTH("health"), 
    ACCURACY("accuracy"), EVASIVENESS("evasiveness"),INFLICT_POISON (StatusCondition.POISONED), 
    INFLICT_BURN (StatusCondition.BURNED), INFLICT_SLEEP (StatusCondition.ASLEEP), 
    INFLICT_CONFUSION (StatusCondition.CONFUSED), INFLICT_PARALYSIS (StatusCondition.PARALYZED), 
    FREEZE (StatusCondition.FROZEN);

    public String battleText = "";
    public StatusCondition statusCondition = StatusCondition.DEFAULT_STATE;
    //public StatLevel statLevel = StatLevel.NOTHING;

    private StatusChange (StatusCondition statusCondition) {
        this.statusCondition = statusCondition;
    }

    private StatusChange (String battleText) {
        this.battleText = battleText;
    }
}