public enum StatusCondition {
    POISONED, BURNED, ASLEEP, CONFUSED, PARALYZED, FROZEN ;

    public void simPoison (Pokemon user) {
        user.setHealth(user.getHealth()-10);
    }

    public void simPoison (Pokemon user, int customDamage) {
        user.setHealth(user.getHealth()-customDamage);
    }

    public void simBurn (Pokemon user) {
        user.setHealth(user.getHealth()-10);
    }

    public void simBurn (Pokemon user, int customDamage) {
        user.setHealth(user.getHealth()-customDamage);
    }

    public void simSleep (Pokemon user, int turnsAsleep) {

    }

    public void simConfusion (Pokemon user, int turnsConfused) {

    }

    public void simParalysis (Pokemon user) {

    }

    public void simFreeze (Pokemon user, int turnsConfused) {

    }


}