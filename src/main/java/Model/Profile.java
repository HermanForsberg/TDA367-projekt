package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Profile implements Mediator{

    private String name;

    private ArrayList<FlashcardDeck> decks;

    private int exp;

    private String path = "";

    private StatisticModel statisticModel;

    private FlashcardDeck newestDeck;

    public Profile(String name){
        this.name = name;
        this.exp = 0;
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

    public void addExp(int expGain){
        exp += expGain;
    }



    public String getName(){
        return name;
    }


    public void deleteDeck(FlashcardDeck deck){
        decks.remove(deck);
    }

    public FlashcardDeck getNewestDeck(){
        return newestDeck;
    }

    public void addNewDeck(String name){
        FlashcardDeck newDeck = new FlashcardDeck(name, this);
        decks.add(newDeck);
        newestDeck = newDeck;
        //newestDeck.addFlashcard(new Flashcard("deez", "nuts"));
    }






    private void parseLine(String line) {
        String[] tokens = line.split(";");
        try {
            FlashcardDeck c = new FlashcardDeck(tokens[0], this);
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


    public void saveData() {
        this.path = getPath();
        this.decks = getListOfDecks();

        System.out.println(getPath());
        try {
            FileOutputStream fos = new FileOutputStream(this.path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "ISO-8859-1");
            Iterator<FlashcardDeck> var3 = this.decks.iterator();

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

        this.path = this.path  + File.separatorChar  + getName();

        try {
            contactsData = new File(this.path);
            if (!contactsData.exists()) {
                contactsData.mkdir();
            }
        } catch (Exception var2) {
            System.out.println("Model creating save directory: " + var2);
        }

        this.path = this.path + File.separatorChar + "decks.txt";
        contactsData = new File(this.path);
        if (contactsData.exists()) {
            this.loadData();
        } else {
            //this.contacts.add(new Contact());
        }

    }

    @Override
    public void notified(String name) {
        if(Objects.equals(name, "clock")){
            addExp(1);
            System.out.println(getName() + " " + exp);
        }else if(Objects.equals(name, "flashcard")){
            addExp(1);
            System.out.println(getName() + " " + exp);
        }
    }
}
