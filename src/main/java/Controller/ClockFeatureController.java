package Controller;

import Model.Clock;
import Model.ClockFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClockFeatureController extends JPanel{
    private ArrayList<Clock> clocks;
    private Clock clock;
    private JPanel sideBar = new JPanel();
    private JPanel mainPanel = new JPanel();

    //Buttons, Images etc.
    private ImageIcon manualTimerImageSmall = new ImageIcon("src/main/img/hourglass_32.png");
    private ImageIcon stopwatchImageSmall = new ImageIcon("src/main/img/stopwatch_32.png");
    private ImageIcon pomodoroImageSmall = new ImageIcon("src/main/img/tomato_32.png");
    private ImageIcon manualTimerImageBig = new ImageIcon("src/main/img/hourglass_128.png");
    private ImageIcon stopwatchImageBig = new ImageIcon("src/main/img/stopwatch_128.png");
    private ImageIcon pomodoroImageBig = new ImageIcon("src/main/img/tomato_128.png");
    private JButton manualTimerButton = new JButton("Timer", manualTimerImageSmall);
    private JButton stopwatchButton = new JButton("Stopwatch", stopwatchImageSmall);
    private JButton pomodoroButton = new JButton("Pomodoro", pomodoroImageSmall);
    private JLabel imageLabel = new JLabel(manualTimerImageBig);
    private ClockController clockController;

    public ClockFeatureController(ClockFeature clockFeature){
        clocks = clockFeature.getClocks();
        clock = clocks.get(clockFeature.getClockIndex());

        //Sets the grid.
        createGrid();
         manualTimerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clockFeature.setClockIndex(0);
                swapClock(clockFeature);
            }
        });
        stopwatchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clockFeature.setClockIndex(1);
                swapClock(clockFeature);
            }
        });
        pomodoroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clockFeature.setClockIndex(2);
                swapClock(clockFeature);
            }
        });
    }

    private void swapClock(ClockFeature clockFeature){
        clock.resetClock();
        clock = clocks.get(clockFeature.getClockIndex());

        //Resets everything
        removeAll();
        revalidate();
        mainPanel.removeAll();
        mainPanel.revalidate();
        sideBar.removeAll();
        sideBar.revalidate();
        repaint();
        createGrid();

        //Updates image to show the current clock
        switch (clockFeature.getClockIndex()) {
            case 0 -> imageLabel.setIcon(manualTimerImageBig);
            case 1 -> imageLabel.setIcon(stopwatchImageBig);
            case 2 -> imageLabel.setIcon(pomodoroImageBig);
        }
    }

    private void createGrid(){
        //TODO Ska vara i View? + Göra om koden
        //setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        //setLayout(new BorderLayout(10,10));
        final int gap = 20;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //gbc.insets = new Insets(5,5,5,5);

        setBackground(Color.WHITE);
        mainPanel.setBackground(Color.WHITE);
        sideBar.setBackground(Color.WHITE);

        clockController = new ClockController(clock, imageLabel);
        mainPanel.add(clockController);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(mainPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(sideBar, gbc);

        sideBar.setLayout(new GridBagLayout());
        GridBagConstraints gbcSideBar = new GridBagConstraints();
        gbcSideBar.insets = new Insets(gap, gap, gap, gap);

        gbcSideBar.gridx = 0;
        gbcSideBar.gridy = 0;
        gbcSideBar.weightx = 1;
        gbcSideBar.fill = GridBagConstraints.HORIZONTAL;
        sideBar.add(manualTimerButton, gbcSideBar);

        gbcSideBar.gridx = 0;
        gbcSideBar.gridy = 1;
        sideBar.add(stopwatchButton, gbcSideBar);

        gbcSideBar.gridx = 0;
        gbcSideBar.gridy = 2;
        sideBar.add(pomodoroButton, gbcSideBar);
    }

    public ClockController getClockController() {
        return clockController;
    }

}
