package Controller.Flashcard;

import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;

public class DeckButton extends JPanel {
    private final JButton clicked;
    private final JButton delete;
    public DeckButton(FlashcardDeck deck){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        clicked = new JButton(deck.getDeckName());
        clicked.setBackground(Color.cyan);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.weighty = 0.5;
        c.weightx = 0.5;
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        add(clicked, c);

        delete = new JButton("Delete deck");
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0;
        c.weightx = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 20;
        add(delete, c);



    }

    public JButton getDeleteButton() {
        return delete;
    }

    public JButton getClicked() {
        return clicked;
    }
    /*
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(600, 600));
        FlashcardDeck deck = new FlashcardDeck("deck");
        frame.add(new DeckButtonController(deck));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }*/
}
