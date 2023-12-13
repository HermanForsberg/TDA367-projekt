package Controller.Clock;

import Model.Clock.Clock;
import Model.Clock.ClockFeature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClockFeatureController implements ManualTimerListener, PomodoroListener, StopwatchListener{


    private ClockFeature clockFeature;
    public ClockFeatureController(ClockFeature clockFeature){

        this.clockFeature = clockFeature;
    }


    @Override
    public void onManualClicked() {
        clockFeature.onManualClicked();
    }

    @Override
    public void onPomodoroClicked() {
        clockFeature.onPomodoroClicked();
    }

    @Override
    public void onStopwatchClicked() {
        clockFeature.onStopwatchClicked();
    }
}
