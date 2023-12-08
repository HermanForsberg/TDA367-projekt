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



        //Profile
        ArrayList<Profile> profileList = new ArrayList<>();
        //Profile currentProfile = new Profile("Profile1");
        //Profile currentProfile2 = new Profile("Profile2");
        //profileList.add(currentProfile);
        //profileList.add(currentProfile2);
        //currentProfile.setStatisticModel(statisticModel);


        //Main model
        MvcModel model = MvcModel.getInstance();
        //model.setProfileList(profileList);
        model.setClockFeature(clockFeature);
        //model.setCurrentProfile(currentProfile);
        model.setQuestFeature(questFeature);

        MvcControl control = new MvcControl(model);

        //TODO Lösa observer på bra sätt

        for (ClockController clockController : control.getClockControllers()) {
            watch.addObserver(clockController);
        }

        watch.start();


        MvcView view = new MvcView(model);

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
