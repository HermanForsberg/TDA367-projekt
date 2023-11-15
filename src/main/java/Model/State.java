package Model;

public enum State {
    NO_STATE("No State"), FLASHCARDS("Flashcard"), TIMER("Timer");
    private String text;

    private State(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getText() {
        return text;
    }
}
