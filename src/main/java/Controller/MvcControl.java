package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Model.*;
import javax.swing.*;
public class MvcControl extends JPanel{
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

        model.addProfilePropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getNewValue().toString());
                if(evt.getNewValue().toString().equals("Profile1") || evt.getNewValue().toString().equals("Profile2") );
                System.out.println(model.getCurrentProfile());
                flashcardFeatureController = new FlashcardFeatureController(model.getCurrentProfile());
                removeAll();
                add(flashcardFeatureController);
                updateUI();
                //updateProfile();

            }
        });


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
