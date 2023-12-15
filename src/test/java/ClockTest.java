import Model.Clock.Clock;
import Model.Clock.Pomodoro;
import junit.framework.TestCase;

public class ClockTest extends TestCase {

    public void time_should_not_be_negative(){
        Clock clock = new Pomodoro();
        assertEquals(25, clock.getMinutes());
    }

}
