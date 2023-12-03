package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

public class FlashcardDeck {
    private ArrayList<Flashcard> deck;
    private String deckName;
    private int size;

    private int oldCurrentIndex;

    //Man får skapa observer i flashcardDeck

    //Lägg till timer i flashcard skärmen




    public static final String STATE_PROP_NAME = "State";
    private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);
    private State state = State.NO_STATE;


    private int currentIndex;

    public FlashcardDeck(String deckName) {
        this.deck = new ArrayList<>();
        this.deckName = deckName;
        this.size = deck.size();
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

        try {
            currentIndex = (currentIndex + 1) % (deck.size());
        }catch(Exception e){
            currentIndex = 0;
        }
        System.out.println(currentIndex);
        pcSupport.firePropertyChange(STATE_PROP_NAME, oldCurrentIndex,currentIndex);
    }

    public void setState(State state) {
        State oldState = this.state;
        this.state = state;
        // notify all listeners that the state property has changed



    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);

        System.out.println(listener);
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