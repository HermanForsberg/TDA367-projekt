package Controller.Flashcard;

import Controller.*;
import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class DeckController implements AddButtonInMenusListener, NextButtonListener, ShuffleButtonListener {

    private FlashcardDeck currentDeck;

    public DeckController(FlashcardDeck deck) throws HeadlessException {
        currentDeck=deck;
    }

    public void nextClicked(){
        currentDeck.nextClicked();
    }

    public void previousClicked(){
        currentDeck.previousClicked();
    }



    public void addFlashcard(Flashcard flash){
        currentDeck.addFlashcard(flash);
    }


    @Override
    public void addButtonInMenuClicked(String question, String solution) {
        currentDeck.addFlashcard(new Flashcard(question, solution));
    }

    @Override
    public void onNextButtonCLicked() {
        currentDeck.nextClicked();
    }

    @Override
    public void onShuffleButtonCLicked() {
        System.out.println("updat2");
        currentDeck.shuffleDeck();
    }
}
