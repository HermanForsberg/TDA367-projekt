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

        //Main model
        MvcModel model = MvcModel.getInstance();

        HashMap<String, Window> views = new HashMap<>();

        CurrentView currentView = new CurrentView();

        CurrentViewController currentViewController = new CurrentViewController(currentView);

        DeckCollectionController deckCollectionController = new DeckCollectionController(model.getCurrentProfile());

        DeckCollectionWindow deckCollectionWindow = new DeckCollectionWindow(currentView,deckCollectionController, currentViewController);

        views.put("deckCollection",deckCollectionWindow);

        //Otroligt fula parametrar

        FlashcardFeatureWindows flashcardFeatureWindows = new FlashcardFeatureWindows(currentView,currentViewController);

        views.put("flashcardFeature",flashcardFeatureWindows);

        AddMenuWindow addMenuWindow = new AddMenuWindow(model.getCurrentProfile(), currentView, currentViewController);

        views.put("addMenu", addMenuWindow);

        ClockFeatureWindow clockFeatureWindow = new ClockFeatureWindow(currentView,model.getClockFeature());

        views.put("clockFeature", clockFeatureWindow);

        QuestsWindow questsWindow = new QuestsWindow(new QuestFeature());

        views.put("questWindow", questsWindow);

        ProfileFeatureWindow profileFeatureWindow = new ProfileFeatureWindow(model, currentViewController);

        views.put("profileWindow", profileFeatureWindow);




        MvcControl control = new MvcControl(model);

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
