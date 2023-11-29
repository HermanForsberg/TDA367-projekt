package Model;

import java.io.*;
import java.util.ArrayList;

public class Profile {

    private String name;

    private ArrayList<FlashcardDeck> decks;

    private float exp;

    private FlashcardFeature flashcardFeature;
    private TimerFeature timerFeature;

    private final String DIRECTORY = ".plugg";
    private final String FILE_NAME = "plugg.txt";
    private final String SPLIT = ";";
    private String path = "";

    private StatisticModel statisticModel;


    public Profile(){

        this.name = "temp";
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

    }

}
