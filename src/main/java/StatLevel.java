public enum StatLevel {
    SEVERELY_FELL("severely fell!", -3), HARSHLY_FELL ("harshy fell!", -2), FELL ("fell!", -1), NOTHING ("did not change...", 0), 
    ROSE("rose!", 1), SHARPY_ROSE("sharply rose!", 2), ROSE_DRASTICALLY("drastically rose!", 3);

    public String statText = "";
    public int levelChange = 0;

    private StatLevel(String statText, int levelChange) {
        this.statText = statText;
        this.levelChange = levelChange;
    }
}