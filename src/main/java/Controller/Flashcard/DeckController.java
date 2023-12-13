package Controller.Flashcard;

import Model.Flashcards.Flashcard;
import Model.Flashcards.FlashcardDeck;
import java.awt.*;


public class DeckController implements AddButtonInMenusListener, NextButtonListener, ShuffleButtonListener, PreviousButtonListener {

    private final FlashcardDeck currentDeck;

    public DeckController(FlashcardDeck deck) throws HeadlessException {
        currentDeck=deck;
    }

    public void nextClicked(){
        currentDeck.nextClicked();
    }

    public void previousClicked(){
        currentDeck.previousClicked();
    }

    @Override
    public void addButtonInMenuClicked(String question, String solution) {
        currentDeck.addFlashcard(new Flashcard(question, solution));
    }

    @Override
    public void onNextButtonClicked() {
        currentDeck.nextClicked();
    }

    @Override
    public void onShuffleButtonCLicked() {
        currentDeck.shuffleDeck();
    }

    @Override
    public void onPreviousClicked() {
        currentDeck.previousClicked();
    }
}
