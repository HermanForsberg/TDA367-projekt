package Controller.Flashcard;

import Controller.AddButtonListener;
import Controller.DeckButtonListener;
import Controller.DeleteButtonListener;
import Model.FlashcardDeck;
import Model.Profile;

import javax.swing.*;

public class DeckCollectionController extends JPanel implements AddButtonListener, DeleteButtonListener {

    private DeckController deckController;

    private Profile profile;

    public DeckCollectionController(Profile model) {

        profile = model;

    }



    public void setDeckInFocus(FlashcardDeck deck){
        profile.setDeckInFocus(deck);
    }

    public void deleteDeck(FlashcardDeck deck){
        profile.deleteDeck(deck);
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

