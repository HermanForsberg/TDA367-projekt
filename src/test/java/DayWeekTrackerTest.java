import Model.DayWeekTracker;
import Model.Statistics.StatsDay;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayWeekTrackerTest {
    //Make sure that you delete the lastCheckedDate.ser file after running the tests.
    @Test
    public void isNewDay_returns_true_on_a_new_day(){
        DayWeekTracker dayWeekTracker = new DayWeekTracker();
        LocalDate today = LocalDate.now();
        dayWeekTracker.setLastCheckedDate(today.minusDays(1));
        assertTrue(dayWeekTracker.isNewDay());
    }

    @Test
    public void isNewWeek_returns_true_on_a_new_day(){
        DayWeekTracker dayWeekTracker = new DayWeekTracker();
        LocalDate today = LocalDate.now();
        dayWeekTracker.setLastCheckedDate(today.minusDays(7));
        assertTrue(dayWeekTracker.isNewWeek());
    }
}
