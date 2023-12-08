import javax.swing.*;

import Controller.Clock.ClockController;
import Controller.Clock.ClockFeatureController;
import Controller.Flashcard.DeckCollectionController;
import Controller.Flashcard.DeckController;
import Controller.Flashcard.FlashcardController;
import Model.*;
import Controller.*;
import Model.Clock.*;
import View.*;
import Windows.DeckCollectionWindow;
import Windows.FlashcardFeatureWindows;
import Windows.FlashcardWindow;
import Model.CurrentView;
import Windows.Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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



        //DeckController deckController = new DeckController();



        DeckCollectionController deckCollectionController = new DeckCollectionController(model.getCurrentProfile());
        ClockFeatureController clockFeatureController = new ClockFeatureController(model.getClockFeature());

        ProfileFeatureController profileFeatureController = new ProfileFeatureController(model);




        HashMap<String,Window> views = new HashMap<>();


        CurrentView currentView = new CurrentView();

        CurrentViewController currentViewController = new CurrentViewController(currentView);

        DeckCollectionWindow deckCollectionWindow = new DeckCollectionWindow(model.getCurrentProfile(),deckCollectionController, currentViewController);

        views.put("deckCollection",deckCollectionWindow);

        FlashcardFeatureWindows flashcardFeatureWindows = new FlashcardFeatureWindows();

        views.put("flashcardFeature",flashcardFeatureWindows);

        FlashcardWindow flashcardWindow = new FlashcardWindow();

        views.put("flashcardWindow",flashcardWindow);




        MvcControl control = new MvcControl(model);

        //TODO Lösa observer på bra sätt

        for (ClockController clockController : control.getClockControllers()) {
            watch.addObserver(clockController);
        }

        watch.start();



        MvcView view = new MvcView(currentView, views);

        view.setGuiControl(control);
        MvcMenu menu = new MvcMenu(currentViewController);


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
