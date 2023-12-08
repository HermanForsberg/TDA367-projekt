package Model;

import Controller.ObserverHandler;
import Controller.Observer;

public class Flashcard {
    private String solution;
    private String question;
    private boolean flipped;
    private boolean correct;

    private ObserverHandler observerHandler;

    public Flashcard(String question, String solution){
        this.question = question;
        this.solution = solution;
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
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

    public void flip(){
        this.flipped = !this.flipped;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }


}
