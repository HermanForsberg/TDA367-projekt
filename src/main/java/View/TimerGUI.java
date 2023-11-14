package View;

import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerGUI extends JFrame{
    private JPanel frame;
    private JButton timeUp;
    private JButton timeDown;
    private JButton resetButton;
    private JButton startButton;
    private JLabel timerText;

    private Timer timer;


    public TimerGUI(){
        timer = new Timer(10);

        setContentPane(frame);
        setTitle("MyPlug");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        //timerText = new JLabel(String.format("%02d:%02d%n", timer.getMinutes(), timer.getSeconds()));
        timerText = new JLabel(String.format("%02d:%02d%n", 8, 35));
        timerText.setText(String.format("%02d:%02d%n", 8, 35));

        timeUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TimerGUI.this, "+5 Minutes");
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

    public static void main(String[] args) {
        new TimerGUI();
    }
}


