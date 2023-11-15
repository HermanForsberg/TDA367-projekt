package Controller;

import Model.FlashcardDeck;

public class DeckController {

    private FlashcardDeck model;

    public DeckController(FlashcardDeck model) {
        this.model = model;

    }

    public void previousClicked(){
        model.previousClicked();
    }
    public void nextClicked(){
        model.nextClicked();
    }
}
