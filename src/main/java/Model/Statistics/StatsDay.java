package Model.Statistics;

import Model.Flashcards.FlashcardDeck;

import java.util.ArrayList;

public class StatsDay {

    private int minutesLapsed;
    private int flashcardsCompleted;
    private int levelsGained;

    private final String day;

    public StatsDay(String day){
        this.day = day;
        this.minutesLapsed = 0;
        this.flashcardsCompleted = 0;
        this.levelsGained = 0;
    }

    public void addMinutes(int newMinutes){
        minutesLapsed += newMinutes;
    }

    public void addFlashcardsCompleted(int newFlashcards){
        flashcardsCompleted += newFlashcards;
    }

    public void addLevelsGained(int newLevels){
        levelsGained += newLevels;
    }

    public int getMinutesLapsed(){
        return minutesLapsed;
    }
    public int getFlashcardsCompleted(){
        return flashcardsCompleted;
    }
    public int getLevelsGained() {
        return levelsGained;
    }
}
