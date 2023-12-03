package Model;

import javax.swing.*;
import java.util.ArrayList;

public class FlashcardFeature{

    private ArrayList<FlashcardDeck> ListOfDecks = new ArrayList<FlashcardDeck>();

    private Profile currentProfile;

    public FlashcardFeature(Profile currentProfile){
        this.currentProfile = currentProfile;
    }



    public void deleteDeck(FlashcardDeck deck){
        ListOfDecks.remove(deck);
    }

    public void addNewDeck(String name){
        FlashcardDeck newDeck = new FlashcardDeck(name);

        ListOfDecks.add(newDeck);

        //newestDeck.addFlashcard(new Flashcard("deez", "nuts"));
    }

    public ArrayList<FlashcardDeck> GetListOfDecks(){
        return ListOfDecks;
    }

    public FlashcardDeck getNewestDeck(){
        return currentProfile.getNewestDeck();
    }
}
