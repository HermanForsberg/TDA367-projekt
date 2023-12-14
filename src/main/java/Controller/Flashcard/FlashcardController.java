package Controller.Flashcard;
import Model.Flashcards.Flashcard;

import javax.swing.*;

public class FlashcardController extends JButton implements WrongButtonListener, CorrectButtonListener{

    private Flashcard flashcard;

    public FlashcardController(Flashcard card){

        flashcard = card;

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

    @Override
    public void onWrongClicked(int i) {
        flashcard.setAnswer(i);
    }


    @Override
    public void onCorrectClicked(int i) {
        flashcard.setAnswer(i);
    }


}
