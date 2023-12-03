package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Profile {

    private String name;

    private ArrayList<FlashcardDeck> decks;

    private State state = State.NO_STATE;

    public static final String STATE_PROP_NAME = "State";

    private float exp;

    private FlashcardFeature flashcardFeature;
    private TimerFeature timerFeature;

    private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);

    private String path = "";

    private StatisticModel statisticModel;

    private FlashcardDeck newestDeck;


    public Profile(String name){

        this.name = name;
        this.decks = new ArrayList<FlashcardDeck>();
        this.init();
    }

    public void setStatisticModel(StatisticModel statisticModel) {
        this.statisticModel = statisticModel;
    }

    public String getPath(){
        return this.path;
    }
    public ArrayList<FlashcardDeck> getListOfDecks(){
       return decks;
    }


    public String getName(){
        return name;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);

        System.out.println(listener);
    }

    public void setState(State state) {
        State oldState = this.state;
        this.state = state;
        // notify all listeners that the state property has changed

        pcSupport.firePropertyChange(STATE_PROP_NAME, oldState, state);

    }



    private void parseLine(String line) {
        String[] tokens = line.split(";");
        try {
            FlashcardDeck c = new FlashcardDeck(tokens[0]);
            for (int i = 1; i < tokens.length - 1; i = i + 2) {
                c.addFlashcard(new Flashcard(tokens[i], tokens[i + 1]));
            }
            this.decks.add(c);
        }
        catch(Exception e){

        }
        /*catch(Exception var){
            System.out.println("DAT215 lab 1 Model, invalid data line: " + line);
        }*/

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

    public ArrayList<FlashcardDeck> GetListOfDecks(){
        return decks;
    }

    public void deleteDeck(FlashcardDeck deck){
        decks.remove(deck);
    }

    public FlashcardDeck getNewestDeck(){
        return newestDeck;
    }

    public void addNewDeck(String name){
        FlashcardDeck newDeck = new FlashcardDeck(name);
        decks.add(newDeck);
        newestDeck = newDeck;
        //newestDeck.addFlashcard(new Flashcard("deez", "nuts"));
    }

    public void saveData() {
        this.path = getPath();
        this.decks = getListOfDecks();

        System.out.println(getPath());
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

    private void init() {
        this.path = System.getProperty("user.home") + File.separatorChar + "." + getName();

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

    }

}
