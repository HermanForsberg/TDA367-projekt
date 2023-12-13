package Model.Statistics;

import java.util.HashSet;
import java.util.Set;

public class StatisticModel {

    private int lastWeekHours;

    private int lastWeekFlashcards;

    private Set<StatsDayModel> week = new HashSet<StatsDayModel>();

    public StatisticModel(){
        week.add(new StatsDayModel("Monday"));
        week.add(new StatsDayModel("Tuesday"));
        week.add(new StatsDayModel("Wednesday"));
        week.add(new StatsDayModel("Thursday"));
        week.add(new StatsDayModel("Friday"));
        week.add(new StatsDayModel("Saturday"));
        week.add(new StatsDayModel("Sunday"));
    }



}
