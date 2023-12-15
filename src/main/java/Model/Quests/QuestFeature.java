package Model.Quests;

import Controller.Observer;
import Controller.ObserverHandler;

import java.util.ArrayList;
import java.util.Objects;

public class QuestFeature {
    private QuestFactory questFactory;
    private ArrayList<Quest> quests;

    private ObserverHandler observerHandler = new ObserverHandler();

    public QuestFeature() {
        questFactory = new QuestFactory();
        quests = questFactory.getQuests();
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }

    public void notified(int amount, String name){
        for(Quest currentQuest: quests){
            if(Objects.equals(currentQuest.getTopic(), name)){
                currentQuest.updateProgress(amount);
                observerHandler.updateObservers();

            }
        }
    }

}
