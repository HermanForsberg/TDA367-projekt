package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GridBagMainLayout {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        JButton profile = new JButton("Profile");
        c.weightx = 0.5;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(profile, c);


        JButton flashcards = new JButton("Flashcards");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(flashcards, c);

        JButton timer = new JButton("Timer");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(timer, c);

        button = new JButton("5");
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(0,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(button, c);

        button = new JButton("test");
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(0,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 1;       //third row
        pane.add(button, c);


        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående Model.flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(pane, "profil här");
            }
        });

        flashcards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående Model.flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(pane, "flashcards här");
            }
        });

        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående Model.flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(pane, "timer här");
            }
        });

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}