package Model;

public class flashcard {
    private String solution;
    private String question;
    private boolean flipped;
    private boolean correct;

    public flashcard(String question, String solution){
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
