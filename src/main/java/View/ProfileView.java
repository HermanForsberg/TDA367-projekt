package View;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JFrame {

    private JPanel mainPanel;
    public ProfileView(){

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,2));
        JLabel l = new JLabel("a");
        p.add(l);
        JButton btn = new JButton("click");
        p.add (btn);
        l = new JLabel("b");
        p.add(l);
        btn = new JButton("click");
        p.add(btn);



        setContentPane(p);
        setTitle("TestDeck");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        setVisible(true);

    }

    public static void main(String[] args) {
        JFrame frame = new ProfileView();
    }

}
