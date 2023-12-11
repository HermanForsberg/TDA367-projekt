package Model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayWeekTracker {
    private LocalDate lastCheckedDate;

    public DayWeekTracker() {
        lastCheckedDate = LocalDate.now();
    }

    public void checkDayAndWeek() {
        LocalDate currentDate = LocalDate.now();

        if (!currentDate.isEqual(lastCheckedDate)) {
            // Ny dag
            newDay();
            lastCheckedDate = currentDate;
        }

        if (currentDate.getDayOfWeek() == DayOfWeek.MONDAY && !currentDate.isEqual(lastCheckedDate)) {
            // Ny vecka på måndagar
            newWeek();
            lastCheckedDate = currentDate;
        }
    }

    private void newDay() {
        System.out.println("A new day!");
        //Nya quests
    }

    private void newWeek() {
        System.out.println("A new week!");
        //Nya quests
    }
}

