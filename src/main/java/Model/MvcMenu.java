package Model;
import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MvcMenu {

    private JToolBar toolBar;
    private JMenuBar menuBar = new JMenuBar();
    private MvcControl control;

    @SuppressWarnings("serial")
    public MvcMenu(MvcControl cntrl) {
        this.control = cntrl;
        JButton flashcards = new JButton("Flashcards");

        flashcards.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (control != null) {

                    control.flashcardMenuActionPerformed(e); // e.g., here

                }
            }
        });

        JButton timers = new JButton("Timers");

        timers.addActionListener(new ActionListener() {
            // all the buttons do is call methods of the control
            public void actionPerformed(ActionEvent e) {

                if (control != null) {

                    control.timerMenuActionPerformed(e); // e.g., here

                }
            }
        });
        JButton profile = new JButton("Profile");

        profile.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (control != null) {

                    control.profileMenuActionPerformed(e); // e.g., here

                }
            }
        });
        menuBar.add(profile);

        menuBar.add(timers);
        menuBar.add(flashcards);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
