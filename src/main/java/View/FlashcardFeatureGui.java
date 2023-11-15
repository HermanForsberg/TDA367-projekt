package View;

import Controller.FlashcardFeatureController;
import Model.FlashcardDeck;
import Model.FlashcardFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashcardFeatureGui implements FramesWithGet{

    private FlashcardFeature model;
     private JPanel mainPanel = new JPanel();

    private JButton deck1 = new JButton("TestDeckClickable");

    private JPanel grid = new JPanel(new GridLayout(2, 0, 5, 5));

    private JPanel fill = new JPanel(new GridLayout(1, 0, 0, 5));

    private JPanel fill2 = new JPanel();

    private JPanel fill3 = new JPanel();

    private JButton addButton = new JButton("Add Deck");

    private FlashcardFeatureController controller;


     int gap = 1;
    public FlashcardFeatureGui(FlashcardFeature flashcardFeature, flashcardDeckguiTest deckView) {
        this.model = flashcardFeature;
        mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        mainPanel.setLayout(new BorderLayout(gap, gap));
        mainPanel.add(grid);
        fill.add(addButton);
        grid.add(fill);
        grid.add(deck1);
        for (FlashcardDeck card : model.GetListOfDecks()) {
            grid.add(fill);
            grid.add(new JButton(card.getDeckName()));

        }

        deck1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (controller != null) {
                    controller.deck1Clicked();
                    mainPanel.removeAll();
                    mainPanel.add(deckView.get());
                    mainPanel.updateUI();
                }
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                //JOptionPane.showMessageDialog(flashcardDeckgui.this, "föregående kort");


            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (controller != null) {

                    controller.addClicked("NewDeck");
                    grid.add(new JButton(model.getNewestDeck().getDeckName()));
                    grid.updateUI();
                }
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                //JOptionPane.showMessageDialog(flashcardDeckgui.this, "föregående kort");


            }
        });
    }




    public void setController(FlashcardFeatureController controller){
        this.controller = controller;
    }
    public JPanel get(){
        mainPanel.removeAll();
        grid.removeAll();
        mainPanel.add(grid);
        fill.add(addButton);
        grid.add(fill);
        grid.add(deck1);
        for(FlashcardDeck card: model.GetListOfDecks()) {

            grid.add(new JButton(card.getDeckName()));
        }
        return mainPanel;
    }
}
