import javax.swing.*;

import Controller.Clock.ClockController;
import Model.*;
import Controller.*;
import Model.Clock.*;
import Model.Quests.QuestFactory;
import Model.Quests.QuestFeature;
import View.*;

import java.util.ArrayList;

public class SwingMvcTest {

    private static void createAndShowUI() {
        //Controller.Clock
        Clock manualTimer = new ManualTimer();
        Clock stopwatch = new Stopwatch();
        Clock pomodoro = new Pomodoro();

        ArrayList<Clock> clockList = new ArrayList<>();
        clockList.add(manualTimer);
        clockList.add(stopwatch);
        clockList.add(pomodoro);

        ClockFeature clockFeature = new ClockFeature(clockList);

        Watch watch = new Watch();

        for (Clock clock : clockList) {
            watch.addObserver(clock);
        }

        //Daily Quests
        QuestFeature questFeature = new QuestFeature();

        //Flashcard

        //FlashcardDeck deck = new FlashcardDeck("TestDeck");
        //FlashcardDeck deck2 = new FlashcardDeck("Testdeck2");

        ArrayList<FlashcardDeck> deckList = new ArrayList<>();
        //deckList.add(deck);
        //deckList.add(deck2);

        /*deck.addFlashcard(flashcard1);
        deck.addFlashcard(flashcard2);

        deck2.addFlashcard(flashcard1);
        deck2.addFlashcard(flashcard2);*/

        FlashcardFeature flashcardFeature = new FlashcardFeature(deckList);

        MvcModel model = MvcModel.getInstance();
        model.setFlashcardFeature(flashcardFeature);
        model.setClockFeature(clockFeature);
        model.setQuestFeature(questFeature);

        MvcControl control = new MvcControl(model);

        //TODO Lösa observer på bra sätt

        for (ClockController clockController : control.getClockControllers()) {
            watch.addObserver(clockController);
        }

        watch.start();


        DrawPanel mainPanel = new DrawPanel(control);


        MvcView view = new MvcView(model, mainPanel);

        view.setGuiControl(control);
        MvcMenu menu = new MvcMenu(control);


        JFrame frame = new JFrame("MyPlugg");
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

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                MvcModel.getInstance().saveData();
            }
        }));
    }
}
