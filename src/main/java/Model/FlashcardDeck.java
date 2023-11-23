package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

public class FlashcardDeck {
    private ArrayList<Flashcard> deck;
    private String deckName;
    private int size;


    private int currentIndex;

    public FlashcardDeck(String deckName) {
        this.deck = new ArrayList<>();
        this.deckName = deckName;
        this.size = 2;
        this.currentIndex = 0;

    }

    public boolean addFlashcard(Flashcard flash){
        //boolean added = deck.add(flash);
        /*
        if(added){
            this.size ++;
        }*/
        return deck.add(flash);
    }


    public void delete(int index){
        //boolean deleted = this.deck.remove(flash);
        /*
        if(deleted){
            this.size --;
        }*/

        deck.remove(index);
    }

    public void previousClicked(){
        currentIndex = Math.max(currentIndex-1,0);
        System.out.println(currentIndex);
    }

    public void nextClicked(){
        currentIndex = (currentIndex+1)%(deck.size());
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