package Controller.Flashcard;
import Model.Flashcards.Flashcard;

import javax.swing.*;

public class FlashcardController extends JButton implements WrongButtonListener, CorrectButtonListener{

    private Flashcard flashcard;

    public FlashcardController(Flashcard card) {

        flashcard = card;

    }

    @Override
    public void onWrongClicked(int i) {
        flashcard.setAnswer(i);
    }

    @Override
    public void onCorrectClicked(int i) {
        flashcard.setAnswer(i);
    }


}
