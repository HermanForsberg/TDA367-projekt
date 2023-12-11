package Model.Quests;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class QuestFactory {
    ArrayList<String> listOfTopics = new ArrayList<>();
    ArrayList<Quest> quests = new ArrayList<>();
    public QuestFactory() {
        createTopics();
        createQuests("Daily");
        createQuests("Weekly");
    }

    private void createTopics(){
        listOfTopics.add("Clock");
        listOfTopics.add("Flashcard");
        listOfTopics.add("Level");
    }

    private void createQuests(String typeOfQuest) {
        for(String topic : listOfTopics){
            quests.add(generateRandomQuest(typeOfQuest, topic));
        }
    }

    private Quest generateRandomQuest(String typeOfQuest, String topic) {
        int difficulty = createDifficulty();
        int amount = calculateAmount(typeOfQuest, topic, difficulty);
        return new Quest(typeOfQuest, topic, createDescription(topic, amount), difficulty, calculateXpGain(difficulty-1), amount);
    }

    private String createDescription(String topic, int amount){
        String text = "No description found...";
        switch (topic) {
            case "Clock"     -> text = "Study for a total of " + formatAmountToTime(amount);
            case "Flashcard" -> text = "Complete " + amount + " of flashcards";
            case "Level"     -> text = "Level up " + amount + " level(s)";
        }
        return text;
    }

    private String formatAmountToTime(int amount){
        int hours = amount / 60;
        int minutes = amount % 60;
        if (minutes == 0) {
            return hours + "h";
        }
        return hours + "h, " + minutes + "m";
    }

    private int createDifficulty() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    private int calculateXpGain(int difficulty) {
        final double XPFACTOR = 1.2;
        double xpWithDecimals = Math.pow(XPFACTOR, difficulty) * 10;
        return Math.toIntExact(Math.round(xpWithDecimals));             //Får man typecasta här?
    }

    private int calculateAmount(String typeOfQuest, String topic, int difficulty) {
        int amount = -1;
        switch (topic) {
            case "Clock"     -> amount = difficulty * 20 + 40;
            case "Flashcard" -> amount = difficulty * 10;
            case "Level"     -> amount = Math.max(difficulty / 3, 1);
        }
        if (Objects.equals(typeOfQuest, "Weekly")) amount *= 5;
        return amount;
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }
}
