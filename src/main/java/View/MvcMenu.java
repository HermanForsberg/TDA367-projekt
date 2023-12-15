package View;
import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MvcMenu {

    private JToolBar toolBar;
    private JMenuBar menuBar = new JMenuBar();
    private CurrentViewController control;

    @SuppressWarnings("serial")
    public MvcMenu(CurrentViewController cntrl) {
        this.control = cntrl;
        JButton flashcards = new JButton("Flashcards");

        flashcards.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (control != null) {

                    control.setView("deckCollection"); // e.g., here

                }
            }
        });

        JButton timers = new JButton("Timers");

        timers.addActionListener(new ActionListener() {
            // all the buttons do is call methods of the control
            public void actionPerformed(ActionEvent e) {

                if (control != null) {

                    control.setView("clockFeature"); // e.g., here

                }
            }
        });
        JButton profile = new JButton("Profile");

        profile.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (control != null) {

                    control.setView("profileWindow"); // e.g., here

                }
            }
        });


        JButton quests = new JButton("Quests");

        quests.addActionListener(new ActionListener() {
            // all the buttons do is call methods of the control
            public void actionPerformed(ActionEvent e) {

                if (control != null) {

                    control.setView("questWindow"); // e.g., here

                }
            }
        });

        menuBar.add(profile);
        menuBar.add(quests);
        menuBar.add(timers);
        menuBar.add(flashcards);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
