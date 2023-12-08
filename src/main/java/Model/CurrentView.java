package Model;

import Controller.Observer;
import Controller.ObserverHandler;
import Windows.Window;

import java.util.HashSet;
import java.util.Set;

public class CurrentView {

    private ObserverHandler observerHandler = new ObserverHandler();

    private String currentView;

    public CurrentView(){

    }

    public String getCurrentView(){
        return currentView;
    }
    public void setCurrentView(String view){
        currentView = view;
        observerHandler.updateObservers();
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }
}
