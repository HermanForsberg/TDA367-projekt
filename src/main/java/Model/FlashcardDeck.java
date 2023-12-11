package Model;

import Controller.ObserverHandler;
import Controller.Observer;

import java.util.*;

public class FlashcardDeck {
    private ArrayList<Flashcard> deck;
    private String deckName;
    private int currentIndex;

    private Flashcard flashcardInFocus;

    private boolean inFocus;

    private ObserverHandler observerHandler = new ObserverHandler();

    public FlashcardDeck(String deckName) {
        this.deck = new ArrayList<>();
        this.deckName = deckName;
        this.currentIndex = 0;
        flashcardInFocus = new Flashcard("PlaceHolder", "PlaceHolderAnswer");

    }



    public void setFlashcardInFocus(Flashcard card){
        flashcardInFocus = card;
    }

    public void addFlashcard(Flashcard flash){

        deck.add(flash);
        observerHandler.updateObservers();


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
        observerHandler.updateObservers();
    }

    public void deckSet(){
        observerHandler.updateObservers();
    }

    public void nextClicked(){
        try {
            currentIndex = (currentIndex + 1) % (deck.size());
        }catch(Exception e){
            currentIndex = 0;
        }
        System.out.println(currentIndex);
        observerHandler.updateObservers();
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
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

    public Flashcard getCurrentFlashcard(){
        return deck.get(getCurrentIndex());
    };
}