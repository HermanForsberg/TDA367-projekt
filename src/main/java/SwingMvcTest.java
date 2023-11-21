import javax.swing.*;
import Model.*;
import Controller.*;
import Model.Timer;

import View.*;


import java.util.ArrayList;
import java.util.HashMap;

public class SwingMvcTest {

    private static void createAndShowUI() {

        Timer timer1 = new Timer(20);

        ArrayList<Timer> timersList = new ArrayList<>();
        timersList.add(timer1);

        TimerFeature timerFeature = new TimerFeature(timersList);


        Flashcard flashcard1 = new Flashcard("Question", "Answer");
        Flashcard flashcard2 = new Flashcard("Kvestion", "Önser");

        FlashcardDeck deck = new FlashcardDeck("TestDeck");

        deck.getDeck().add(flashcard1);
        deck.getDeck().add(flashcard2);

        FlashcardFeature flashcardFeature = new FlashcardFeature(deck);



        MvcModel model = new MvcModel(flashcardFeature, timerFeature);

        MvcControl control = new MvcControl(model);


        DrawPanel mainPanel = new DrawPanel(control);


        MvcView view = new MvcView(model, mainPanel);

        view.setGuiControl(control);
        MvcMenu menu = new MvcMenu(control);


        JFrame frame = new JFrame("Plugg");
        frame.setSize(800,600);
        frame.getContentPane().add(view.getMainPanel());

        frame.setJMenuBar(menu.getMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}
