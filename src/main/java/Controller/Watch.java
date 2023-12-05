package Controller;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Watch {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    private final Timer timer;
    private final Set<Observer> observers;

    public Watch() {
        observers = new HashSet<>();
        timer = new Timer(delay, e -> {

            for (Observer o : observers)

                o.update();
        });
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void start() {
        timer.start();
    }
}
