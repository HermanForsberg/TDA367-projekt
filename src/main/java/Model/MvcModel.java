package Model;

import Model.Clock.*;
import Controller.ObserverHandler;
import Controller.Observer;
import Model.Flashcards.FlashcardDeck;
import Model.Quests.QuestFeature;

import java.beans.*;

import java.io.*;
import java.util.ArrayList;



public class MvcModel implements Observable{

    private static MvcModel instance = null;

    private String path = "";

    private ArrayList<FlashcardDeck> decks = new ArrayList();

    private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);

    private ClockFeature clockFeature;

    private QuestFeature questFeature;

    private ArrayList<Profile> listOfProfiles = new ArrayList<>();

    private ObserverHandler observerHandler = new ObserverHandler();

    private Profile currentProfile;

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


    //Vet inte om det ska sparas såhär, men det fungerar atleast
    public void init(){

        this.path = System.getProperty("user.home") + File.separatorChar + "ProfilesForStudyApp";
        File contactsData;

        try {
            contactsData = new File(this.path);
            //System.out.println(contactsData.listFiles());
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
        try{
            setCurrentProfile(listOfProfiles.get(0));
        }
        catch(Exception e){
            setCurrentProfile(new Profile("TemporaryProfile"));
        }
    }

    public void initClock(){
        Clock manualTimer = new ManualTimer(currentProfile);
        Clock stopwatch = new Stopwatch(currentProfile);
        Clock pomodoro = new Pomodoro(currentProfile);

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

    public void setProfileList(ArrayList<Profile> listOfProf){
        listOfProfiles = listOfProf;
    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }

    public void setCurrentProfile(Profile newProfile){
        currentProfile = newProfile;
    }

    public ArrayList<Profile> getProfiles(){
        return listOfProfiles;
    }


    public Profile getCurrentProfile(){
        return currentProfile;
    }
    public void switchProfile(Profile profile){

        currentProfile=profile;
        initClock();
        observerHandler.updateObservers();
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

    // allow addition of listeners or observers
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);
    }
}
