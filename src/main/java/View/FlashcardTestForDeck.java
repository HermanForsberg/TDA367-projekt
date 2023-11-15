package View;
import Model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashcardTestForDeck extends JButton{



    private JButton questButton;

    private Flashcard flashcard;

    public FlashcardTestForDeck(Flashcard flashcard) {

        this.questButton = new JButton(flashcard.getQuestion());
        this.flashcard = flashcard;
        questButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //if (control != null) {

                if (questButton.getText().equals(flashcard.getQuestion()))
                {
                    questButton.setText(flashcard.getSolution());}
                else{questButton.setText(flashcard.getQuestion());
                }
            }

        });
    }
    public JButton get(){
        return this.questButton;

    }

}

