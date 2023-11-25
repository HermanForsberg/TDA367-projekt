package Model;

import java.util.*;

public class FlashcardDeck {
    private ArrayList<Flashcard> deck;
    private String deckName;
    private int size;


    private int currentIndex;

    public FlashcardDeck(String deckName) {
        this.deck = new ArrayList<>();
        this.deckName = deckName;
        this.size = deck.size();
        this.currentIndex = 0;

    }

    public boolean addFlashcard(Flashcard flash){
        return deck.add(flash);
    }


    public void deleteIndex(int index){
        deck.remove(index);
    }

    public void delete(Flashcard flash){
        this.deck.remove(flash);
    }

    public void previousClicked(){
        currentIndex = Math.max(currentIndex-1,0);
        System.out.println(currentIndex);
    }

    public void nextClicked(){
        try {
            currentIndex = (currentIndex + 1) % (deck.size());
        }catch(Exception e){
            currentIndex = 0;
        }
        System.out.println(currentIndex);
    }

    public int getCurrentIndex(){
        return currentIndex;
    }
    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public ArrayList<Flashcard> getDeck() {
        return deck;
    }

    public String getDeckName() {
        return deckName;
    }

    public int getSize() {
        return deck.size();
    }
}