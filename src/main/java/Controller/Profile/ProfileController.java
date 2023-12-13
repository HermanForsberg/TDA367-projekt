package Controller.Profile;

import Model.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileController extends JButton {

    public ProfileController(Profile model){
        setText(model.getName());

    }
}
