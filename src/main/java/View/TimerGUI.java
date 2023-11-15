package View;

import Controller.TimerController;
import Model.Timer;

import javax.swing.*;
//import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerGUI extends JPanel implements FramesWithGet{
    private JPanel frame;
    private JButton timeUp;
    private JButton timeDown;
    private JButton resetButton;
    private JButton startButton;
    private JLabel timerText;

    private Timer timer;

    private TimerController controller;


    public TimerGUI(Timer timer, TimerController controller){
        this.controller = controller;
        this.timer = timer;

        setSize(800, 600);
        setVisible(true);

        //timerText = new JLabel(String.format("%02d:%02d%n", timer.getMinutes(), timer.getSeconds()));
        timerText = new JLabel(String.format("%02d:%02d%n", 8, 35));
        timerText.setText(String.format("%02d:%02d%n", 8, 35));

        timeUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TimerGUI.this, "+5 Minutes");
                //controller.minusFive();
            }

        });
        timeDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TimerGUI.this, "-5 Minutes");
            }

        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TimerGUI.this, "Model.Timer reseted");
            }

        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TimerGUI.this, "Model.Timer started");
            }

        });



    }
    public void setController(TimerController controller){
        this.controller = controller;
    }
    public JPanel get(){
        return frame;
    }

}


