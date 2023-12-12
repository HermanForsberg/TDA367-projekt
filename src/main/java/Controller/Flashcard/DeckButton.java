package Controller.Flashcard;

import Controller.DeckButtonListener;
import Controller.DeleteButtonListener;
import Controller.PlayButtonListener;
import Controller.ShuffleButtonListener;
import Model.FlashcardDeck;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckButton extends JPanel {
    private JButton clicked;
    private JButton delete;
    private JButton shuffleButton;

    private DeckController deckController;

    private final GridBagConstraints c = new GridBagConstraints();
    private FlashcardDeck deck;
    public DeckButton(FlashcardDeck newDeck){
        deck = newDeck;

        setLayout(new GridBagLayout());


        createDeckOpener();
        createDeleteButton();
        createShuffleButton();


    }

    public void createShuffleButton(){
        shuffleButton = new JButton("Shuffle deck and play");
        shuffleButton.setBackground(Color.CYAN);
        shuffleButton.setBorder(new LineBorder(Color.BLACK));
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        add(shuffleButton, c);
    }

    public void createDeckOpener(){
        clicked = new JButton(deck.getDeckName());
        clicked.setBackground(Color.WHITE);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.weighty = 0.5;
        c.weightx = 0.5;
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        add(clicked, c);
    }

    public void createDeleteButton(){
        delete = new JButton("Delete deck");
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        c.gridx = 0;
        c.gridy = 3;
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

    public void addShuffleButtonListenerToClickedButton(ShuffleButtonListener buttonListener){
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonListener.onShuffleButtonCLicked();

            }

        });
    }


    public void addPlayButtonListenerToClickedButton(PlayButtonListener buttonListener){
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonListener.onPlayButtonCLicked(deck);

            }

        });
    }

    public void addButtonListenerToClickedButton(DeckButtonListener buttonListener){
        

        getClicked().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    buttonListener.onDeckButtonClicked(deck);


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

