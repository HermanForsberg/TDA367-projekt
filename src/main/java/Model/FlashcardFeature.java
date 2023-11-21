package Model;

import javax.swing.*;
import java.util.ArrayList;

public class FlashcardFeature extends JPanel {

    private ArrayList<FlashcardDeck> ListOfDecks = new ArrayList<FlashcardDeck>();

    private FlashcardDeck newestDeck;

    public FlashcardFeature(FlashcardDeck deck){
        ListOfDecks.add(deck);
    }



    public void addClicked(String name){
        FlashcardDeck newDeck = new FlashcardDeck(name);

        ListOfDecks.add(newDeck);
        newestDeck = newDeck;
        newestDeck.addFlashcard(new Flashcard("deez", "nuts"));
    }

    public ArrayList<FlashcardDeck> GetListOfDecks(){
        return ListOfDecks;
    }

    public FlashcardDeck getNewestDeck(){
        return newestDeck;
    }
}
