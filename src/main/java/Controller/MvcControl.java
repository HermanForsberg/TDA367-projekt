package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Model.*;
import javax.swing.*;
public class MvcControl extends JPanel implements Observer{
    private MvcModel model;

    private FlashcardFeatureController flashcardFeatureController;

    private TimerFeatureController timerFeatureController;

    private ProfileFeatureController profileFeatureController;


    public MvcControl(MvcModel model) {

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(10, 10));

        //mainPanel.add(deckTest.get());
        //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        setSize(300,300);

        this.flashcardFeatureController = new FlashcardFeatureController(model.getCurrentProfile());
        this.timerFeatureController = new TimerFeatureController(model.getTimerFeature());
        this.profileFeatureController = new ProfileFeatureController(model);
        add(flashcardFeatureController);
        //add(timerFeatureController);


        model.addObserver(this);

    }


    public void update(){

        System.out.println(model.getInstance().getCurrentProfile());
        flashcardFeatureController = new FlashcardFeatureController(model.getInstance().getCurrentProfile());
        removeAll();
        add(flashcardFeatureController);
        updateUI();
    }

    public void startButtonActionPerformed(ActionEvent ae) {

        model.setState(State.FLASHCARDS);
    }



    public void flashcardMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(flashcardFeatureController);
        updateUI();
    }

    public void profileMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(profileFeatureController);
        updateUI();
    }

    public void statMenuActionPerformed(ActionEvent ae) {

        removeAll();
        //add(statFeatureController);
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


}
