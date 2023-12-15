package Model.Quests;

import Controller.Observer;
import Model.Observable;

import java.io.Serializable;

public class Quest implements Observer, Serializable, Observable {
    private final String typeOfQuest;
    private final String topic;
    private final String description;
    private final int expGain;
    private final int difficulty;
    private final float amount;
    private float progress;
    private boolean isCompleted;

    public Quest(String typeOfQuest, String topic, String description, int difficulty, int expGain, int amount) {
        this.typeOfQuest = typeOfQuest;
        this.topic = topic;
        this.description = description;
        this.difficulty = difficulty;
        this.expGain = expGain;
        this.amount = amount;
        this.progress = 0;
        this.isCompleted = false;
    }

    public void updateProgress(float currentAmount) {

        progress = currentAmount/amount * 100;

        System.out.println(progress + "Progress");

        if (progress >= 100 && !isCompleted){
            isCompleted = true;
            //Skicka xp.
        }
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public int getXpGain() {
        return expGain;
    }

    public float getProgress() {
        return progress;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public void update() {
        //updateProgress();
    }

    @Override
    public void addObserver(Observer observer) {
        //observerHandler.addObserver(observer);
    }
}
