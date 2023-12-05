package Controller;

import java.util.HashSet;
import java.util.Set;

public class ObserverHandler {

    private final Set<Observer> observers;
    public ObserverHandler(){

        observers = new HashSet<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void updateObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }
}
