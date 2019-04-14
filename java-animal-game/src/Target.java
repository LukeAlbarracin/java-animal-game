public enum Target {
    NO_TARGET(), CHOOSE_ONE(true), SELF_INFLICT(0), ALL_AROUND(1,2,3,4,5), EVERY(0,1,2,3,4,5), ONLY_ENEMIES(3,4,5), REGULAR(3), 
    FIRST_ALLY(1), SECOND_ALLY(2), CENTER_ENEMY(4), RIGHT_ENEMY(5);
    
    private int[] allTargets = {};
    private boolean canSelectTarget = false;

    private Target (int ...allTargets) {
        this.allTargets = allTargets;
    }

    private Target (boolean canSelectTarget) {
        this.canSelectTarget = canSelectTarget;
    }

    public int[] getAllTargets() {
        return this.allTargets;
    }

    public boolean getCanSelectTarget() {
        return this.canSelectTarget;
    }
}