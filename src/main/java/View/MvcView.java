import TimerModel.Timer;
import TimerModel.TimerGUI;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class MvcView {
    private MvcControl control;

    private JButton questButton;

    private JPanel mainPanel = new JPanel();

    private TimerGUI timerView = new TimerGUI();

    private JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 10, 0));

    private flashcardDeckguiTest deckTest = new flashcardDeckguiTest();

    private int gap = 10;

    public MvcView(MvcModel model) {


        model.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getNewValue().toString());

                if (evt.getNewValue().toString().equals("Timer")) {

                    mainPanel.removeAll();
                    mainPanel.add(timerView.get());
                    mainPanel.updateUI();


                }
                else if (evt.getNewValue().toString().equals("Flashcard")) {

                    mainPanel.removeAll();
                    mainPanel.add(deckTest.get());
                    mainPanel.updateUI();


                }
            }
        });

        mainPanel.add(deckTest.get());

        mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        mainPanel.setLayout(new BorderLayout(gap, gap));

        mainPanel.add(deckTest.get());
       //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.setSize(300,300);
       // mainPanel.add(statePanel, BorderLayout.PAGE_END);
    }


    public void setGuiControl(MvcControl control) {
        this.control = control;
    }


    public JComponent getMainPanel() {
        return mainPanel;
    }

}