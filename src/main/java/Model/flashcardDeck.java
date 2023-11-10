package Model;

import java.util.*;

public class flashcardDeck {
    private Set<flashcard> deck;
    private String deckName;
    private int size;

    public flashcardDeck(String deckName) {
        this.deck = new HashSet<flashcard>();
        this.deckName = deckName;
        this.size = 0;
    }

    public boolean addFlashcard(flashcard flash){
        boolean added = this.deck.add(flash);
        if(added){
            this.size ++;
        }
        return added;
    }

    public boolean delete(flashcard flash){
        boolean deleted = this.deck.remove(flash);
        if(deleted){
            this.size --;
        }
        return deleted;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public Set<flashcard> getDeck() {
        return deck;
    }

    public String getDeckName() {
        return deckName;
    }

    public int getSize() {
        return size;
    }
}
