package Controller.Profile;

import Model.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileButton extends JButton {

    private Profile currentProfile;

    public ProfileButton(Profile model){
        setText(model.getName());
        currentProfile = model;
    }

    public void addButtonListenerToProfileClicked(ProfileButtonListener pbl){
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pbl.onProfileButtonClicked(currentProfile);
            }
        });
    }
}
