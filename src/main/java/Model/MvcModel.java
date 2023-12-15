package Model;

import Model.Clock.*;
import Controller.ObserverHandler;
import Controller.Observer;
import Model.Quests.QuestFeature;

import java.io.*;
import java.util.ArrayList;



public class MvcModel implements Observable{
    private static MvcModel instance = null;

    private String path = "";
    private ClockFeature clockFeature;

    private QuestFeature questFeature;

    private ArrayList<Profile> listOfProfiles = new ArrayList<>();

    private ObserverHandler observerHandler = new ObserverHandler();



    private DayWeekTracker dayWeekTracker = new DayWeekTracker();

    public static MvcModel getInstance() {
        if (instance == null) {
            instance = new MvcModel();

        }

        return instance;
    }

    public MvcModel(){
        initQuests();
        init();
        initClock();
        dayWeekTracker.saveLastCheckedDate();
    }

    public void init(){

        this.path = System.getProperty("user.home") + File.separatorChar + "ProfilesForStudyApp";
        File contactsData;

        try {
            contactsData = new File(this.path);
            if (!contactsData.exists()) {
                contactsData.mkdir();
            }
        } catch (Exception var2) {
            System.out.println("Model creating save directory: " + var2);

        }

        File file = new File(this.path = System.getProperty("user.home") + File.separatorChar + "ProfilesForStudyApp");
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        for (String profil: directories){
            System.out.println(profil);
            listOfProfiles.add(new Profile(profil));
        }

    }
    public void initClock(){
        Clock manualTimer = new ManualTimer();
        Clock stopwatch = new Stopwatch();
        Clock pomodoro = new Pomodoro();

        ArrayList<Clock> clockList = new ArrayList<>();
        clockList.add(manualTimer);
        clockList.add(stopwatch);
        clockList.add(pomodoro);

        ClockFeature clockFeature = new ClockFeature(clockList);
        setClockFeature(clockFeature);
    }

    public void initQuests(){
        QuestFeature questFeature = new QuestFeature();
        setQuestFeature(questFeature);
    }

    public void addProfile(Profile profile){
        listOfProfiles.add(profile);
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }

    public ArrayList<Profile> getProfiles(){
        return listOfProfiles;
    }

    public void saveData(){
        for(Profile profile: listOfProfiles){
            profile.saveData();}
    }
    public void setClockFeature(ClockFeature clockFeature){
        this.clockFeature = clockFeature;
    }

    public void setQuestFeature(QuestFeature questFeature) {
        this.questFeature = questFeature;
    }

    public ClockFeature getClockFeature(){
        return this.clockFeature;
    }

    public QuestFeature getQuestFeature() {
        return questFeature;
    }



}
