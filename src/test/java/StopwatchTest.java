import Model.Clock.Clock;
import Model.Clock.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StopwatchTest {
    @Test
    public void stopwatch_minutes_should_start_0(){
        Clock clock = new Stopwatch();
        assertEquals(0, clock.getMinutes());
    }

    @Test
    public void stopwatch_seconds_should_start_0(){
        Clock clock = new Stopwatch();
        assertEquals(0, clock.getSeconds());
    }

    @Test
    public void stopwatch_minutes_should_be_20_after_reset(){
        Clock clock = new Stopwatch();
        clock.resetClock();
        assertEquals(0, clock.getMinutes());
    }
}
