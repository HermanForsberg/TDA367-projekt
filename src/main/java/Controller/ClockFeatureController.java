package Controller;

import Model.Clock;
import Model.ClockFeature;
import Model.ManualTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClockFeatureController extends JPanel {
    private JPanel groundPanel = new JPanel();
    private JPanel grid = new JPanel(new GridLayout(4, 0, 20, 20));
    private JPanel gridForTime = new JPanel(new GridLayout(0, 3, 20, 20));
    private JPanel gridForActions = new JPanel(new GridLayout(0, 2, 20, 20));
    private JButton swapButton = new JButton("Swap clock");
    private JButton startOrPauseButton = new JButton("Start");
    private JButton resetButton = new JButton("Reset");
    private JButton addTimeButton = new JButton("+5");
    private JButton subtractTimeButton = new JButton("-5");
    private JLabel timeLabel = new JLabel("00:00", SwingConstants.CENTER);
    private ImageIcon manualTimerImage = new ImageIcon("src/main/img/hourglass_64.png");
    private ImageIcon stopwatchImage = new ImageIcon("src/main/img/stopwatch_64.png");
    private ImageIcon pomodoroImage = new ImageIcon("src/main/img/tomato_64.png");
    private JLabel imageLabel = new JLabel(manualTimerImage);
    private ArrayList<Clock> currentClock = new ArrayList<Clock>();

    public ClockFeatureController(ClockFeature clockFeature){
        currentClock = clockFeature.getClocks();
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
        grid.add(imageLabel);
        grid.add(swapButton);
        grid.add(gridForActions);

        gridForTime.add(subtractTimeButton);
        gridForTime.add(timeLabel);
        gridForTime.add(addTimeButton);

        gridForActions.add(startOrPauseButton);
        gridForActions.add(resetButton);


        startOrPauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Clock cl = currentClock.get(clockFeature.getClockIndex());
                if (cl.isRunning()){
                    cl.pauseClock();
                    startOrPauseButton.setText("Start");
                    timeLabel.setText(cl.getMinutes() + ":" + cl.getSeconds());
                }
                else {
                    cl.startClock();
                    startOrPauseButton.setText("Pause");
                    timeLabel.setText(cl.getMinutes() + ":" + cl.getSeconds());
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetClock(clockFeature);
            }
        });
        swapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetClock(clockFeature);

                clockFeature.swapClock();
                System.out.println(clockFeature.getClockIndex());
                switch (clockFeature.getClockIndex()) {
                    case 0:
                        imageLabel.setIcon(manualTimerImage);
                        addTimeButton.setVisible(true);
                        subtractTimeButton.setVisible(true);
                        break;
                    case 1:
                        imageLabel.setIcon(stopwatchImage);
                        addTimeButton.setVisible(false);
                        subtractTimeButton.setVisible(false);
                        break;
                    case 2:
                        imageLabel.setIcon(pomodoroImage);
                        break;
                }
            }
        });

        /*addTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Clock cl = currentClock.get(clockFeature.getClockIndex());
                c
            }
        });*/
    }
    private void resetClock(ClockFeature clockFeature){
        Clock cl = currentClock.get(clockFeature.getClockIndex());
        cl.resetClock();
        startOrPauseButton.setText("Start");
        timeLabel.setText(cl.getMinutes() + ":" + cl.getSeconds()); //Temp
    }
}
