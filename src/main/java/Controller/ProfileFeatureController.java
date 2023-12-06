package Controller;

import Controller.Flashcard.AddMenu;
import Controller.Flashcard.AddMenuCard;
import Model.MvcModel;

import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileFeatureController extends JPanel implements Observer{

    private JButton addButton;

    public ProfileFeatureController(MvcModel model){


        for(Profile profile: model.getProfiles()){
            ProfileController profileController = new ProfileController(profile);
            profileController.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {


                    //model.saveData();
                    model.switchProfile(profile);
                }

            });
            add(profileController);
        }


        JButton addButton = new JButton("Add new profile");
        add(addButton);
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String name = JOptionPane.showInputDialog("Name of profile: ");

                if(!name.isEmpty()){
                    Profile newProfile = new Profile(name);
                    ProfileController profileController = new ProfileController(newProfile);
                    profileController.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {

                            model.switchProfile(newProfile);
                        }

                    });
                    model.addProfile(newProfile);
                    remove(addButton);
                    add(profileController);
                    add(addButton);
                    updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(ProfileFeatureController.this, "Need name");
                }



                }
            });

        }

        public void update(){


        }


    }


