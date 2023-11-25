import javax.swing.*;
import Model.*;
import Controller.*;
import Model.Timer;
import View.*;

import java.util.ArrayList;

public class SwingMvcTest {

    private static void createAndShowUI() {
        //Clock
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
        //Flashcard
        Flashcard flashcard1 = new Flashcard("Swag2", "Gamer2");
        Flashcard flashcard2 = new Flashcard("Swag", "Gamer");

        FlashcardDeck deck = new FlashcardDeck("TestDeck");
        FlashcardDeck deck2 = new FlashcardDeck("Testdeck2");

        ArrayList<FlashcardDeck> deckList = new ArrayList<>();
        deckList.add(deck);
        deckList.add(deck2);

        deck.getDeck().add(flashcard1);
        deck.getDeck().add(flashcard2);

        deck2.getDeck().add(flashcard1);
        deck2.getDeck().add(flashcard2);

        FlashcardFeature flashcardFeature = new FlashcardFeature(deckList);



        MvcModel model = new MvcModel(flashcardFeature, clockFeature);

        MvcControl control = new MvcControl(model);

        //TODO Lösa observer på bra sätt

        watch.addObserver(control.getTimer());

        watch.start();


        //HashMap<String ,JPanel> views = new HashMap<>();







        //gör hashmaps för decks också kanske och skicka med mapen till flashcardfeaturegui?
/*
        flashcardDeckguiTest deckView = new flashcardDeckguiTest(deck);
        DeckController deckController = new DeckController(deck);
        deckView.setDeckController(deckController);


        Timer timer = new Timer(20);
        TimerController timerController = new TimerController(timer);
        TimerGUI timerGUI = new TimerGUI(timer, timerController);



        FlashcardFeatureController flashcardFeatureController = new FlashcardFeatureController(flashcardFeature);
        FlashcardFeatureGui flashcardFeatureGui = new FlashcardFeatureGui(flashcardFeature, deckView);
        flashcardFeatureGui.setController(flashcardFeatureController);

*/
        //views.put("Flashcards", flashcardFeature);
        //views.put("Timers", timerFeature);
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
    }
}
