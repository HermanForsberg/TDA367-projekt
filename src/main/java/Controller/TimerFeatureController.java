package Controller;

import Model.TimerFeature;
import View.TimerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerFeatureController extends JPanel {
    private JPanel groundPanel = new JPanel();
    private JPanel grid = new JPanel(new GridLayout(3, 0, 10, 10));
    private JPanel gridForTime = new JPanel(new GridLayout(0, 3, 10, 10));
    private JPanel gridForActions = new JPanel(new GridLayout(0, 2, 10, 10));
    private JButton timerButton = new JButton("This is a picture of the timer");
    private JButton startOrPauseButton = new JButton("Start");
    private JButton resetButton = new JButton("Reset");
    private JButton addTimeButton = new JButton("+5");
    private JButton subtractTimeButton = new JButton("-5");
    private JLabel timeLabel = new JLabel("00:00");
    public TimerFeatureController(TimerFeature timerFeature){
       /* groundPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        groundPanel.setLayout(new BorderLayout(10,10));

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setLayout(new BorderLayout(10,10));


        add(groundPanel);
        groundPanel.add(grid);
        fill.add(startButton);
        grid.add(fill);*/

        //Sets the grid.
        add(groundPanel);
        groundPanel.add(grid);
        grid.add(gridForTime);
        grid.add(timerButton);
        grid.add(gridForActions);

        gridForTime.add(subtractTimeButton);
        gridForTime.add(timeLabel);
        gridForTime.add(addTimeButton);

        gridForActions.add(startOrPauseButton);
        gridForActions.add(resetButton);

        addTimeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //for (Timer timer : model.getTimers()){

                //}
                /*deck.nextClicked();
                panelForFlashcard.removeAll();
                panelForFlashcard.add(new FlashcardController(deck.getDeck().get(deck.getCurrentIndex())));
                panelForFlashcard.updateUI();
                updateUI();*/
            }

        });
    }
}
