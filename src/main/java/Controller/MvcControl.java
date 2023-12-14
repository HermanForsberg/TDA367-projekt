package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Controller.Clock.ClockController;
import Controller.Clock.ClockFeatureController;
import Controller.Flashcard.*;
import Controller.Profile.ProfileFeatureController;
import Controller.Quests.QuestsController;
import Model.*;

import javax.swing.*;
public class MvcControl extends JPanel{
    private MvcModel model;

    private DeckCollectionController deckCollection;

    private ClockFeatureController clockFeatureController;

    private QuestsController questController;


    private ProfileFeatureController profileFeatureController;



    public MvcControl(MvcModel model) {

        this.model = model;

    }


}
