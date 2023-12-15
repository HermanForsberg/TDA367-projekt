import Model.Clock.Clock;
import Model.Clock.Pomodoro;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PomodoroTest {
    @Test
    public void pomodoro_minutes_should_start_at_25(){
        Clock clock = new Pomodoro();
        assertEquals(25, clock.getMinutes());
    }

    @Test
    public void pomodoro_seconds_should_start_0(){
        Clock clock = new Pomodoro();
        assertEquals(0, clock.getSeconds());
    }

    @Test
    public void pomodoro_minutes_should_be_25_after_reset(){
        Clock clock = new Pomodoro();
        clock.resetClock();
        assertEquals(25, clock.getMinutes());
    }

    @Test
    public void pomodoro_minutes_should_be_5_after_rest(){
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.rest();
        assertEquals(5, pomodoro.getMinutes());
    }


}
