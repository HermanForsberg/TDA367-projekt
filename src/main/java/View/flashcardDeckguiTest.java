package View;
import Controller.*;
import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class flashcardDeckguiTest extends JPanel {
    private JPanel deck;
    private JPanel flashcard;
    private JButton previous;
    private JButton next;
    private JButton falseButton;
    private JButton correctButton;

    private FlashcardDeck deckModel;

    private ArrayList<Flashcard> deckList;

    private DeckController deckController;




    public flashcardDeckguiTest(FlashcardDeck deck) {



        deckModel = deck;
        deckList = deckModel.getDeck();

        setSize(800, 600);


        setVisible(true);

        FlashcardTestForDeck startButton = new FlashcardTestForDeck(deckList.get(0));
        FlashcardTestForDeck Button2 = new FlashcardTestForDeck(deckList.get(1));


        flashcard.setLayout(new GridLayout(1, 0, 10, 0));
        flashcard.add(startButton.get());



        //deck.add(button);

        //flashcard.add(new JButton("swag"));
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (deckController != null){
                    deckController.previousClicked();
                    flashcard.removeAll();
                    flashcard.add(new FlashcardTestForDeck(deckList.get(deckModel.getCurrentIndex())).get());
                    flashcard.updateUI();
                }
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                //JOptionPane.showMessageDialog(flashcardDeckgui.this, "föregående kort");


            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                //JOptionPane.showMessageDialog(flashcardDeckgui.this, "nästa kort");
                if (deckController != null) {
                    deckController.nextClicked();
                    flashcard.removeAll();
                    flashcard.add(new FlashcardTestForDeck(deckList.get(deckModel.getCurrentIndex())).get());
                    flashcard.updateUI();
                }
            }
        });
        correctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(flashcardDeckguiTest.this, "Korrekt!!");
            }
        });
        falseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(flashcardDeckguiTest.this, "Fel...");
            }
        });
    }
    public JPanel get(){
        return deck;
    }

    public void setDeckController(DeckController deckController){
        this.deckController = deckController;

    }

   /* public static void main(String[] args) {
        new flashcardDeckguiTest();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }*/
}
