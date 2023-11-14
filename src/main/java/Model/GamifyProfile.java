package Model;

import java.awt.datatransfer.FlavorEvent;
import java.util.*;

public class GamifyProfile {
    private int level;
    private int exp;
    private String name;
    private List<FlashcardDeck> flashcards;
    private int levelThreshold;

    public GamifyProfile(String name) {
        this.name = name;
        this.exp = 0;
        this.level = 0;
        this.levelThreshold = 100;
        this.flashcards = new ArrayList<>();
    }

    public void addExp(int gain){
        exp += gain;
        if (levelThreshold <= exp){
            updateLevel();
        }
    }
    private void updateLevel(){
        this.level += 1;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public String getName() {
        return name;
    }

    public List<FlashcardDeck> getFlashcards() {
        //TODO tänk över alias-problem
        return flashcards;
    }

    public int getLevelThreshold() {
        return levelThreshold;
    }
}
