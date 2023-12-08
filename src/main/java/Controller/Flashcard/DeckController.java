package Controller.Flashcard;

import Controller.Observer;
import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class DeckController{

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




}
