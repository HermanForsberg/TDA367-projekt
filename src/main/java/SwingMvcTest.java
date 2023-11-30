import javax.swing.*;
import Model.*;
import Controller.*;
import Model.Timer;
import View.*;

import java.util.ArrayList;

public class SwingMvcTest {

    private static void createAndShowUI() {

        //TIMER_____________________
        Timer timer1 = new Timer(20);

        ArrayList<Timer> timersList = new ArrayList<>();
        timersList.add(timer1);

        TimerFeature timerFeature = new TimerFeature(timersList);

        //FLASHCARDS_____________________
        ArrayList<FlashcardDeck> deckList = new ArrayList<>();

        FlashcardFeature flashcardFeature = new FlashcardFeature(deckList);

        MvcModel model = MvcModel.getInstance();
        model.setFlashcardFeature(flashcardFeature);
        model.setTimerFeature(timerFeature);

        MvcControl control = new MvcControl(model);


        DrawPanel mainPanel = new DrawPanel(control);


        MvcView view = new MvcView(model, mainPanel);

        view.setGuiControl(control);
        MvcMenu menu = new MvcMenu(control);

        Updater updater = new Updater();
        updater.addObserver(control);
        updater.addObserver(control.getDeckCollection());

        JFrame frame = new JFrame("Plugg");
        frame.setSize(800,600);
        frame.getContentPane().add(view.getMainPanel());

        frame.setJMenuBar(menu.getMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
