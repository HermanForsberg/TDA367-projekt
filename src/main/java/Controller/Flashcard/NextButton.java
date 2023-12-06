package Controller.Flashcard;

import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton extends JButton {

    private FlashcardDeck currentDeck;

    public NextButton(){
        setText("Next");
    }

    public void setDeck(FlashcardDeck deck){
        currentDeck=deck;
        addActionListener(this::nextActionPerformed);
    }

    public void nextActionPerformed(ActionEvent e) {
        currentDeck.nextClicked();

    }

}
