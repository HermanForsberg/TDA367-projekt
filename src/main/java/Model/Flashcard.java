package Model;

public class Flashcard {
    private String solution;
    private String question;
    private boolean flipped;
    private boolean correct;

    public String getSolution() {
        return solution;
    }

    public String getQuestion() {
        return question;
    }

    public Flashcard(String question, String solution){
        this.question = question;
        this.solution = solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void flip(){
        this.flipped = !this.flipped;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }


}
