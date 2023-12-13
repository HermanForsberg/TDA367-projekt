package Windows;

import Model.Flashcards.Flashcard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Observer;

public class FlashcardWindow extends JButton implements Observer, Window{

    private Flashcard card;

    public FlashcardWindow(Flashcard newCard){
        card=newCard;
        //card.addObserver(this);

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
    public void update(){
        setText(card.getQuestion());
    }
    public void setCard(Flashcard newCard){
        card=newCard;
        setText(card.getQuestion());
        updateUI();
    }
    public JButton get(){
        return this;

    }
}
