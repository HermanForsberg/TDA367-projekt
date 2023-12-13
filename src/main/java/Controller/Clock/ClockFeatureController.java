package Controller.Clock;

import Model.Clock.Clock;
import Model.Clock.ClockFeature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClockFeatureController extends JPanel{
    private final ArrayList<Clock> clocks;
    private Clock clock;
    private final JPanel sideBar = new JPanel();
    private final JPanel mainPanel = new JPanel();

    //Buttons, Images etc.
    private final ImageIcon manualTimerImageSmall = new ImageIcon("src/main/img/hourglass_32.png");
    private final ImageIcon stopwatchImageSmall = new ImageIcon("src/main/img/stopwatch_32.png");
    private final ImageIcon pomodoroImageSmall = new ImageIcon("src/main/img/tomato_32.png");
    private final ImageIcon manualTimerImageBig = new ImageIcon("src/main/img/hourglass_128.png");
    private final ImageIcon stopwatchImageBig = new ImageIcon("src/main/img/stopwatch_128.png");
    private final ImageIcon pomodoroImageBig = new ImageIcon("src/main/img/tomato_128.png");
    private final JButton manualTimerButton = new JButton("Timer", manualTimerImageSmall);
    private final JButton stopwatchButton = new JButton("Stopwatch", stopwatchImageSmall);
    private final JButton pomodoroButton = new JButton("Pomodoro", pomodoroImageSmall);
    private JLabel imageLabel;

    private final ArrayList<ClockController> clockControllers = new ArrayList<>();

    public ClockFeatureController(ClockFeature clockFeature){
        clocks = clockFeature.getClocks();
        clock = clocks.get(clockFeature.getClockIndex());

        for (Clock c : clocks){
            switch (c.getClass().getSimpleName()) {
                case "ManualTimer" -> imageLabel = new JLabel(manualTimerImageBig);
                case "Stopwatch" -> imageLabel = new JLabel(stopwatchImageBig);
                case "Pomodoro" -> imageLabel = new JLabel(pomodoroImageBig);
            }
            clockControllers.add(new ClockController(c, imageLabel));
        }

        //Sets the grid.
        createGrid(clockFeature.getClockIndex());
         manualTimerButton.addActionListener(e -> {
             //Måste göra något åt denna rad v
             clockControllers.get(clockFeature.getClockIndex()).getStartAndPauseButton().setText("Start");
             clockFeature.setClockIndex(0);
             swapClock(clockFeature);
         });
        stopwatchButton.addActionListener(e -> {
            //Måste göra något åt denna rad v
            clockControllers.get(clockFeature.getClockIndex()).getStartAndPauseButton().setText("Start");
            clockFeature.setClockIndex(1);
            swapClock(clockFeature);
        });
        pomodoroButton.addActionListener(e -> {
            //Måste göra något åt denna rad v
            clockControllers.get(clockFeature.getClockIndex()).getStartAndPauseButton().setText("Start");
            clockFeature.setClockIndex(2);
            swapClock(clockFeature);
        });
    }

    private void swapClock(ClockFeature clockFeature){
        clock.resetClock();
        clock = clocks.get(clockFeature.getClockIndex());
        clock.playSound("src/main/sound/Click_Sound.wav");

        //Resets everything
        removeAll();
        revalidate();
        mainPanel.removeAll();
        mainPanel.revalidate();
        sideBar.removeAll();
        sideBar.revalidate();
        repaint();
        createGrid(clockFeature.getClockIndex());
        updateUI();
    }

    private void createGrid(int index){
        //Ska vara i View?
        final int gap = 20;

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        setBackground(Color.WHITE);
        mainPanel.setBackground(Color.WHITE);
        sideBar.setBackground(Color.WHITE);

        mainPanel.add(clockControllers.get(index));

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(mainPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(sideBar, constraints);

        sideBar.setLayout(new GridBagLayout());
        GridBagConstraints constraintSideBar = new GridBagConstraints();
        constraintSideBar.insets = new Insets(gap, gap, gap, gap);

        constraintSideBar.gridx = 0;
        constraintSideBar.gridy = 0;
        constraintSideBar.weightx = 1;
        constraintSideBar.fill = GridBagConstraints.HORIZONTAL;
        sideBar.add(manualTimerButton, constraintSideBar);

        constraintSideBar.gridx = 0;
        constraintSideBar.gridy = 1;
        sideBar.add(stopwatchButton, constraintSideBar);

        constraintSideBar.gridx = 0;
        constraintSideBar.gridy = 2;
        sideBar.add(pomodoroButton, constraintSideBar);
    }

    public ArrayList<ClockController> getClockControllers() {
        return clockControllers;
    }

}
