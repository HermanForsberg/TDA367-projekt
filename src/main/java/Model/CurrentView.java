package Model;

import Controller.Observer;
import Controller.ObserverHandler;
import Windows.Window;

import java.util.HashSet;
import java.util.Set;

public class CurrentView {

    private ObserverHandler observerHandler = new ObserverHandler();

    private String currentView;

    private FlashcardDeck deckInFocus;

    private Flashcard cardInFocus;

    public CurrentView(){

    }

    public String getCurrentView(){
        return currentView;
    }
    public void setCurrentView(String view){
        currentView = view;
        observerHandler.updateObservers();
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }

    public void setDeckInFocus(FlashcardDeck deck){
        deckInFocus = deck;
        setCurrentView("flashcardFeature");
        observerHandler.updateObservers();
    }

    public FlashcardDeck getDeckInFocus(){
        return deckInFocus;

    }
}