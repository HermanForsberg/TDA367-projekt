package Model.DailyQuests;

import java.util.ArrayList;

import static Model.DailyQuests.Quest.generateRandomQuest;

public class DailyQuests {
    ArrayList<String> listOfTopics = new ArrayList<>(); //Venne vart denna borde ligga
    ArrayList<Quest> quests = new ArrayList<>();
    public DailyQuests() {
        createTopics();
        createQuests();
    }

    private void createTopics(){
        listOfTopics.add("Clock");
        listOfTopics.add("Flashcard");
    }

    private void createQuests() {
        for(String topic : listOfTopics){
            quests.add(generateRandomQuest(topic));
        }
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }
}
