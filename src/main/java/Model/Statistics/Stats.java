package Model.Statistics;

import Model.DayWeekTracker;

import java.util.ArrayList;

public class Stats {
    private int minutesPassed;
    private int flashcardsCompleted;
    private int levelsGained;
    private ArrayList<StatsDay> statsWeek;
    private DayWeekTracker dayWeekTracker;
    public Stats() {
        this.dayWeekTracker = new DayWeekTracker();

        //Lösa detta
        this.statsWeek = new ArrayList<>();
        this.minutesPassed = 0;
        this.flashcardsCompleted = 0;
        this.levelsGained = 0;
        //statsWeek.add(new StatsDay(dayWeekTracker.getDayToString()));
        updateStatsWeek();
    }

    private StatsDay getCurrentDay(){
        System.out.println(statsWeek);
        return statsWeek.get(statsWeek.size()-1);
    }

    public void addMinutesToCurrentDay(int minutes){
        getCurrentDay().addMinutes(minutes);
    }

    public void addFlashcardCompletedToCurrentDay(int flashcards){
        getCurrentDay().addFlashcardsCompleted(flashcards);
    }

    public void addLevelGainedToCurrentDay(int level){
        getCurrentDay().addLevelsGained(level);
    }

    private void updateStatsWeek() {
        if (!dayWeekTracker.lastDateFileExists()){
            statsWeek.add(new StatsDay(dayWeekTracker.getDayToString()));
        }
        else {
            if (dayWeekTracker.isNewWeek()) {
                statsWeek.clear();
            }
            if (dayWeekTracker.isNewDay()){
                statsWeek.add(new StatsDay(dayWeekTracker.getDayToString()));
            }
        }
    }

    private void calculateMinutesPassed(){
        for (StatsDay day : statsWeek){
            minutesPassed += day.getMinutesLapsed();
        }
    }
    private void calculateFlashcardsCompleted(){
        for (StatsDay day : statsWeek){
            flashcardsCompleted += day.getFlashcardsCompleted();
        }
    }
    private void calculateLevelsGained(){
        for (StatsDay day : statsWeek){
            levelsGained += day.getLevelsGained();
        }
    }

    public int getMinutesPassed() {
        return minutesPassed;
    }

    public int getFlashcardsCompleted() {
        return flashcardsCompleted;
    }

    public int getLevelsGained() {
        return levelsGained;
    }
    /*
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
    */
}
