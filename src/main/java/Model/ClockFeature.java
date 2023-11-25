package Model;

import javax.swing.*;
import java.util.ArrayList;

public class ClockFeature extends JPanel{

    private ArrayList<Clock> clockList  = new ArrayList<Clock>();
    private int clockIndex;


    public ClockFeature(ArrayList<Clock> clocks){
        clockList = clocks;
        clockIndex = 0;
    }

    public ArrayList<Clock> getClocks(){
        return clockList;
    }
    public void swapClock(){
        clockIndex = (clockIndex+1)%3;
    }
    public int getClockIndex(){
        return clockIndex;
    }
}
