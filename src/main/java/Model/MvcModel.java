package Model;

import Model.Clock.ClockFeature;
import Controller.ObserverHandler;
import Controller.Observer;

import java.beans.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MvcModel {

    private static MvcModel instance = null;

    private String path = "";


    private ArrayList<FlashcardDeck> decks = new ArrayList();


    private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);


    private ClockFeature clockFeature;

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

    public ClockFeature getClockFeature(){
        return this.clockFeature;
    }


}
