package Model.Clock;

import Model.Mediator;

public class Pomodoro extends Clock implements Rest {
    boolean timeToRest;
    int intervalCounter;

    public Pomodoro(Mediator mediator) {
        super(25, mediator);

        timeToRest = true;
        intervalCounter = 0;
    }

    public void calculateTime(){
        if (getMinutes() == 0 && getSeconds() == 0){
            rest();
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
        if (timeToRest) {               //Time to rest
            if (intervalCounter < 4){   //Small rest
                setMinutes(5);
            }
            else {                      //Big rest
                setMinutes(30);
                intervalCounter = 0;
            }
            timeToRest = false;
        }
        else {                          //Time to work
            setMinutes(25);
            intervalCounter += 1;
            timeToRest = true;
        }
    }

    public void resetClock(){
        pauseClock();
        setMinutes(25);
        setSeconds(0);
    }

    @Override
    public void update() {

    }


}
