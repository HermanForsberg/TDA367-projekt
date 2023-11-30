package Controller;

import Model.Clock;
import Model.ManualTimer;
import Model.Pomodoro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClockController extends JPanel implements Observer{
    private JLabel timeLabel = new JLabel("00:00", SwingConstants.CENTER);
    private Clock clock;
    public ClockController(Clock clock, JLabel imageLabel){
        this.clock = clock;
        final int gap = 10;

        //Time label
        timeLabel.setFont(new Font("Calibri", Font.BOLD, 24));

        //All the buttons
        JButton startOrPauseButton = new JButton("Start");
        JButton resetButton = new JButton("Reset");
        JButton addTimeButton = new JButton("+5");
        JButton subtractTimeButton = new JButton("-5");

        //The grid
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(gap, gap, gap, gap);
        setBackground(Color.WHITE);

        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Row 1
        gbc.gridy = 0;

        if (clock instanceof ManualTimer){
            gbc.gridx = 0;
            add(subtractTimeButton, gbc);

            gbc.gridx = 2;
            add(addTimeButton, gbc);
        }

        gbc.gridx = 1;
        add(timeLabel, gbc);

        //Row 2
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(imageLabel, gbc);

        //Row 3
        JPanel lastRow = new JPanel();
        lastRow.setLayout(new GridBagLayout());
        GridBagConstraints gbcLastRow = new GridBagConstraints();
        lastRow.setBackground(Color.WHITE);

        gbcLastRow.fill = GridBagConstraints.HORIZONTAL;
        gbcLastRow.weightx = 1;
        gbcLastRow.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        add(lastRow, gbc);

        gbcLastRow.gridx = 0;
        gbcLastRow.insets = new Insets(0, 0, 0,5);
        lastRow.add(startOrPauseButton, gbcLastRow);

        gbcLastRow.gridx = 1;
        gbcLastRow.insets = new Insets(0, 5, 0,0);
        lastRow.add(resetButton, gbcLastRow);

        //Buttons actions
        startOrPauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clock.isRunning()){
                    clock.pauseClock();
                    startOrPauseButton.setText("Start");
                    timeLabel.setText(clock.getMinutes() + ":" + clock.getSeconds());
                }
                else {
                    clock.startClock();
                    startOrPauseButton.setText("Pause");
                    timeLabel.setText(clock.getMinutes() + ":" + clock.getSeconds());
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock.resetClock();
                startOrPauseButton.setText("Start");
            }
        });
        addTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clock instanceof ManualTimer){
                    ((ManualTimer) clock).addTime();
                }
            }
        });
        subtractTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clock instanceof ManualTimer){
                    ((ManualTimer) clock).subtractTime();
                }
            }
        });
    }

    public void update(){
        timeLabel.setText(clock.getMinutes() + ":" + clock.getSeconds());
    }
}
