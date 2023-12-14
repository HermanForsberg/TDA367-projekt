package Windows;

import Controller.CurrentViewController;
import Controller.Observer;
import Controller.Profile.ProfileController;
import Model.MvcModel;
import Model.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileFeatureWindow extends  JPanel implements Observer, Window{

        private JButton addButton;
        //TODO lös denna

        public ProfileFeatureWindow(MvcModel model, CurrentViewController currentViewController){


            for(Profile profile: model.getProfiles()){
                ProfileController profileController = new ProfileController(profile);
                profileController.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {



                        currentViewController.setProfile(profile);

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
                                currentViewController.setProfile(newProfile);
                                //model.switchProfile(newProfile);
                            }

                        });
                        model.addProfile(newProfile);
                        remove(addButton);
                        add(profileController);
                        add(addButton);
                        updateUI();
                    }
                    else {
                        JOptionPane.showMessageDialog(ProfileFeatureWindow.this, "Need name");
                    }



                }
            });

        }

        public void update(){


        }


    }




