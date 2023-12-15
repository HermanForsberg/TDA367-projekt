package Model;

import Model.Flashcards.Flashcard;
import Model.Flashcards.FlashcardDeck;
import Model.Profile;

public class ObjectsInFocus {
    private Flashcard cardInFocus;

    private Profile currentProfile = new Profile("temp");

    private FlashcardDeck deckInFocus = new FlashcardDeck("temp",currentProfile);

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
}
