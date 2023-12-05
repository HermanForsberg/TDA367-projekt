package Controller;

import Model.MvcModel;
import Model.State;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileFeatureController extends JPanel {

    public ProfileFeatureController(MvcModel model){

        ProfileController profile1 = new ProfileController(model.getProfiles().get(0));
        ProfileController profile2 = new ProfileController(model.getProfiles().get(1));
        profile1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                model.getCurrentProfile().saveData();
                model.switchProfile(model.getProfiles().get(0));
            }

        });

        profile2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                model.getCurrentProfile().saveData();
                model.switchProfile(model.getProfiles().get(1));
            }

        });

        add(profile1);
        add(profile2);
    }

}
