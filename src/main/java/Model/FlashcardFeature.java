package Model;

import javax.swing.*;
import java.util.ArrayList;

public class FlashcardFeature{

    private ArrayList<FlashcardDeck> ListOfDecks = new ArrayList<FlashcardDeck>();

    private FlashcardDeck newestDeck;

    private Profile currentProfile;

    public FlashcardFeature(){

    }

    public void init(Profile profile){
        currentProfile = profile;

    }

    public void deleteDeck(FlashcardDeck deck){
        ListOfDecks.remove(deck);
    }

    public void addNewDeck(String name){
        FlashcardDeck newDeck = new FlashcardDeck(name);

        ListOfDecks.add(newDeck);
        newestDeck = newDeck;
        //newestDeck.addFlashcard(new Flashcard("deez", "nuts"));
    }

    public ArrayList<FlashcardDeck> GetListOfDecks(){
        return ListOfDecks;
    }

    public FlashcardDeck getNewestDeck(){
        return newestDeck;
    }
}
