package Model;

import Controller.ObserverHandler;
import Controller.Observer;

import java.util.*;

public class FlashcardDeck {
    private ArrayList<Flashcard> deck;
    private String deckName;
    private int currentIndex;

    private Mediator mediator;
    private ObserverHandler observerHandler = new ObserverHandler();

    public FlashcardDeck(String deckName, Mediator mediator) {
        this.deck = new ArrayList<>();
        this.deckName = deckName;
        this.currentIndex = 0;
        this.mediator = mediator;
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
        previousClicked();
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
            incrementCurrentIndex();
        }catch(Exception e){
            currentIndex = 0;
        }

        observerHandler.updateObservers();
    }

    public void incrementCurrentIndex(){
        if (currentIndex < deck.size()){
            currentIndex = (currentIndex + 1);
        }else{
            currentIndex = 0;
        }

        System.out.println(currentIndex);
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

    public int getNumberOfCorrect(){
        int count = 0;
        for(Flashcard card: deck){
            int answer = card.getAnswer();
            if(answer == Flashcard.correct){
                count++;
                mediator.notified("flashcard");
            }
        }
        return count;
    }

    public void resetAnswers(){
        for(Flashcard card: deck){
            card.setAnswer(Flashcard.reset);
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
        currentIndex = 0;
    }
}