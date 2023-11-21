package View;

import Controller.MvcControl;
import Model.MvcModel;

import java.awt.*;
import java.beans.*;
import javax.swing.*;

public class MvcView {
    private MvcControl control;

    private JButton questButton;

    private JPanel mainPanel = new JPanel();

    private JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 10, 0));

    private flashcardDeckguiTest deckTest;

    private int gap = 10;

    public MvcView(MvcModel model, DrawPanel drawPanel) {


        model.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getNewValue().toString());
                drawPanel.updateView(evt.getNewValue().toString());





            }
        });

        //mainPanel.add(deckTest.get());
        mainPanel.add(drawPanel.getViewPanel());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        mainPanel.setLayout(new BorderLayout(gap, gap));
        mainPanel.add(drawPanel.getViewPanel());
        //mainPanel.add(deckTest.get());
        //mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.setSize(300,300);
        // mainPanel.add(statePanel, BorderLayout.PAGE_END);
    }

    public void setView(JPanel comp){mainPanel.add(comp);}


    public void setGuiControl(MvcControl control) {
        this.control = control;
    }


    public JComponent getMainPanel() {
        return mainPanel;
    }

}