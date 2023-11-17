package Controller;
import Model.Flashcard;
import Model.FlashcardDeck;
import View.FlashcardTestForDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class flashcardDeckguiTest extends JPanel {
    private JPanel deck;
    private JPanel flashcard;
    private JButton previous;
    private JButton next;
    private JButton falseButton;
    private JButton correctButton;






    public flashcardDeckguiTest(FlashcardDeck deck) {




        //FlashcardTestForDeck startButton = new FlashcardTestForDeck(deck.getDeck().get(0));
        //FlashcardTestForDeck Button2 = new FlashcardTestForDeck(deck.getDeck().get(1));


        flashcard.setLayout(new GridLayout(1, 0, 10, 0));




        //deck.add(button);

        //flashcard.add(new JButton("swag"));
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (deck != null){
                    deck.previousClicked();
                    flashcard.removeAll();
                    //flashcard.add(new FlashcardTestForDeck(deckList.get(deckModel.getCurrentIndex())).get());
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
               /* if (deckController != null) {
                    deckController.nextClicked();
                    flashcard.removeAll();
                    flashcard.add(new FlashcardTestForDeck(deckList.get(deckModel.getCurrentIndex())).get());
                    flashcard.updateUI();
                }*/
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
        //this.deckController = deckController;

    }

   /* public static void main(String[] args) {
        new flashcardDeckguiTest();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }*/
}
