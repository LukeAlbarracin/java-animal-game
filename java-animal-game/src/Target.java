public enum Target {
    NO_TARGET(false), CHOOSE_ONE(true), SELF_INFLICT(0), ALL_AROUND(1,2,3,4,5), EVERY(0,1,2,3,4,5), ONLY_ENEMIES(1,3,5), REGULAR(1), 
    FIRST_ALLY(2), SECOND_ALLY(4), CENTER_ENEMY(3), RIGHT_ENEMY(5);
    
    int[] allTargets;
    boolean choice = false;

    private Target (int ...individualTarget) {
        this.allTargets = individualTarget;
    }

    private Target (boolean choice) {
        this.choice = choice;
    }
}