package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import Model.*;
import javax.swing.*;
public class MvcControl extends JPanel{
    private MvcModel model;

    private FlashcardFeatureController flashcardFeatureController;

    private TimerFeatureController timerFeatureController;



    public MvcControl(MvcModel model) {

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(10, 10));

        //mainPanel.add(deckTest.get());
        //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        setSize(300,300);

        this.flashcardFeatureController = new FlashcardFeatureController(model.getFlashcardFeature());
        this.timerFeatureController = new TimerFeatureController(model.getTimerFeature());

        add(flashcardFeatureController);
        //add(timerFeatureController);
    }


    public void startButtonActionPerformed(ActionEvent ae) {

        model.setState(State.FLASHCARDS);
    }

    public void flashcardMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(flashcardFeatureController);
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
