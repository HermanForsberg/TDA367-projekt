import Model.Flashcards.Flashcard;
import Model.Profile;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import Model.Flashcards.FlashcardDeck;

public class FlashcardDeckTest {
    @Test
    public void flashcardDeck_size_should_be_zero_in_new_deck(){
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        assertEquals(0, deck.getSize());
    }

    @Test
    public void flashcardDeck_size_should_be_one_after_addCard(){
        Flashcard flashcard = new Flashcard("test", "test");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        assertEquals(1, deck.getSize());
    }

    @Test
    public void flashcardDeck_size_should_be_zero_after_deleteCard(){
        Flashcard flashcard = new Flashcard("test", "test");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        deck.delete(flashcard);
        assertEquals(0, deck.getSize());
    }

    @Test
    public void flashcardDeck_index_should_be_zero_after_shuffleDeck(){
        Flashcard flashcard = new Flashcard("test", "test");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        deck.shuffleDeck();
        assertEquals(0, deck.getCurrentIndex());
    }

    @Test
    public void flashcardDeck_numberOfCorrect_should_be_zero_when_creating_a_new_deck(){
        Flashcard flashcard = new Flashcard("test", "test");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        assertEquals(0, deck.getNumberOfCorrect());
    }

    @Test
    public void flashcardDeck_numberOfCorrect_should_be_two_after_two_correct_answers(){
        Flashcard flashcard = new Flashcard("test", "test");
        Flashcard flashcard1 = new Flashcard("test1", "test1");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        deck.addFlashcard(flashcard1);
        flashcard.setAnswer(Flashcard.correct);
        flashcard1.setAnswer(Flashcard.correct);
        assertEquals(2, deck.getNumberOfCorrect());
    }
    @Test
    public void flashcardDeck_numberOfCorrect_should_be_one_after_one_correct_and_one_wrong_answer(){
        Flashcard flashcard = new Flashcard("test", "test");
        Flashcard flashcard1 = new Flashcard("test1", "test1");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        deck.addFlashcard(flashcard1);
        flashcard.setAnswer(Flashcard.correct);
        flashcard1.setAnswer(Flashcard.wrong);
        assertEquals(1, deck.getNumberOfCorrect());
    }

    @Test
    public void flashcardDeck_numberOfCorrect_should_be_zero_after_wrong_answers(){
        Flashcard flashcard = new Flashcard("test", "test");
        Flashcard flashcard1 = new Flashcard("test1", "test1");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        deck.addFlashcard(flashcard1);
        flashcard.setAnswer(Flashcard.wrong);
        flashcard1.setAnswer(Flashcard.wrong);
        assertEquals(0, deck.getNumberOfCorrect());
    }

    @Test
    public void flashcardDeck_numberOfCorrect_should_be_zero_after_resetAnswers(){
        Flashcard flashcard = new Flashcard("test", "test");
        Flashcard flashcard1 = new Flashcard("test1", "test1");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        deck.addFlashcard(flashcard1);
        flashcard.setAnswer(Flashcard.correct);
        flashcard1.setAnswer(Flashcard.correct);
        deck.resetAnswers();
        assertEquals(0, deck.getNumberOfCorrect());
    }

    @Test
    public void flashcardDeck_currentFlashCard_should_be_the_first_flashcard_added(){
        Flashcard flashcard = new Flashcard("test", "test");
        Flashcard flashcard1 = new Flashcard("test1", "test1");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        deck.addFlashcard(flashcard1);
        assertEquals(flashcard, deck.getCurrentFlashcard());
    }
    @Test
    public void flashcardDeck_currentFlashCard_should_be_the_second_after_index_incremented(){
        Flashcard flashcard = new Flashcard("test", "test");
        Flashcard flashcard1 = new Flashcard("test1", "test1");
        Profile profile = new Profile("testProfile");
        FlashcardDeck deck = new FlashcardDeck("testDeck", profile);
        deck.addFlashcard(flashcard);
        deck.addFlashcard(flashcard1);
        deck.incrementCurrentIndex();
        assertEquals(flashcard1, deck.getCurrentFlashcard());
    }





}
