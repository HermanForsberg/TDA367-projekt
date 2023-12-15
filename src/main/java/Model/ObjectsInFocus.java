package Model;

import Controller.Observer;
import Controller.ObserverHandler;
import Model.Flashcards.Flashcard;
import Model.Flashcards.FlashcardDeck;

public class ObjectsInFocus {
    private Flashcard cardInFocus;

    private Profile currentProfile = new Profile("temp");

    private FlashcardDeck deckInFocus = new FlashcardDeck("temp",currentProfile);

    private ObserverHandler observerHandler = new ObserverHandler();

    public ObjectsInFocus(){

    }

    public void setCurrentProfile(Profile profile){
        currentProfile = profile;
    }

    public void setDeckInFocus(FlashcardDeck deck){
        deckInFocus = deck;
    }

    public Profile getCurrentProfile(){
        return  currentProfile;
    }

    public FlashcardDeck getDeckInFocus(){
        return deckInFocus;
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }
}
