package Model.Clock;

import Model.Mediator;

public class ManualTimer extends Clock implements Rest { //Counts downwards.
    private Mediator mediator;
    public ManualTimer(Mediator mediator) {
        super(20);
        this.mediator = mediator;
    }

    public void calculateTime(){
        if (getMinutes() == 0 && getSeconds() == 0){
            getTimer().cancel();
        }
        else {
            if (getSeconds() == 0){
                setMinutes(getMinutes() - 1);
                setSeconds(59);
                addOneMinutesPassed();
                mediator.notified("clock");
            }
            else {
                setSeconds(getSeconds() - 1);
            }
        }
    }

    public void rest(){

    }

    public void addTime(){
        setMinutes(getMinutes()+5);
    }
    public void subtractTime(){
        if (getMinutes() > 5) {
            setMinutes(getMinutes() - 5);
        }
    }
    public void resetClock(){
        pauseClock();
        setMinutes(20);
        setSeconds(2);
    }

}
