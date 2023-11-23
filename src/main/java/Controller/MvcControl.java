package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import Model.*;
import javax.swing.*;
public class MvcControl extends JPanel{
    private MvcModel model;

    private FlashcardFeatureController flashcardFeatureController;

    private ClockFeatureController clockFeatureController;



    public MvcControl(MvcModel model) {

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(10, 10));

        //mainPanel.add(deckTest.get());
        //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        setSize(300,300);

        this.flashcardFeatureController = new FlashcardFeatureController(model.getFlashcardFeature());
        this.clockFeatureController = new ClockFeatureController(model.getClockFeature());

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
        add(clockFeatureController);
        updateUI();
    }

    public void switchUI(JPanel viewPanel){
        removeAll();
        add(viewPanel);
        updateUI();

    }


}
