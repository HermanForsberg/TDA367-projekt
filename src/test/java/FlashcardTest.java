import Model.Flashcards.Flashcard;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlashcardTest {
    @Test
    public void correct_answer_should_equal_to_zero(){
        Flashcard flashcard = new Flashcard("test","test");
        flashcard.setAnswer(Flashcard.correct);
        assertEquals(1, flashcard.getAnswer());
    }

    @Test
    public void wrong_answer_should_equal_to_0(){
        Flashcard flashcard = new Flashcard("test","test");
        flashcard.setAnswer(Flashcard.wrong);
        assertEquals(0, flashcard.getAnswer());
    }

    @Test
    public void reset_should_equal_to_minus_one(){
        Flashcard flashcard = new Flashcard("test","test");
        flashcard.setAnswer(Flashcard.reset);
        assertEquals(-1, flashcard.getAnswer());
    }

    @Test
    public void when_given_a_number_other_than_one_or_two_should_not_be_default_minus_one(){
        Flashcard flashcard = new Flashcard("test","test");
        flashcard.setAnswer(5);
        assertEquals(-1, flashcard.getAnswer());
    }
}
