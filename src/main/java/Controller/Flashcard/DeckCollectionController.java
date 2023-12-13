package Controller.Flashcard;

import Controller.AddButtonListener;
import Controller.DeleteButtonListener;
import Model.FlashcardDeck;
import Model.Profile;

import javax.swing.*;

public class DeckCollectionController extends JPanel implements AddButtonListener, DeleteButtonListener {
    private final Profile profile;

    public DeckCollectionController(Profile profile) {
        this.profile = profile;
    }

    @Override
    public void onAddButtonClicked(String name) {
        profile.addNewDeck(name);
    }

    @Override
    public void onDeleteButtonClicked(FlashcardDeck deck) {
        profile.deleteDeck(deck);
    }




}

