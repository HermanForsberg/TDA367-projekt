package Controller.Clock;

import Controller.Observer;
import Model.Clock.Clock;
import Model.Clock.ManualTimer;
import Model.Mediator;

import javax.swing.*;
import java.awt.*;


public class ClockController {

    //TODO lösa denna

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
            //clock.playSound("src/main/sound/Click_Sound.wav");
        }
    }

}
