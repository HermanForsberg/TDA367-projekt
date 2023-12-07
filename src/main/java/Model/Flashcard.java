package Model;

public class Flashcard {
    private String solution;
    private String question;
    private int answer;

    public static final int correct = 1;
    public static final int wrong = 0;
    public static final int reset = -1;

    public Flashcard(String question, String solution){
        this.question = question;
        this.solution = solution;
    }

    public String getSolution() {
        return solution;
    }
    public String getQuestion() {
        return question;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public void setAnswer(int i){
        switch (i) {
            case 0 -> answer = wrong;
            case 1 -> answer = correct;
            default -> answer = reset;
        }
    }

    public int getAnswer() {
        return answer;
    }
}
