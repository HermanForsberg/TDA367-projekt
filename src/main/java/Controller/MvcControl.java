package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Controller.Clock.ClockController;
import Controller.Clock.ClockFeatureController;
import Controller.Flashcard.*;
import Controller.QuestsController.*;
import Model.*;
import Model.Quests.QuestFeature;

import javax.swing.*;
public class MvcControl extends JPanel implements Observer{
    private MvcModel model;

    private DeckCollectionController deckCollection;

    private ClockFeatureController clockFeatureController;

    private QuestsController questController;


    private ProfileFeatureController profileFeatureController;



    public MvcControl(MvcModel model) {

        this.model = model;

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(10, 10));

        //mainPanel.add(deckTest.get());
        //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        setSize(300,300);

        this.deckCollection = new DeckCollectionController(model.getCurrentProfile());
        this.clockFeatureController = new ClockFeatureController(model.getClockFeature());
        this.questController = new QuestsController(model.getQuestFeature());

        this.profileFeatureController = new ProfileFeatureController(model);

        add(deckCollection);
        model.addObserver(this);
        //add(timerFeatureController);
    }

    public void update(){

        System.out.println(model.getInstance().getCurrentProfile());
        deckCollection = new DeckCollectionController(model.getInstance().getCurrentProfile());
        removeAll();
        add(deckCollection);
        updateUI();
    }

    public void profileMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(profileFeatureController);
        updateUI();
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

    public void questMenuActionPerformed(ActionEvent ae) {

        removeAll();
        add(questController);
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
