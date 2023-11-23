package Model;


public class Stopwatch extends Clock{
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

    public static void main(String[] args){
        Stopwatch timer = new Stopwatch();
        timer.startClock();
    }
}
