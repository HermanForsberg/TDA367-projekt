package View;

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

    private MvcControl control;

    private JPanel mainPanel = new JPanel();
    private int gap = 10;

    private CurrentView currentView;

    private HashMap<String, Window> views;

    public MvcView(CurrentView newCurrentView, HashMap<String, Window> newViews) {
        currentView= newCurrentView;

        currentView.addObserver(this);



        views=newViews;

        //mainPanel.add(deckTest.get());


        mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        mainPanel.setLayout(new BorderLayout(gap, gap));
        mainPanel.setSize(300,300);


        // mainPanel.add(statePanel, BorderLayout.PAGE_END);
    }

    public void update(){
        System.out.println(views.get(currentView.getCurrentView()));
        mainPanel.removeAll();
        mainPanel.add((Component) views.get(currentView.getCurrentView()));
        mainPanel.updateUI();
    }

    //public void setView(JPanel comp){mainPanel.add(comp);}


    public void setGuiControl(MvcControl control) {
        this.control = control;
        //mainPanel.add(control);
    }


    public JComponent getMainPanel() {
        return mainPanel;
    }

}