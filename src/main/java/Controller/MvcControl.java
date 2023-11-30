package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;

import Controller.Flashcard.DeckCollectionController;
import Model.*;
import javax.swing.*;
public class MvcControl extends JPanel implements Observer{
    private MvcModel model;

    private DeckCollectionController deckCollection;

    private TimerFeatureController timerFeatureController;



    public MvcControl(MvcModel model) {

        this.model = model;

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(10, 10));

        //mainPanel.add(deckTest.get());
        //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        setSize(300,300);

        this.deckCollection = new DeckCollectionController(model.getFlashcardFeature());
        this.timerFeatureController = new TimerFeatureController(model.getTimerFeature());

        add(deckCollection);
        //add(timerFeatureController);
    }

    public DeckCollectionController getDeckCollection() {
        return deckCollection;
    }

    public void flashcardMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(deckCollection);
        updateUI();
    }

    public void timerMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(timerFeatureController);
        updateUI();
    }

    public void switchUI(JPanel viewPanel){
        removeAll();
        add(viewPanel);
        updateUI();

    }


    @Override
    public void update() {

    }
}
