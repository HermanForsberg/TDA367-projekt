package Model;

import java.util.ArrayList;

public class FlashcardFeature {

    private ArrayList<FlashcardDeck> ListOfDecks = new ArrayList<FlashcardDeck>();

    private FlashcardDeck newestDeck;

    public FlashcardFeature(FlashcardDeck deck){
        ListOfDecks.add(deck);


    }

    public void addClicked(String name){
        FlashcardDeck newDeck = new FlashcardDeck(name);

        ListOfDecks.add(newDeck);
        newestDeck = newDeck;
    }

    public ArrayList<FlashcardDeck> GetListOfDecks(){
        return ListOfDecks;
    }

    public FlashcardDeck getNewestDeck(){
        return newestDeck;
    }
}
