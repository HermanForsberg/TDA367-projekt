package Windows;

import Controller.CurrentViewController;
import Controller.Flashcard.PlayButtonListener;
import Controller.MvcControl;
import Controller.ObjectsInFocusController;
import Controller.Observer;
import Controller.Profile.AddProfileButtonListener;
import Controller.Profile.ProfileButton;
import Controller.Profile.ProfileButtonListener;
import Model.MvcModel;
import Model.ObjectsInFocus;
import Model.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileFeatureWindow extends  JPanel implements Observer, Window{

        private JButton addButton;

        private CurrentViewController currentViewController;

        private ObjectsInFocusController objectsInFocusController;

        private ObjectsInFocus objectsInFocus;

        private JLabel minutesPassedLabel = new JLabel("0");

        private JLabel flashcardsDone = new JLabel("0");
        //TODO lös denna

        public ProfileFeatureWindow(MvcModel model, CurrentViewController currentViewController, MvcControl control, ObjectsInFocusController objectsInFocusController, ObjectsInFocus objectsInFocus){

            this.currentViewController=currentViewController;
            this.objectsInFocusController = objectsInFocusController;
            this.objectsInFocus = objectsInFocus;
            for(Profile profile: model.getProfiles()){

                ProfileButton tempProfileButton = new ProfileButton(profile);
                tempProfileButton.addButtonListenerToProfileClicked(currentViewController);
                tempProfileButton.addButtonListenerToProfileClicked(objectsInFocusController);
                add(tempProfileButton);
            }

            addButton = new JButton("Add new profile");
            add(addButton);
            add(minutesPassedLabel);
            add(flashcardsDone);

            addButtonListenerToAddProfile(control);




        }



        public void addButtonListenerToAddProfile(AddProfileButtonListener apbl){
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("Name of profile: ");

                    if(!name.isEmpty()){


                        Profile newProfile = new Profile(name);
                        ProfileButton tempProfileButton = new ProfileButton(newProfile);
                        tempProfileButton.addButtonListenerToProfileClicked(currentViewController);
                        apbl.addProfileClicked(newProfile);
                        remove(addButton);
                        remove(flashcardsDone);
                        remove(minutesPassedLabel);
                        add(tempProfileButton);
                        add(addButton);
                        add(flashcardsDone);
                        add(minutesPassedLabel);
                        updateUI();
                    }
                    else {
                        JOptionPane.showMessageDialog(ProfileFeatureWindow.this, "Need name");
                    }
                }
            });
        }

        public void update(){
            flashcardsDone.setText(objectsInFocus.getCurrentProfile().getStats().getFlashcardsCompleted() +" Flashcards done");
            minutesPassedLabel.setText(String.valueOf(objectsInFocus.getCurrentProfile().getStats().getMinutesPassedFromCurrentDay()) + " Minutes passed");
        }


    }




