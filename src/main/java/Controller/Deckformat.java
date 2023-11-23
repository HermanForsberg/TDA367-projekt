package Controller;

import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Deckformat extends JPanel{

    private JPanel panelForFlashcard;


    public Deckformat(FlashcardDeck deck, JButton backwardsButton) throws HeadlessException {
        //Set up the content pane.
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.panelForFlashcard = new JPanel(new GridLayout(1, 0, 10 ,10));



        JButton next = new JButton("Next");
        next.setBackground(Color.CYAN);
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 0, 100);
        c.ipadx = 50;
        c.ipady = 20;
        add(next, c);

        next.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                deck.nextClicked();
                panelForFlashcard.removeAll();
                panelForFlashcard.add(new FlashcardController(deck.getDeck().get(deck.getCurrentIndex())));
                panelForFlashcard.updateUI();
                updateUI();
            }

        });

        JButton prev = new JButton("Previous");
        prev.setBackground(Color.CYAN);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 100, 0, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(prev, c);

        prev.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                deck.previousClicked();
                panelForFlashcard.removeAll();
                panelForFlashcard.add(new FlashcardController(deck.getDeck().get(deck.getCurrentIndex())));
                panelForFlashcard.updateUI();
                updateUI();
            }

        });

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
        c.weightx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(40, 100, 40, 100);
        c.ipadx = 300;
        c.ipady = 200;
        panelForFlashcard.add(flashcard);
        add(panelForFlashcard,c);

        JButton addNewCard = new JButton("Add Card");
        addNewCard.setBackground(Color.BLUE);
        addNewCard.setForeground(Color.WHITE);
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(addNewCard,c);

        addNewCard.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String question = JOptionPane.showInputDialog("Question: ");
                String answer = JOptionPane.showInputDialog("Answer: ");
                if(!question.isEmpty() && !answer.isEmpty()){
                    Flashcard flash = new Flashcard(question, answer);
                    deck.addFlashcard(flash);
                }
                else {
                    JOptionPane.showMessageDialog(Deckformat.this, "Need input in both fields");
                }
            }

        });


        backwardsButton.setBackground(Color.BLACK);
        backwardsButton.setForeground(Color.WHITE);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(backwardsButton,c);

    }

}
