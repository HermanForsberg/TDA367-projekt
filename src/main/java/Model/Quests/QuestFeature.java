package Model.Quests;

import java.util.ArrayList;
import java.util.Objects;

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

    public void notified(int amount, String name){
        for(Quest currentQuest: quests){
            if(Objects.equals(currentQuest.getTopic(), name)){

                currentQuest.updateProgress(amount);
            }
        }
    }

}
