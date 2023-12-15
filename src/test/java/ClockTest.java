import Model.Clock.Clock;
import Model.Clock.ManualTimer;
import Model.Clock.Pomodoro;
import Model.Clock.Stopwatch;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClockTest {
    @Test
    public void pomodoro_minutes_should_start_at_25(){
        Clock clock = new Pomodoro();
        assertEquals(25, clock.getMinutes());
    }

    @Test
    public void manual_timer_minutes_should_start_20(){
        Clock clock = new ManualTimer();
        assertEquals(20, clock.getMinutes());
    }

    @Test
    public void stopwatch_minutes_should_start_0(){
        Clock clock = new Stopwatch();
        assertEquals(0, clock.getMinutes());
    }

    @Test
    public void manualTimer_seconds_should_start_0(){
        Clock clock = new ManualTimer();
        assertEquals(0, clock.getSeconds());
    }

    @Test
    public void pomodoro_seconds_should_start_0(){
        Clock clock = new Pomodoro();
        assertEquals(0, clock.getSeconds());
    }

    @Test
    public void stopwatch_seconds_should_start_0(){
        Clock clock = new Stopwatch();
        assertEquals(0, clock.getSeconds());
    }

    @Test
    public void pomodoro_minutes_should_be_25_after_reset(){
        Clock clock = new Pomodoro();
        clock.resetClock();
        assertEquals(25, clock.getMinutes());
    }

    @Test
    public void manualTimer_minutes_should_be_20_after_reset(){
        Clock clock = new ManualTimer();
        clock.resetClock();
        assertEquals(20, clock.getMinutes());
    }

    @Test
    public void stopwatch_minutes_should_be_20_after_reset(){
        Clock clock = new Stopwatch();
        clock.resetClock();
        assertEquals(0, clock.getMinutes());
    }
    @Test
    public void manualTimer_minutes_should_be_25_after_addTime(){
        ManualTimer manualTimer = new ManualTimer();
        manualTimer.addTime();
        assertEquals(25, manualTimer.getMinutes());
    }

    @Test
    public void manualTimer_minutes_should_be_15_after_subtractTime(){
        ManualTimer manualTimer = new ManualTimer();
        manualTimer.subtractTime();
        assertEquals(15, manualTimer.getMinutes());
    }

    @Test
    public void pomodoro_minutes_should_be_5_after_rest(){
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.rest();
        assertEquals(5, pomodoro.getMinutes());
    }


}
