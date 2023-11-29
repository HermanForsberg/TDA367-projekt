import javax.swing.*;
import Model.*;
import Controller.*;
import Model.Timer;
import View.*;

import java.util.ArrayList;

public class SwingMvcTest {

    private static void createAndShowUI() {

        //Stats
        StatisticModel statisticModel = new StatisticModel();
        StatFeature statFeature = new StatFeature(statisticModel);

        //Timer
        Timer timer1 = new Timer(20);
        ArrayList<Timer> timersList = new ArrayList<>();
        timersList.add(timer1);
        TimerFeature timerFeature = new TimerFeature(timersList);

        //Flashcards
        ArrayList<FlashcardDeck> deckList = new ArrayList<>();
        FlashcardFeature flashcardFeature = new FlashcardFeature(deckList);

        //Profile
        Profile currentProfile = new Profile();
        currentProfile.setStatisticModel(statisticModel);

        //Main Model
        MvcModel model = MvcModel.getInstance();
        model.setProfile(currentProfile);
        model.setFlashcardFeature(flashcardFeature);
        model.setTimerFeature(timerFeature);




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

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                MvcModel.getInstance().saveData();
            }
        }));
    }
}
