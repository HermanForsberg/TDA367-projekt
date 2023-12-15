import javax.swing.*;

import Controller.Flashcard.DeckCollectionController;
import Model.*;
import Controller.*;
import View.*;
import Windows.*;

import java.util.HashMap;

public class Main {

    private static void createAndShowUI() {

        //Main model
        MvcModel model = MvcModel.getInstance();

        MvcControl control = new MvcControl(model);

        ObjectsInFocus objectsInFocus = new ObjectsInFocus();

        ObjectsInFocusController objectsInFocusController = new ObjectsInFocusController(objectsInFocus);

        HashMap<String, Window> views = new HashMap<>();

        MvcView view = new MvcView(views);

        CurrentViewController currentViewController = new CurrentViewController(view);



        DeckCollectionController deckCollectionController = new DeckCollectionController(objectsInFocus.getCurrentProfile());

        DeckCollectionWindow deckCollectionWindow = new DeckCollectionWindow(objectsInFocus, objectsInFocusController, deckCollectionController, currentViewController);

        views.put("deckCollection",deckCollectionWindow);

        //Otroligt fula parametrar

        FlashcardFeatureWindows flashcardFeatureWindows = new FlashcardFeatureWindows(objectsInFocus,currentViewController);

        views.put("flashcardFeature",flashcardFeatureWindows);

        AddMenuWindow addMenuWindow = new AddMenuWindow(objectsInFocus, currentViewController);

        views.put("addMenu", addMenuWindow);

        ClockFeatureWindow clockFeatureWindow = new ClockFeatureWindow(objectsInFocus,model.getClockFeature());

        views.put("clockFeature", clockFeatureWindow);

        QuestsWindow questsWindow = new QuestsWindow(objectsInFocus);

        views.put("questWindow", questsWindow);

        ProfileFeatureWindow profileFeatureWindow = new ProfileFeatureWindow(model, currentViewController, control, objectsInFocusController, objectsInFocus);

        views.put("profileWindow", profileFeatureWindow);


        MvcMenu menu = new MvcMenu(currentViewController);

        JFrame frame = new JFrame("MyPlugg");
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
