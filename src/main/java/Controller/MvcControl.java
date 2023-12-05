package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Controller.Flashcard.*;
import Model.*;
import javax.swing.*;
public class MvcControl extends JPanel{
    private MvcModel model;

    private DeckCollectionController deckCollection;

    private ClockFeatureController clockFeatureController;



    public MvcControl(MvcModel model) {

        this.model = model;

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(10, 10));

        //mainPanel.add(deckTest.get());
        //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        setSize(300,300);

        this.deckCollection = new DeckCollectionController(model.getFlashcardFeature());
        this.clockFeatureController = new ClockFeatureController(model.getClockFeature());

        add(deckCollection);
        //add(timerFeatureController);
    }


    public void flashcardMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(deckCollection);
        updateUI();
    }

    public void timerMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(clockFeatureController);
        updateUI();
    }

    public void switchUI(JPanel viewPanel){
        removeAll();
        add(viewPanel);
        updateUI();

    }

    public ArrayList<ClockController> getClockControllers(){
        return clockFeatureController.getClockControllers();
    }


}
