package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Controller.Clock.ClockController;
import Controller.Clock.ClockFeatureController;
import Controller.Flashcard.*;
import Controller.Profile.AddProfileButtonListener;
import Controller.Profile.ProfileFeatureController;
import Controller.Quests.QuestsController;
import Model.*;

import javax.swing.*;
public class MvcControl extends JPanel implements AddProfileButtonListener {
    private MvcModel model;

    public MvcControl(MvcModel model) {

        this.model = model;

    }


    @Override
    public void addProfileClicked(Profile profile) {
        model.addProfile(profile);
    }
}
