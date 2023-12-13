package Controller.Clock;

import Controller.Observer;
import Model.Clock.Clock;
import Model.Clock.ManualTimer;
import Model.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockController extends JPanel implements Observer {
    private JLabel timeLabel = new JLabel("00:00", SwingConstants.CENTER);
    private Clock clock;
    private JButton startAndPauseButton = new JButton("Start");

    public ClockController(Clock clock, JLabel imageLabel){
        this.clock = clock;
        clock.addObserver(this);


        //Time label
        formatTimeLabel();
        timeLabel.setFont(new Font("Calibri", Font.BOLD, 24));

        //All the buttons
        JButton resetButton = new JButton("Reset");
        JButton addTimeButton = new JButton("+5");
        JButton subtractTimeButton = new JButton("-5");

        //The grid
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        int gap = 10;
        constraints.insets = new Insets(gap, gap, gap, gap);
        setBackground(Color.WHITE);

        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        //Row 1
        constraints.gridy = 0;

        if (clock instanceof ManualTimer){
            constraints.gridx = 0;
            add(subtractTimeButton, constraints);

            constraints.gridx = 2;
            add(addTimeButton, constraints);
        }

        constraints.gridx = 1;
        add(timeLabel, constraints);

        //Row 2
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(imageLabel, constraints);

        //Row 3
        JPanel lastRow = new JPanel();
        lastRow.setLayout(new GridBagLayout());
        GridBagConstraints gbcLastRow = new GridBagConstraints();
        lastRow.setBackground(Color.WHITE);

        gbcLastRow.fill = GridBagConstraints.HORIZONTAL;
        gbcLastRow.weightx = 1;
        gbcLastRow.gridwidth = 1;

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        add(lastRow, constraints);

        gbcLastRow.gridx = 0;
        gbcLastRow.insets = new Insets(0, 0, 0,5);
        lastRow.add(startAndPauseButton, gbcLastRow);

        gbcLastRow.gridx = 1;
        gbcLastRow.insets = new Insets(0, 5, 0,0);
        lastRow.add(resetButton, gbcLastRow);

        //Buttons actions
        startAndPauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clock.isRunning()){
                    clock.pauseClock();
                    startAndPauseButton.setText("Start");
                    clock.playSound("src/main/sound/Stop_Clock.wav");
                }
                else {
                    clock.startClock();
                    startAndPauseButton.setText("Pause");
                    clock.playSound("src/main/sound/Start_Clock.wav");
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock.resetClock();
                startAndPauseButton.setText("Start");
                formatTimeLabel();
                clock.playSound("src/main/sound/Reset_Clock.wav");
            }
        });
        addTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clock instanceof ManualTimer){
                    ((ManualTimer) clock).addTime();
                    clock.playSound("src/main/sound/Click_Sound.wav");
                }
            }
        });
        subtractTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clock instanceof ManualTimer){
                    ((ManualTimer) clock).subtractTime();
                    clock.playSound("src/main/sound/Click_Sound.wav");
                }
            }
        });
    }

    public void update(){

        formatTimeLabel();
        //System.out.println(clock.getSeconds());
        //timeLabel.setText("0" + clock.getSeconds() + ":");
        //System.out.println(clock.getSeconds());

    }

    private void formatTimeLabel(){
        String text = "";
        if (clock.getMinutes() < 10){
            text = ("0" + clock.getMinutes() + ":");
        }
        else {
            text += (clock.getMinutes() + ":");
        }

        if (clock.getSeconds() < 10){
            text += ("0" + clock.getSeconds());
        }
        else {
            text += clock.getSeconds();
        }

        timeLabel.setText(text);
        //System.out.println(text);
        //timeLabel.updateUI();

    }

    public void setMediator(Mediator mediator){
        clock.setMediator(mediator);
    }
    public JButton getStartAndPauseButton() {
        return startAndPauseButton;
    }
}
