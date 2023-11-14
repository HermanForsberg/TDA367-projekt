package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GridBagProfileView {
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
        c.weightx = 0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 0;
        pane.add(profile, c);


        JButton flashcards = new JButton("Stats");
        c.weightx = 0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 1;
        pane.add(flashcards, c);


        JButton timer = new JButton("Quests");
        c.weightx = 0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0 ;
        c.gridwidth = 1;
        c.gridy = 2;
        c.ipadx = 100;
        pane.add(timer, c);


        JComponent backPanel = new JPanel();
        backPanel.setLayout(new GridBagLayout());
        backPanel.setForeground(Color.BLACK);
        backPanel.setBackground(Color.BLACK);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridwidth = 3;
        c.gridheight = 3;
        c.gridy = 0;
        pane.add(backPanel, c);

        JButton butt1 = new JButton("test");
        c.weightx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridy = 0;
        backPanel.add(butt1, c);



        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående Model.flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(pane, "profil här");
                JButton butt2 = new JButton("test2");
                c.weightx = 0.4;
                c.fill = GridBagConstraints.BOTH;
                c.gridx = 1;
                c.gridwidth = 1;
                c.gridheight = 1;
                c.gridy = 0;
                backPanel.add(butt2, c);

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