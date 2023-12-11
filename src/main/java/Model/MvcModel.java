package Model;

import Model.Clock.*;
import Controller.ObserverHandler;
import Controller.Observer;
import Model.Quests.QuestFeature;

import java.beans.*;

import java.io.*;
import java.util.ArrayList;



public class MvcModel {

    private static MvcModel instance = null;

    private String path = "";


    private ArrayList<FlashcardDeck> decks = new ArrayList();


    private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);




    private ClockFeature clockFeature;

    private QuestFeature questFeature;

    private ArrayList<Profile> listOfProfiles = new ArrayList<>();

    private ObserverHandler observerHandler = new ObserverHandler();

    private Profile currentProfile;

    public static MvcModel getInstance() {
        if (instance == null) {
            instance = new MvcModel();

        }

        return instance;
    }

    public MvcModel(){
        init();
        initClock();
        initQuests();
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
        setCurrentProfile(listOfProfiles.get(0));}
        catch(Exception e){
            setCurrentProfile(new Profile("TemporaryProfile"));
        }

    }

    public void initClock(){
        Clock manualTimer = new ManualTimer(currentProfile);
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



    //saveData ska definitivt vara private
    /*public void saveData() {
        this.decks = flashcardFeature.GetListOfDecks();
        try {
            FileOutputStream fos = new FileOutputStream(this.path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "ISO-8859-1");
            Iterator var3 = this.decks.iterator();

            while(var3.hasNext()) {
                FlashcardDeck c = (FlashcardDeck) var3.next();
                String line = c.getDeckName() +";";
                for (Flashcard card: c.getDeck()){
                    line = line + card.getQuestion() + ";" + card.getSolution() + ";";
                }
                line = line + "\n";
                //String line = c.getFirstName() + ";" + c.getLastName() + ";" + c.getPhone() + ";" + c.getEmail() + ";" + c.getAddress() + ";" + c.getPostCode() + ";" + c.getPostAddress() + ";" + "end\n";
                osw.write(line);
            }

            osw.flush();
            osw.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    private void parseLine(String line) {
        String[] tokens = line.split(";");

        FlashcardDeck c = new FlashcardDeck(tokens[0]);
        for (int i = 1; i < tokens.length-1; i=i+2){
            c.addFlashcard(new Flashcard(tokens[i],tokens[i+1]));
        }
        this.decks.add(c);
        /*catch(Exception var){
            System.out.println("DAT215 lab 1 Model, invalid data line: " + line);
        }*/

        //System.out.println("DAT215 lab 1 Model, invalid data line: " + line);
    /*}

    /*private void loadData() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.path), "ISO-8859-1"));

            String line;
            while((line = reader.readLine()) != null) {
                this.parseLine(line);
            }

            reader.close();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    /*private void init() {
        this.path = System.getProperty("user.home") + File.separatorChar + ".plugg";

        File contactsData;
        try {
            contactsData = new File(this.path);
            if (!contactsData.exists()) {
                contactsData.mkdir();
            }
        } catch (Exception var2) {
            System.out.println("Model creating save directory: " + var2);
        }

        this.path = this.path + File.separatorChar + "plugg.txt";
        contactsData = new File(this.path);
        if (contactsData.exists()) {
            this.loadData();
        } else {
            //this.contacts.add(new Contact());
        }

    }*/

    }
}
