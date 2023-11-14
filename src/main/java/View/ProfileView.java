package View;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JComponent {

    private JPanel mainPanel;
    public ProfileView(){
        JPanel profile = new JPanel();
        profile.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel lvl = new JLabel("Level: ");
        c.gridx = 0;
        c.gridy = 0;
        profile.add(lvl, c);

        JLabel name = new JLabel("Name: ");
        c.gridx = 0;
        c.gridy = 1;
        profile.add(name, c);
    }

}
