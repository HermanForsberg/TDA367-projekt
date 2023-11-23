package Model;

import java.util.TimerTask;
import java.util.Timer;

public abstract class Clock {
    //Timer     = Keeps track of the time in a background thread.
    //TimerTask = Contains an abstract method called run(). When our Model.Timer reaches a certain time
    //            it will execute a task either once or repeatedly.
    private int minutes;
    private int seconds;
    private Timer timer;
    public Clock(int minutes) {

        this.minutes = minutes;
        this.seconds = 0;
        this.timer = new Timer();

    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            calculateTime();
        }
    };

    public abstract void calculateTime();
    public void startClock(){
        timer.scheduleAtFixedRate(task, 0, 1000); // 1000ms = 1s
    }

    protected void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    protected void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public Timer getTimer() {
        return timer;
    }
}
