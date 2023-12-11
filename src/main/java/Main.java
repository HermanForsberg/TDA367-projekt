import javax.swing.*;

import Controller.Clock.ClockController;
import Controller.Flashcard.DeckCollectionController;
import Model.*;
import Controller.*;
import Model.Clock.*;
import Model.Quests.QuestFeature;
import View.*;
import Windows.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static void createAndShowUI() {
        //Profile
        ArrayList<Profile> profileList = new ArrayList<>();
        //Profile currentProfile = new Profile("Profile1");
        //Profile currentProfile2 = new Profile("Profile2");
        //profileList.add(currentProfile);
        //profileList.add(currentProfile2);
        //currentProfile.setStatisticModel(statisticModel);





        //Main model
        MvcModel model = MvcModel.getInstance();



        HashMap<String, Window> views = new HashMap<>();

        CurrentView currentView = new CurrentView();

        CurrentViewController currentViewController = new CurrentViewController(currentView);

        DeckCollectionController deckCollectionController = new DeckCollectionController(model.getCurrentProfile());

        DeckCollectionWindow deckCollectionWindow = new DeckCollectionWindow(model.getCurrentProfile(),deckCollectionController, currentViewController);

        views.put("deckCollection",deckCollectionWindow);

        //Otroligt fula parametrar

        FlashcardFeatureWindows flashcardFeatureWindows = new FlashcardFeatureWindows(currentView,currentViewController);

        views.put("flashcardFeature",flashcardFeatureWindows);

        AddMenuWindow addMenuWindow = new AddMenuWindow(model.getCurrentProfile(), currentView, currentViewController);

        views.put("addMenu", addMenuWindow);

        ClockFeatureWindow clockFeatureWindow = new ClockFeatureWindow(model.getClockFeature());

        views.put("clockFeature", clockFeatureWindow);

        // FlashcardWindow flashcardWindow = new FlashcardWindow();



        MvcControl control = new MvcControl(model);

        Watch watch = new Watch();

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
