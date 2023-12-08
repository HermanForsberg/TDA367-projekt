package Model;

import Controller.Observer;

public interface Observable {
    void addObserver(Observer observer);
}
