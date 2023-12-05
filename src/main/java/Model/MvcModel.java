package Model;

import Controller.Observer;
import Controller.ObserverHandler;

import java.beans.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;


public class MvcModel {

    private Profile oldProfile;


    public static final String CSTATE_PROP_NAME = "CurrentProfileState";



    private static MvcModel instance = null;


    private String path = "";

    private Profile currentProfile;

    private ArrayList<FlashcardDeck> decks = new ArrayList();

    public static final String STATE_PROP_NAME = "State";


    private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);
    private State state = State.NO_STATE;

    private FlashcardFeature flashcardFeature;

    private TimerFeature timerFeature;

    private ArrayList<Profile> listOfProfiles;

    private ObserverHandler observerHandler = new ObserverHandler();

    public static MvcModel getInstance() {
        if (instance == null) {
            instance = new MvcModel();

        }

        return instance;
    }

    public MvcModel(){

    }

    public void addObserver(Observer observer){
        observerHandler.addObserver(observer);
    }

    public ArrayList<Profile> getProfiles(){
        return listOfProfiles;
    }

    public void saveDataForCurrentProfile(){
        currentProfile.saveData();
    }

    public void switchProfile(Profile profile){

        currentProfile=profile;

        observerHandler.updateObservers();

        //profileSupport.firePropertyChange(CSTATE_PROP_NAME, oldState, state);

    }

    public void setFlashcardFeature(FlashcardFeature flashcardFeature){
        this.flashcardFeature = flashcardFeature;
        flashcardFeature.init(currentProfile);
    }

    public void setTimerFeature(TimerFeature timerFeature){
        this.timerFeature = timerFeature;
    }

    public void setProfile(Profile profile){
        this.currentProfile= profile;
    };
    public FlashcardFeature getFlashcardFeature(){
        return this.flashcardFeature;
    }

    public TimerFeature getTimerFeature(){
        return this.timerFeature;
    }

    public void setProfileList(ArrayList<Profile> list){
        listOfProfiles = list;
    }

    public void setCurrentProfile(Profile newProfile){
        currentProfile = newProfile;
    }

    public void setState(State state) {
        State oldState = this.state;
        this.state = state;
        // notify all listeners that the state property has changed

        pcSupport.firePropertyChange(STATE_PROP_NAME, oldState, state);

    }


    public State getState() {
        return state;
    }

    public String getStateText() {
        return state.getText();
    }

    // allow addition of listeners or observers
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);

        System.out.println(listener);
    }






    //Vet inte om detta skall ligga i MVCModel
    //saveData ska definitivt vara private


    public Profile getCurrentProfile(){
        return currentProfile;
    }

    /*private void parseLine(String line) {
        String[] tokens = line.split(";");

        FlashcardDeck c = new FlashcardDeck(tokens[0]);
        for (int i = 1; i < tokens.length-1; i=i+2){
            c.addFlashcard(new Flashcard(tokens[i],tokens[i+1]));
        }
        this.decks.add(c);
        /*catch(Exception var){
            System.out.println("DAT215 lab 1 Model, invalid data line: " + line);
        }

        //System.out.println("DAT215 lab 1 Model, invalid data line: " + line);
    }

    private void loadData() {
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

    private void init() {
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
