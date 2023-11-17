package View;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class DrawPanel extends JPanel{



    private HashMap<String, JPanel> views;

    int gap = 10;


    public DrawPanel(JPanel view){

        setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        setLayout(new BorderLayout(gap, gap));
        add(view);
    }

    public void updateView(String name){
        removeAll();

        updateUI();
    }

    public JPanel getViewPanel(){
        return this;
    }



}
