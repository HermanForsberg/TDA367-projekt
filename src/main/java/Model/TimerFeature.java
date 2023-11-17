package Model;

import javax.swing.*;
import java.util.ArrayList;

public class TimerFeature extends JPanel {

    private ArrayList<Timer> timersList  = new ArrayList<Timer>();



    public TimerFeature(ArrayList<Timer> timers){
        timersList = timers;

    }

    public ArrayList<Timer> getTimers(){
        return timersList;

    }
}
