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

    public String getDay() {
        return day;
    }

    public void addMinutes(int newMinutes){
        minutesLapsed += newMinutes;
        System.out.println("minute " + minutesLapsed);
    }

    public void addFlashcardsCompleted(int newFlashcards){
        flashcardsCompleted += newFlashcards;
        System.out.println(flashcardsCompleted);
    }

    public void addLevelsGained(int newLevels){
        levelsGained += newLevels;
        System.out.println(levelsGained);
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
