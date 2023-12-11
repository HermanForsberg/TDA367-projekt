package Model.Quests;

import java.util.Random;
import java.lang.Math;

public class Quest {
    private String typeOfQuest;
    private String topic;
    private String description;
    private int xpGain;
    private int difficulty;
    private int amount;
    private int progress;
    private boolean isCompleted;

    public Quest(String typeOfQuest, String topic, String description, int difficulty, int xpGain, int amount) {
        this.typeOfQuest = typeOfQuest;
        this.topic = topic;
        this.description = description;
        this.difficulty = difficulty;
        this.xpGain = xpGain;
        this.amount = amount;
        this.progress = 0;
        this.isCompleted = false;
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

    public boolean isCompleted() {
        return isCompleted;
    }
}
