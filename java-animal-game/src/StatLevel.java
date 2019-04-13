public enum StatLevel {
    SEVERELY_FELL("severely fell!"), HARSHLY_FELL ("harshy fell!"), FELL ("fell!"), NOTHING ("did not change..."), 
    ROSE("rose!"), SHARPY_ROSE("sharply rose!"), ROSE_DRASTICALLY("drastically rose!");

    String statText;

    private StatLevel(String statText) {
        this.statText = statText;
    }
}