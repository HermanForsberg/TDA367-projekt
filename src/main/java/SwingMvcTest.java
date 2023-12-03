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



        //Profile
        ArrayList<Profile> profileList = new ArrayList<>();
        Profile currentProfile = new Profile("Profile1");
        Profile currentProfile2 = new Profile("Profile2");
        profileList.add(currentProfile);
        profileList.add(currentProfile2);
        currentProfile.setStatisticModel(statisticModel);

        //Flashcards
        FlashcardFeature flashcardFeature = new FlashcardFeature();


        //Main Model
        MvcModel model = MvcModel.getInstance();
        model.setProfileList(profileList);
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
                MvcModel.getInstance().getCurrentProfile().saveData();
            }
        }));
    }
}
