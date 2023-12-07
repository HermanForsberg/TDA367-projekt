package Model.Quests;

import java.util.ArrayList;

import static Model.Quests.Quest.generateRandomQuest;

public class QuestFactory {
    ArrayList<String> listOfTopics = new ArrayList<>(); //Venne vart denna borde ligga
    ArrayList<Quest> quests = new ArrayList<>();
    public QuestFactory() {
        createTopics();
        createQuests();
    }

    private void createTopics(){
        listOfTopics.add("Clock");
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
