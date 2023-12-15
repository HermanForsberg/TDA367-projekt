package Controller;

import Controller.Profile.AddProfileButtonListener;

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
