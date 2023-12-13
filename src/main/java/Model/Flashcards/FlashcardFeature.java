package Model.Flashcards;

import javax.swing.*;
import java.util.ArrayList;

public class FlashcardFeature extends JPanel {

    private ArrayList<FlashcardDeck> ListOfDecks = new ArrayList<FlashcardDeck>();

    private FlashcardDeck newestDeck;

    public FlashcardFeature(ArrayList<FlashcardDeck> deck){
        ListOfDecks = deck;
    }

    public void init(ArrayList<FlashcardDeck> decks){
        for(FlashcardDeck deck: decks){
            ListOfDecks.add(deck);
        }
    }

    public void deleteDeck(FlashcardDeck deck){
        ListOfDecks.remove(deck);
    }

    /*
    public void addNewDeck(String name){
        FlashcardDeck newDeck = new FlashcardDeck(name);

        ListOfDecks.add(newDeck);
        newestDeck = newDeck;
        //newestDeck.addFlashcard(new Flashcard("deez", "nuts"));
    }*/

    public ArrayList<FlashcardDeck> GetListOfDecks(){
        return ListOfDecks;
    }

    public FlashcardDeck getNewestDeck(){
        return newestDeck;
    }
}
