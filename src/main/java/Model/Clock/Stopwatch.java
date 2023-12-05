package Model.Clock;


public class Stopwatch extends Clock { //Counts upwards starting from 00:00.
    public Stopwatch (){
        super(0);
    }
    public void calculateTime(){
        if (getSeconds() == 59){
            setSeconds(0);
            setMinutes(getMinutes() + 1);
        }
        else{
            setSeconds(getSeconds() + 1);
        }
        System.out.printf("%02d:%02d%n", getMinutes(), getSeconds());

    }

    public void resetClock(){
        pauseClock();
        setMinutes(0);
        setSeconds(0);
    };
}
