package Controller;

import Model.FlashcardDeck;
import Model.Flashcard;

import javax.swing.*;
import java.util.ArrayList;

public class DeckController extends JPanel {

    private FlashcardDeck model;

    private ArrayList<FlashcardController> listOfCards = new ArrayList<>();

    public DeckController(FlashcardDeck model) {


        /*
        for (Flashcard card : model.getDeck()) {
            FlashcardController newCard = new FlashcardController(card);
            listOfCards.add(newCard);
        }*/
    }

    public void previousClicked(){
        model.previousClicked();
    }
    public void nextClicked(){
        model.nextClicked();
    }
}
