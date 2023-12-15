package View;

import Controller.CurrentViewController;
import Controller.MvcControl;

import Model.CurrentView;
import Model.MvcModel;

import java.awt.*;
import java.beans.*;
import java.util.HashMap;
import javax.swing.*;
import Controller.Observer;

import Windows.Window;

public class MvcView implements Observer{

    private CurrentView control;

    private JPanel mainPanel = new JPanel();
    private int gap = 10;

    private CurrentView currentView;

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

    public void update(){

        //System.out.println(views.get(currentView.getCurrentView()));
        mainPanel.removeAll();
        mainPanel.add((Component) views.get(currentView.getCurrentView()));
        for(Component component: mainPanel.getComponents()){
            component.repaint();
        }
        mainPanel.updateUI();
    }

    //public void setView(JPanel comp){mainPanel.add(comp);}


    public void setGuiControl(CurrentViewController control) {
    }


    public JComponent getMainPanel() {
        return mainPanel;
    }

}