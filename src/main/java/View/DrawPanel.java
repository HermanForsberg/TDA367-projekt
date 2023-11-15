package View;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class DrawPanel {

    private JPanel viewPanel;

    private HashMap<String, FramesWithGet> views;

    int gap = 10;


    public DrawPanel(HashMap viewsMap){
        this.views=viewsMap;
        this.viewPanel = new JPanel();
        viewPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        viewPanel.setLayout(new BorderLayout(gap, gap));
        this.viewPanel.add(this.views.get("Flashcard").get());
    }

    public void updateView(String name){
        viewPanel.removeAll();
        viewPanel.add(views.get(name).get());
        viewPanel.updateUI();
    }

    public JPanel getViewPanel(){
        return viewPanel;
    }



}
