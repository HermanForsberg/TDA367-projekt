package Controller.Flashcard;

import Controller.DeckButtonListener;
import Controller.DeleteButtonListener;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckButton extends JPanel {
    private final JButton clicked;
    private final JButton delete;

    private DeckController deckController;

    private FlashcardDeck deck;
    public DeckButton(FlashcardDeck newDeck){
        deck = newDeck;

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

    public void addButtonListenerToClickedButton(DeckButtonListener buttonListener){

        getClicked().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    buttonListener.onDeckButtonClicked("flashcardFeature");

            }

        });

    }

    public void addButtonListenerToDeleteButton(DeleteButtonListener buttonListener){

        getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int ans = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete the card?","Delete", JOptionPane.YES_NO_OPTION);
                if(ans == 0){

                buttonListener.onDeleteButtonClicked(deck);
            }
        }

    });

}
}

