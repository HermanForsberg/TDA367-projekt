package Model;

import Controller.Observer;
import Controller.ObserverHandler;
import Model.Flashcards.Flashcard;
import Model.Flashcards.FlashcardDeck;

public class CurrentView {

    private ObserverHandler observerHandler = new ObserverHandler();

    private String currentView;

    private FlashcardDeck deckInFocus;

    private Flashcard cardInFocus;

    private Profile currentProfile = new Profile("temp");

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

    public void setProfile(Profile profile){
        currentProfile = profile;
        System.out.println("UpdaterarProfil");
    }

    public Profile getProfile(){
        return currentProfile;
    }
}
