package Model.Quests;

import java.util.ArrayList;

public class QuestFeature {
    private QuestFactory questFactory;
    private ArrayList<Quest> quests;

    public QuestFeature() {
        questFactory = new QuestFactory();
        quests = questFactory.getQuests();
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }
}
