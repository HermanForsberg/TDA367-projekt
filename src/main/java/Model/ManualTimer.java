package Model;

public class ManualTimer extends Clock implements Rest{ //Counts downwards.
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
        setSeconds(0);
    };
}
