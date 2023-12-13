package Model.Clock;

import Controller.Observer;
import Controller.ObserverHandler;
import Model.Mediator;
import Model.Observable;
import Model.Profile;

import java.util.TimerTask;
import java.util.Timer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
public abstract class Clock implements Observable, Observer{
    //Timer     = Keeps track of the time in a background thread.
    //TimerTask = Contains an abstract method called run(). When our Model.Timer reaches a certain time
    //            it will execute a task either once or repeatedly.
    private ObserverHandler observerHandler = new ObserverHandler();
    private int minutes;
    private int seconds;
    private Timer timer;
    private boolean isRunning;
    private int minutesPassed;

    public Mediator mediator;
    //TODO


    public Clock(int minutes, Mediator mediator) {
        this.minutes = minutes;
        this.seconds = 0;
        this.timer = new Timer();
        this.isRunning = false;
        this.minutesPassed = 0;
        this.mediator = mediator;
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }

    public abstract void calculateTime();
    public void startClock(){
        isRunning = true;
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                calculateTime();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // 1000ms = 1s
    }
    public abstract void resetClock();
    public void pauseClock(){
        isRunning = false;
        timer.cancel();
    }
    protected void setMinutes(int minutes) {

        this.minutes = minutes;
    }

    public void setMediator(Mediator newMediator){
        mediator = newMediator;
    }

    // @param path to sound file that will be played.
    public void playSound(String soundFilePath){
        try {
            File soundFile = new File(soundFilePath);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //public abstract int minutesPassed();
    protected void setSeconds(int seconds) {
        this.seconds = seconds;
        observerHandler.updateObservers();
    }
    public void setRunning(boolean running) {
        isRunning = running;
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
    public boolean isRunning() {
        return isRunning;
    }
    public int getMinutesPassed() {
        return minutesPassed;
    }
    public void setMinutesPassed(int minutesPassed) {
        this.minutesPassed = minutesPassed;
    }
    public void addOneMinutesPassed(){
        setMinutesPassed(getMinutesPassed()+1);
    }
}
