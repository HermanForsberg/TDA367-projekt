package Controller.Flashcard;

import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMenuCard extends JComponent {
    public AddMenuCard(Flashcard flashcard, FlashcardDeck deck, JPanel grid) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setBorder(BorderFactory.createLineBorder(Color.black));

        c.gridy = 0;
        JLabel question = new JLabel("Question: " + flashcard.getQuestion());
        add(question,c);

        c.gridy = 1;
        JLabel solution = new JLabel("Solution: " + flashcard.getSolution());
        add(solution,c);

        JButton deleteButton = new JButton("delete");
        deleteButton.setBackground(Color.RED);
        c.gridx = 2;
        c.fill = GridBagConstraints.BOTH;
        add(deleteButton,c);
        deleteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println(deck.getDeck().toString());
                deck.delete(flashcard);
                System.out.println(deck.getDeck().toString());
                grid.remove(AddMenuCard.this);
                grid.updateUI();

            }

        });
    }

}
