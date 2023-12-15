package Model.Clock;

import Controller.Observer;
import Controller.ObserverHandler;

import javax.swing.*;
import java.util.ArrayList;

public class ClockFeature extends JPanel{

    private final ArrayList<Clock> clockList;

    private int clockIndex;

    private final ObserverHandler observerHandler = new ObserverHandler();


    public ClockFeature(ArrayList<Clock> clocks){
        clockList = clocks;
        clockIndex = 0;
    }

    public ArrayList<Clock> getClocks(){
        return clockList;
    }

    public int getClockIndex(){
        return clockIndex;
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }

    public Clock getClock(){
        return clockList.get(clockIndex);
    }

    public void onManualClicked(){
        this.clockIndex = 0;
        observerHandler.updateObservers();
    }

    public void onStopwatchClicked(){
        this.clockIndex = 1;
        observerHandler.updateObservers();
    }

    public void onPomodoroClicked(){
        this.clockIndex = 2;
        observerHandler.updateObservers();
    }
}
