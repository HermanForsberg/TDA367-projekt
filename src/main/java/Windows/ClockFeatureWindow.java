package Windows;

import Controller.Clock.ClockController;
import Controller.Clock.ClockFeatureController;
import Controller.Clock.PomodoroListener;
import Controller.Clock.StopwatchListener;
import Controller.Clock.ManualTimerListener;
import Controller.Observer;
import Model.Clock.Clock;
import Model.Clock.ClockFeature;
import View.Images;
import Model.ObjectsInFocus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class ClockFeatureWindow extends JPanel implements Window, Observer {

        private final ArrayList<Clock> clocks;
        private Clock clock;
        private final JPanel sideBar = new JPanel();
        private final JPanel mainPanel = new JPanel();
        private final Images images = new Images();

        //Buttons, Images etc.
        private final JButton manualTimerButton = new JButton("Timer", images.getManualTimerImageSmall());
        private final JButton stopwatchButton = new JButton("Stopwatch", images.getStopwatchImageSmall());
        private final JButton pomodoroButton = new JButton("Pomodoro", images.getPomodoroImageSmall());
        private JLabel imageLabel;

        private final HashMap<Clock, ClockWindow> clockControllers = new HashMap<>();

        private final ClockFeature clockFeature;

        private final ClockFeatureController clockFeatureController;

        private ObjectsInFocus objectsInFocus;

        public ClockFeatureWindow(ObjectsInFocus objectsInFocus, ClockFeature clockFeature){

            this.clockFeature = clockFeature;
            this.clockFeature.addObserver(this);

            clocks = this.clockFeature.getClocks();
            clock = clocks.get(this.clockFeature.getClockIndex());


            clockFeatureController = new ClockFeatureController(this.clockFeature);


            this.objectsInFocus = objectsInFocus;
            this.objectsInFocus.addObserver(this);

            for (Clock clock : clocks){
                //c.addObserver(this);
                switch (clock.getClass().getSimpleName()) {

                    case "ManualTimer" -> imageLabel = new JLabel(images.getManualTimerImageBig());

                    case "Stopwatch" -> imageLabel = new JLabel(images.getStopwatchImageBig());

                    case "Pomodoro" -> imageLabel = new JLabel(images.getPomodoroImageBig());


                }
                clockControllers.put(clock, new ClockWindow(clock, new ClockController(clock), imageLabel));

            }

            //Sets the grid.
            createGrid(this.clockFeature.getClock());
            makeClockButtons(this.clockFeature);

        }

        private void makeManualTimer(){

            addListenerToManualTimerButton(clockFeatureController);

        }

        private void makeStopwatch(){

            addListenerToStopwatchButton(clockFeatureController);

        }

        private void makePomodoro(){

            addListenerToPomodoroButton(clockFeatureController);

        }

        private void addListenerToManualTimerButton(ManualTimerListener mtl){

            manualTimerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mtl.onManualClicked();
                }
            });

        }

        private void addListenerToPomodoroButton(PomodoroListener pl){

            pomodoroButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pl.onPomodoroClicked();
                }
            });

        }

        private void addListenerToStopwatchButton(StopwatchListener sl){

            stopwatchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sl.onStopwatchClicked();
                }
            });

        }

        private void makeClockButtons(ClockFeature clockFeature){

            makeManualTimer();
            makeStopwatch();
            makePomodoro();

        }

        private void createGrid(Clock clock){
            final int gap = 20;

            setLayout(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();

            setBackground(Color.WHITE);

            mainPanel.setBackground(Color.WHITE);
            mainPanel.add(clockControllers.get(clock));

            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.weightx = 1;
            constraints.weighty = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(mainPanel, constraints);

            sideBar.setBackground(Color.WHITE);
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.weightx = 0;
            constraints.weighty = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(sideBar, constraints);

            sideBar.setLayout(new GridBagLayout());
            GridBagConstraints constraintsSideBar = new GridBagConstraints();
            constraintsSideBar.insets = new Insets(gap, gap, gap, gap);

            constraintsSideBar.gridx = 0;
            constraintsSideBar.gridy = 0;
            constraintsSideBar.weightx = 1;
            constraintsSideBar.fill = GridBagConstraints.HORIZONTAL;
            sideBar.add(manualTimerButton, constraintsSideBar);

            constraintsSideBar.gridx = 0;
            constraintsSideBar.gridy = 1;
            sideBar.add(stopwatchButton, constraintsSideBar);

            constraintsSideBar.gridx = 0;
            constraintsSideBar.gridy = 2;
            sideBar.add(pomodoroButton, constraintsSideBar);
        }

        public void update(){

            for(Clock clock: clocks){
                clockControllers.get(clock).setMediator(objectsInFocus.getCurrentProfile());

            }
            clock = clocks.get(clockFeature.getClockIndex());

            //Resets everything
            removeAll();
            revalidate();
            mainPanel.removeAll();
            mainPanel.revalidate();
            sideBar.removeAll();
            sideBar.revalidate();
            repaint();
            createGrid(this.clockFeature.getClock());
        }
    }