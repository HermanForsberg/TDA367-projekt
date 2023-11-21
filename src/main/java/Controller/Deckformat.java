package Controller;

import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Deckformat extends JPanel{

    private FlashcardController flashcard;
    public Deckformat(FlashcardDeck deck) throws HeadlessException {
        //Set up the content pane.

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton next = new JButton("Next");

        next.setBackground(Color.CYAN);
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 0, 100);
        c.ipadx = 50;
        c.ipady = 20;
        add(next, c);

        JButton prev = new JButton("Previous");

        prev.setBackground(Color.CYAN);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 100, 0, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(prev, c);

        JButton correct = new JButton("Correct");
        correct.setBackground(Color.GREEN);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 0, 20, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(correct,c);

        JButton wrong = new JButton("Wrong");
        wrong.setBackground(Color.RED);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 20, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(wrong,c);

        FlashcardController flashcard = new FlashcardController(deck.getDeck().get(0));

        c.gridy = 2;
        c.gridx = 1;
        c.weightx = 0.5;
        c.insets = new Insets(100, 100, 40, 100);
        c.ipadx = 300;
        c.ipady = 200;

        add(flashcard,c);

    }


}
