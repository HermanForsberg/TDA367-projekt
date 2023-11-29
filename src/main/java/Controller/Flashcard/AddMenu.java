package Controller.Flashcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
public class AddMenu extends JPanel {
    public AddMenu(FlashcardDeck deck, DeckController deckController) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(5, 5, 10,10));
        c.gridy = 2;
        c.gridwidth = 5;
        c.gridheight = 5;
        add(grid, c);
        JButton addButton = new JButton("Add Card");
        c.gridy = 0;
        c.gridx = 0;
        c.gridheight = 2;
        c.gridwidth = 3;
        add(addButton,c);
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String question = JOptionPane.showInputDialog("Question: ");
                String solution = JOptionPane.showInputDialog("Solution: ");
                if(!question.isEmpty() && !solution.isEmpty()){
                    Flashcard flash = new Flashcard(question, solution);
                    deck.addFlashcard(flash);
                    grid.add(new AddMenuCard(flash, deck, grid));
                    grid.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(AddMenu.this, "Need input in both fields");
                }

            }

        });

        JButton backButton = new JButton("Finished");
        c.gridx = 3;
        c.gridheight = 2;
        c.gridwidth = 2;
        add(backButton,c);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                removeAll();
                Component[] test = deckController.getComponents();
                for (Component test2: test) {
                    test2.setVisible(true);
                }
                updateUI();
            }

        });

        for(Flashcard card : deck.getDeck()){
            grid.add(new AddMenuCard(card, deck, grid));
        }
        updateUI();





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
