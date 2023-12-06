package View;

import Controller.MvcControl;

import Model.MvcModel;

import java.awt.*;
import java.beans.*;
import javax.swing.*;

public class MvcView {

    private MvcControl control;

    private JPanel mainPanel = new JPanel();
    private int gap = 10;

    public MvcView(MvcModel model) {




        //mainPanel.add(deckTest.get());


        mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        mainPanel.setLayout(new BorderLayout(gap, gap));


        mainPanel.setSize(300,300);


        // mainPanel.add(statePanel, BorderLayout.PAGE_END);
    }

    public void setView(JPanel comp){mainPanel.add(comp);}


    public void setGuiControl(MvcControl control) {
        this.control = control;
        mainPanel.add(control);
    }


    public JComponent getMainPanel() {
        return mainPanel;
    }

}