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
