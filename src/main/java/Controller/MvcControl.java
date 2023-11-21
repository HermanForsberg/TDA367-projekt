package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import Model.*;
import javax.swing.*;
public class MvcControl extends JPanel{
    private MvcModel model;



    public MvcControl(MvcModel model) {

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(10, 10));

        //mainPanel.add(deckTest.get());
        //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        setSize(300,300);

        FlashcardFeatureController flashcardFeatureController = new FlashcardFeatureController(model.getFlashcardFeature());
        TimerFeatureController timerFeatureController = new TimerFeatureController(model.getTimerFeature());

        add(flashcardFeatureController);
        //add(timerFeatureController);
    }


    public void startButtonActionPerformed(ActionEvent ae) {

        model.setState(State.FLASHCARDS);
    }

    public void flashcardMenuActionPerformed(ActionEvent ae) {

        model.setState(State.FLASHCARDS);
    }

    public void timerMenuActionPerformed(ActionEvent ae) {

        model.setState(State.TIMER);
    }


}
