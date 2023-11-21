import javax.swing.*;
import Model.*;
import Controller.*;
import Model.Timer;
import View.TimerGUI;
import View.*;
import View.flashcardDeckguiTest;

import java.util.HashMap;

public class SwingMvcTest {
    private static void createAndShowUI() {

        HashMap<String ,FramesWithGet> views = new HashMap<>();

        MvcModel model = new MvcModel();


        MvcControl control = new MvcControl(model);

        //gör hashmaps för decks också kanske och skicka med mapen till flashcardfeaturegui?
        FlashcardDeck deck = new FlashcardDeck("TestDeck");
        flashcardDeckguiTest deckView = new flashcardDeckguiTest(deck);
        DeckController deckController = new DeckController(deck);
        deckView.setDeckController(deckController);


        Timer timer = new Timer(20);
        TimerController timerController = new TimerController(timer);
        TimerGUI timerGUI = new TimerGUI(timer, timerController);


        FlashcardFeature flashcardFeature = new FlashcardFeature(deck);
        FlashcardFeatureController flashcardFeatureController = new FlashcardFeatureController(flashcardFeature);
        FlashcardFeatureGui flashcardFeatureGui = new FlashcardFeatureGui(flashcardFeature, deckView);
        flashcardFeatureGui.setController(flashcardFeatureController);


        views.put("Flashcard", flashcardFeatureGui);
        views.put("Timer", timerGUI);
        DrawPanel mainPanel = new DrawPanel(views);


        MvcView view = new MvcView(model, mainPanel);

        view.setGuiControl(control);
        MvcMenu menu = new MvcMenu(control);


        JFrame frame = new JFrame("Plugg");
        frame.setSize(500,500);
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
