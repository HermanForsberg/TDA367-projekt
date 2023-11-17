package Controller;

import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckButtonController extends JButton {

    public DeckButtonController(FlashcardDeck model){
        setText(model.getDeckName());


    }



}
