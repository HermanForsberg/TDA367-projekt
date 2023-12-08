package Model.Quests;

import java.util.Random;
import java.lang.Math;

public class Quest {
    private String topic;
    private String description;
    private int xpGain;
    private int difficulty;
    private int amount;
    private int progress;
    private boolean isCompleted;

    public Quest(String topic, String description, int difficulty, int xpGain, int amount) {
        this.topic = topic;
        this.description = description;
        this.difficulty = difficulty;
        this.xpGain = xpGain;
        this.amount = amount;
        this.progress = 0;
        this.isCompleted = false;
    }

    //5st static, varningsflagga??
    //Vart ska denna ligga??
    public static Quest generateRandomQuest(String topic) {
        int difficulty = createDifficulty();
        int amount = calculateAmount(topic, difficulty);
        return new Quest(topic, createDescription(topic, amount), difficulty, calculateXpGain(difficulty-1), amount);
    }

    private static String createDescription(String topic, int amount){
        String text = "No description found...";
        switch (topic) {
            case "Clock"     -> text = "Study for a total of " + amount + " minutes.";
            case "Flashcard" -> text = "Complete " + amount + " of flashcards.";
            case "Level"     -> text = "Level up " + amount + " level(s)";
        }
        return text;
    }

    private static int createDifficulty() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    private static int calculateXpGain(int difficulty) {
        final double XPFACTOR = 1.2;
        double xpWithDecimals = Math.pow(XPFACTOR, difficulty) * 10;
        return Math.toIntExact(Math.round(xpWithDecimals));             //Får man typecasta här?
    }

    private static int calculateAmount(String topic, int difficulty) {
        int amount = -1;
        switch (topic) {
            case "Clock"     -> amount = difficulty * 20 + 40;
            case "Flashcard" -> amount = difficulty * 10;
            case "Level"     -> amount = Math.max(difficulty / 3, 1);
        }
        return amount;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public int getXpGain() {
        return xpGain;
    }

    public int getProgress() {
        return progress;
    }
}
