package Controller.Flashcard;

import Model.Flashcard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton extends JButton {
    /*public NextButton(String text) {
        super(text);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deck.nextClicked();

                panelForFlashcard.removeAll();
                try {
                    panelForFlashcard.add(new FlashcardController(deck.getDeck().get(deck.getCurrentIndex())));
                }catch(Exception e2){
                    panelForFlashcard.add(new FlashcardController(new Flashcard("PlaceHolder", "PlaceHolderAnswer")));
                }
                panelForFlashcard.updateUI();
                currentCard.setText("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());
                updateUI();
            }
        });
    }*/
}
