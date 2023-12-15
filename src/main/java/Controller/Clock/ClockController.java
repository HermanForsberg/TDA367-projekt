package Controller.Clock;

import Model.Clock.Clock;
import Model.Clock.ManualTimer;


public class ClockController {
    private Clock clock;

    public ClockController(Clock clock) {
        this.clock = clock;
    }

    public void pauseClock(){
        clock.pauseClock();
    }

    public void startClock(){
        clock.startClock();
    }

    public void resetClock(){
        clock.resetClock();
    }

    public void subtractTime(){
        if (clock instanceof ManualTimer){
            ((ManualTimer) clock).subtractTime();

        }
    }

    public void addTime(){
        if (clock instanceof ManualTimer){
            ((ManualTimer) clock).addTime();
        }
    }

}
