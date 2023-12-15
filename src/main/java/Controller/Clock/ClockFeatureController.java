package Controller.Clock;

import Model.Clock.ClockFeature;

public class ClockFeatureController implements ManualTimerListener, PomodoroListener, StopwatchListener{

    private ClockFeature clockFeature;
    public ClockFeatureController(ClockFeature clockFeature){

        this.clockFeature = clockFeature;
    }


    @Override
    public void onManualClicked() {
        clockFeature.onManualTimerClicked();
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
