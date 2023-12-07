package Model.Quests;

import java.util.ArrayList;

public class QuestFeature {
    private QuestFactory questFactory;
    private WeeklyQuests weeklyQuests;
    private ArrayList<Quest> dailyQuests;

    public QuestFeature() {
        questFactory = new QuestFactory();
        weeklyQuests = new WeeklyQuests();

        dailyQuests = questFactory.getQuests();
    }

    public ArrayList<Quest> getDailyQuests() {
        return dailyQuests;
    }
}
