package Model.Statistics;

import Model.Flashcards.FlashcardDeck;

import java.util.ArrayList;

public class StatsDayModel {

    private float hoursLapsed;

    private int flashcardsDone;

    private ArrayList<FlashcardDeck> decksCompleted = new ArrayList();

    private String day;

    public StatsDayModel(String day){
        this.day = day;
    }

    public void addHours(float newHours){
        hoursLapsed += newHours;
    }

    public void setFlashcardsDone(int newFlashcards){
        flashcardsDone += newFlashcards;
    }

    public ArrayList<FlashcardDeck> getDecksDone(){
        return decksCompleted;
    }

    public int getFlashcardsDone(){
        return flashcardsDone;
    }

    public float getHoursLapsed(){
        return hoursLapsed;
    }
}
