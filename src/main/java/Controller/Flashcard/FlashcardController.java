package Controller.Flashcard;
import Model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

public class FlashcardController extends JButton {



    public FlashcardController(Flashcard card){

        setText(card.getQuestion());

        addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            //if (control != null) {

            if (getText().equals(card.getQuestion()))
            {
                setText(card.getSolution());}
            else{setText(card.getQuestion());
            }
        }

    });
}
    public JButton get(){
        return this;

    }
}
