package Model.Quests;

import Model.DayWeekTracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class QuestFactory {
    private final String FILENAME = "quests.ser"; // File to store the quests
    ArrayList<String> listOfTopics = new ArrayList<>();
    ArrayList<Quest> quests = new ArrayList<>();
    DayWeekTracker dayWeekTracker;


    public QuestFactory() {
        dayWeekTracker = new DayWeekTracker();

        loadQuestsFromFile();
        createTopics();

        if (!dayWeekTracker.lastDateFileExists()){
            createQuests("Daily");
            createQuests("Weekly");
            dayWeekTracker.saveLastCheckedDate();
        }
        else {
            if (dayWeekTracker.isNewDay()){
                deleteQuests("Daily");
                createQuests("Daily");
            }

            if (dayWeekTracker.isNewWeek()){
                deleteQuests("Weekly");
                createQuests("Weekly");
            }
        }
        saveQuestsToFile();
    }

    private void loadQuestsFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            quests = (ArrayList<Quest>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            // File doesn't exist - quests ArrayList will remain empty
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveQuestsToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            outputStream.writeObject(quests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createTopics(){
        listOfTopics.add("Clock");
        listOfTopics.add("Flashcard");
        listOfTopics.add("Level");
    }

    private void createQuests(String typeOfQuest) {
        int index = 0;
        for(String topic : listOfTopics){
            switch (typeOfQuest) {
                case "Daily"  -> quests.add(index, generateRandomQuest(typeOfQuest, topic));
                case "Weekly" -> quests.add(generateRandomQuest(typeOfQuest, topic));
            }
            index++;
        }
    }

    private void deleteQuests(String typeOfQuest) {
        switch (typeOfQuest) {
            case "Daily"  -> quests.subList(0, 3).clear();
            case "Weekly" -> quests.subList(3, 6).clear();
        }
    }

    private Quest generateRandomQuest(String typeOfQuest, String topic) {
        int difficulty = createDifficulty();
        int amount = calculateAmount(typeOfQuest, topic, difficulty);
        return new Quest(typeOfQuest, topic, createDescription(topic, amount), difficulty, calculateXpGain(typeOfQuest,difficulty-1), amount);
    }

    private String createDescription(String topic, int amount){
        String text = "No description found...";
        switch (topic) {
            case "Clock"     -> text = "Study for a total of " + formatAmountToTime(amount);
            case "Flashcard" -> text = "Complete " + amount + " correct flashcards";
            case "Level"     -> text = "Level up " + amount + formatAmountToLevel(amount);
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

    private String formatAmountToLevel(int amount){
        if (amount == 1) return " level";
        return " levels";
    }

    private int createDifficulty() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    private int calculateXpGain(String typeOfQuest,int difficulty) {
        final double XPFACTOR = 1.2;
        double xpWithDecimals = Math.pow(XPFACTOR, difficulty) * 10;
        int xp = Math.toIntExact(Math.round(xpWithDecimals));
        if (Objects.equals(typeOfQuest, "Weekly")) xp *= 5;
        return xp;
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
