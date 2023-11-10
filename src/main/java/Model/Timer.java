package Model;

import java.util.TimerTask;

public class Timer {
    //Model.Timer     = Keeps track of the time in a background thread.
    //TimerTask = Contains an abstract method called run(). When our Model.Timer reaches a certain time
    //            it will execute a task either once or repeatedly.
    private int minutes;
    private int seconds;
    private java.util.Timer timer;
    public Timer(int minutes) {

        this.minutes = minutes;
        this.seconds = 0;
        this.timer = new java.util.Timer();

    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (minutes == 0 && seconds == 0){
                timer.cancel();
            }
            else {
                if (seconds == 0){
                    minutes --;
                    seconds = 59;
                }
                else {
                    seconds --;
                }
            }
            System.out.printf("%02d:%02d%n", minutes, seconds);
        }
    };

    public void startClock(){
        timer.scheduleAtFixedRate(task, 0, 1000); // 1000ms = 1s
    }
    public void resetClock(){
    }
    public void pauseClock(){
        timer.cancel();
    }

    private void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    private void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public static void main(String[] args){
        Timer timer = new Timer(10);
        timer.startClock();
    }
}
