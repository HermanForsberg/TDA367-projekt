package Model.Statistics;

import java.util.HashSet;
import java.util.Set;

public class StatisticModel {

    private int lastWeekHours;

    private int lastWeekFlashcards;

    private Set<StatsDay> week = new HashSet<StatsDay>();

    public StatisticModel(){
        week.add(new StatsDay("Monday"));
        week.add(new StatsDay("Tuesday"));
        week.add(new StatsDay("Wednesday"));
        week.add(new StatsDay("Thursday"));
        week.add(new StatsDay("Friday"));
        week.add(new StatsDay("Saturday"));
        week.add(new StatsDay("Sunday"));
    }



}
