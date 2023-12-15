package View;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

import Windows.Window;

public class MvcView{

    private JPanel mainPanel = new JPanel();
    private int gap = 10;


    private HashMap<String, Window> views;

    public MvcView(HashMap<String, Window> newViews) {
        views=newViews;

        mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        mainPanel.setLayout(new BorderLayout(gap, gap));
        mainPanel.setSize(300,300);


        // mainPanel.add(statePanel, BorderLayout.PAGE_END);
    }

    public void setView(String name){

        mainPanel.removeAll();
        views.get(name).update();
        mainPanel.add((Component) views.get(name));
        mainPanel.updateUI();

    }

    public JComponent getMainPanel() {
        return mainPanel;
    }

}