package Model;

import java.util.TimerTask;

public class ManualTimer extends Clock implements Rest {
    public ManualTimer() {
        super(20);
    }

    public void calculateTime(){
        if (getMinutes() == 0 && getSeconds() == 0){
            getTimer().cancel();
        }
        else {
            if (getSeconds() == 0){
                setMinutes(getMinutes() - 1);
                setSeconds(59);
            }
            else {
                setSeconds(getSeconds() - 1);
            }
        }
        System.out.printf("%02d:%02d%n", getMinutes(), getSeconds());
    }
    @Override
    public void rest(){

    }

    public static void main(String[] args){
        ManualTimer timer = new ManualTimer();
        timer.startClock();
    }
}
