import java.util.Timer;
import java.util.TimerTask;

public class stopwatch {

    private int minutes;
    private int seconds;
    public stopwatch(int minutes) {

        this.minutes = minutes;
        this.seconds = 0;

    }

    public void startClock(){

    }
    public void resetClock(){

    }
    public void pauseClock(){

    }

    public void clockLoop(){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            int x = 0;
            @Override
            public void run() {
                // Define the task to be executed at the specified interval
                System.out.println(x += 1);
            }
        };

        // Schedule the task to run after a 1-second delay and then repeat every 2 seconds
        timer.schedule(task, 1000, 1000);

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
}
