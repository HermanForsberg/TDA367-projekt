import Model.Statistics.StatsDay;
import org.junit.Assert;
import org.junit.Test;

public class StatsDayTest {
    @Test
    public void addMinutes_adds_expected_amount_of_minutes(){
        StatsDay statsDay = new StatsDay("Monday");
        int oldMinutes = statsDay.getMinutesLapsed();
        statsDay.addMinutes(20);
        int newMinutes = statsDay.getMinutesLapsed();
        Assert.assertEquals(oldMinutes + 20, newMinutes);
    }
    @Test
    public void addFlashcardsCompleted_adds_expected_amount_of_minutes(){
        StatsDay statsDay = new StatsDay("Monday");
        int oldFlashcardsCompleted = statsDay.getFlashcardsCompleted();
        statsDay.addFlashcardsCompleted(10);
        int newFlashcardsCompleted = statsDay.getFlashcardsCompleted();
        Assert.assertEquals(oldFlashcardsCompleted + 10, newFlashcardsCompleted);
    }
    @Test
    public void addLevelsGained_adds_expected_amount_of_minutes(){
        StatsDay statsDay = new StatsDay("Monday");
        int oldLevelsGained = statsDay.getLevelsGained();
        statsDay.addLevelsGained(3);
        int newLevelsGained = statsDay.getLevelsGained();
        Assert.assertEquals(oldLevelsGained + 3, newLevelsGained);
    }
}
