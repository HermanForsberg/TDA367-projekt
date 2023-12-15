package View;

import javax.swing.*;

public class Images {
    private final ImageIcon manualTimerImageSmall = new ImageIcon("src/main/img/hourglass_32.png");
    private final ImageIcon stopwatchImageSmall = new ImageIcon("src/main/img/stopwatch_32.png");
    private final ImageIcon pomodoroImageSmall = new ImageIcon("src/main/img/tomato_32.png");
    private final ImageIcon manualTimerImageBig = new ImageIcon("src/main/img/hourglass_128.png");
    private final ImageIcon stopwatchImageBig = new ImageIcon("src/main/img/stopwatch_128.png");
    private final ImageIcon pomodoroImageBig = new ImageIcon("src/main/img/tomato_128.png");

    public Images() {
    }

    public ImageIcon getManualTimerImageSmall() {
        return manualTimerImageSmall;
    }

    public ImageIcon getStopwatchImageSmall() {
        return stopwatchImageSmall;
    }

    public ImageIcon getPomodoroImageSmall() {
        return pomodoroImageSmall;
    }

    public ImageIcon getManualTimerImageBig() {
        return manualTimerImageBig;
    }

    public ImageIcon getStopwatchImageBig() {
        return stopwatchImageBig;
    }

    public ImageIcon getPomodoroImageBig() {
        return pomodoroImageBig;
    }
}
