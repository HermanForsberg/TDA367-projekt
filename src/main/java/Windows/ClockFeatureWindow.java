package Windows;

import Controller.Clock.ClockController;
import Controller.Clock.ClockFeatureController;
import Controller.Clock.PomodoroListener;
import Controller.Clock.StopwatchListener;
import Controller.Clock.ManualTimerListener;
import Controller.Observer;
import Model.Clock.Clock;
import Model.Clock.ClockFeature;
import Model.CurrentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class ClockFeatureWindow extends JPanel implements Window, Observer {

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
        private JLabel imageLabel;

        private HashMap<Clock, ClockController> clockControllers = new HashMap<>();

        private CurrentView currentView;

        private ClockFeature clockFeature;

        private ClockFeatureController clockFeatureController;

        public ClockFeatureWindow(CurrentView currentView,ClockFeature clockFeature){

            this.clockFeature = clockFeature;
            this.clockFeature.addObserver(this);

            clocks = this.clockFeature.getClocks();
            clock = clocks.get(this.clockFeature.getClockIndex());


            clockFeatureController = new ClockFeatureController(this.clockFeature);


            this.currentView = currentView;
            this.currentView.addObserver(this);

            for (Clock c : clocks){
                //c.addObserver(this);
                switch (c.getClass().getSimpleName()) {

                    case "ManualTimer" -> imageLabel = new JLabel(manualTimerImageBig);

                    case "Stopwatch" -> imageLabel = new JLabel(stopwatchImageBig);

                    case "Pomodoro" -> imageLabel = new JLabel(pomodoroImageBig);


                }
                clockControllers.put(c, new ClockController(c, imageLabel));

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
            //Ska vara i View?
            final int gap = 20;

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            setBackground(Color.WHITE);
            mainPanel.setBackground(Color.WHITE);
            sideBar.setBackground(Color.WHITE);

            mainPanel.add(clockControllers.get(clock));

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

        public void update(){

            for(Clock c: clocks){
                clockControllers.get(c).setMediator(currentView.getProfile());
            }

            //clock.resetClock();
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
            createGrid(this.clockFeature.getClock());

        }

    }


