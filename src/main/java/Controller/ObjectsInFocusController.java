package Controller;

import Controller.Flashcard.DeckButtonListener;
import Controller.Flashcard.PlayButtonListener;
import Controller.Profile.ProfileButtonListener;
import Model.Flashcards.FlashcardDeck;
import Model.ObjectsInFocus;
import Model.Profile;

public class ObjectsInFocusController implements DeckButtonListener, PlayButtonListener, ProfileButtonListener {

    private ObjectsInFocus model;
    public ObjectsInFocusController(ObjectsInFocus objectsInFocus){
        model = objectsInFocus;
    }


    @Override
    public void onDeckButtonClicked(FlashcardDeck deck) {
        model.setDeckInFocus(deck);
    }

    @Override
    public void onPlayButtonCLicked(FlashcardDeck deck) {
        model.setDeckInFocus(deck);
    }

    @Override
    public void onProfileButtonClicked(Profile profile) {
        model.setCurrentProfile(profile);
    }
}
