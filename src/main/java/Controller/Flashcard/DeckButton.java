package Controller.Flashcard;

import Model.FlashcardDeck;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class DeckButton extends JPanel {
    private JButton playButton;
    private JButton delete;
    private JButton shuffleButton;
    private final GridBagConstraints constraints = new GridBagConstraints();
    private final FlashcardDeck deck;
    public DeckButton(FlashcardDeck newDeck){
        deck = newDeck;
        setLayout(new GridBagLayout());

        createPlayButton();
        createDeleteButton();
        createShuffleButton();


    }

    public void createShuffleButton(){
        shuffleButton = new JButton("Shuffle deck and play");
        shuffleButton.setBackground(Color.CYAN);
        shuffleButton.setBorder(new LineBorder(Color.BLACK));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.weighty = 0.0;
        constraints.weightx = 0.0;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(shuffleButton, constraints);
    }

    public void createPlayButton(){
        playButton = new JButton(deck.getDeckName());
        playButton.setBackground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.weighty = 0.5;
        constraints.weightx = 0.5;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.BOTH;
        add(playButton, constraints);
    }

    public void createDeleteButton(){
        delete = new JButton("Delete deck");
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weighty = 0;
        constraints.weightx = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipady = 20;
        add(delete, constraints);
    }
    public JButton getDeleteButton() {
        return delete;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public void addShuffleButtonListenerToClickedButton(ShuffleButtonListener buttonListener){
        shuffleButton.addActionListener(e -> buttonListener.onShuffleButtonCLicked());
    }


    public void addPlayButtonListenerToClickedButton(PlayButtonListener buttonListener){
        shuffleButton.addActionListener(e -> buttonListener.onPlayButtonCLicked(deck));
    }

    public void addButtonListenerToClickedButton(DeckButtonListener buttonListener){
        

        getPlayButton().addActionListener(e -> buttonListener.onDeckButtonClicked(deck));

    }

    public void addButtonListenerToDeleteButton(DeleteButtonListener buttonListener){

        getDeleteButton().addActionListener(e -> {

            int ans = JOptionPane.showConfirmDialog(null,
                    "Do you want to delete the card?","Delete", JOptionPane.YES_NO_OPTION);
            if(ans == 0){

            buttonListener.onDeleteButtonClicked(deck);
        }
    });

}
}

