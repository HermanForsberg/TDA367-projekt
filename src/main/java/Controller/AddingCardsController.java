package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.*;
public class AddingCardsController extends JPanel {
    public AddingCardsController(FlashcardDeck deck, Deckformat grid) {
        setLayout(new GridLayout(4,4,10,10));

        JButton addButton = new JButton("Add Card");
        add(addButton);
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String question = JOptionPane.showInputDialog("Question: ");
                String solution = JOptionPane.showInputDialog("Solution: ");
                if(!question.isEmpty() && !solution.isEmpty()){
                    Flashcard flash = new Flashcard(question, solution);
                    deck.addFlashcard(flash);
                    add(new MiniFlashcard(flash, deck, AddingCardsController.this));
                    updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(AddingCardsController.this, "Need input in both fields");
                }

            }

        });

        for(Flashcard card : deck.getDeck()){
            add(new MiniFlashcard(card, deck, AddingCardsController.this));
        }
        updateUI();

        JButton test = new JButton("test");
        add(test);
        test.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                removeAll();
                Component[] test = grid.getComponents();
                for (Component test2: test) {
                    test2.setVisible(true);
                }
                updateUI();
            }

        });

        /*
        JScrollPane ScrollPane = new JScrollPane();
        add(ScrollPane);*/
    }

    /*
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(600, 600));
        FlashcardDeck deck = new FlashcardDeck("deck");
        frame.add(new AddingCardsController(deck,));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }*/
}
