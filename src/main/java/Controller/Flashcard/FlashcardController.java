package Controller.Flashcard;
import Model.Flashcards.Flashcard;

import javax.swing.*;

public class FlashcardController extends JButton {

    private Flashcard flashcard;

    public FlashcardController(){

}
    public JButton get(){
        return this;

    }



    public void setCorrect(boolean bool){
        //flashcard.setCorrect(bool);
    }

    public void setQuestion(String question){
        flashcard.setQuestion(question);
    }

    public void setAnswer(String answer){
        flashcard.setSolution(answer);
    }
}
