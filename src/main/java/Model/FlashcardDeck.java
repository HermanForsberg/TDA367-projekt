package Model;

import java.util.*;

public class FlashcardDeck {
    private Set<Flashcard> deck;
    private String deckName;
    private int size;

    public FlashcardDeck(String deckName) {
        this.deck = new HashSet<Flashcard>();
        this.deckName = deckName;
        this.size = 0;
    }

    public boolean addFlashcard(Flashcard flash){
        boolean added = this.deck.add(flash);
        if(added){
            this.size ++;
        }
        return added;
    }

    public boolean delete(Flashcard flash){
        boolean deleted = this.deck.remove(flash);
        if(deleted){
            this.size --;
        }
        return deleted;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public Set<Flashcard> getDeck() {
        return deck;
    }

    public String getDeckName() {
        return deckName;
    }

    public int getSize() {
        return size;
    }
}
