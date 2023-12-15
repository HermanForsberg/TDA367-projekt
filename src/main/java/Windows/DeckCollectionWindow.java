package Windows;

import Controller.*;
import Controller.Flashcard.AddButtonListener;
import Controller.Flashcard.DeckButton;
import Controller.Flashcard.DeckCollectionController;
import Controller.Flashcard.DeckController;

import Model.Flashcards.FlashcardDeck;
import Model.ObjectsInFocus;
import Model.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckCollectionWindow extends JPanel implements Window, Observer {

        private JButton addButton = new JButton("Add Deck");

        private JPanel grid = new JPanel(new GridLayout(2, 0, 5, 5));

        private DeckController deckController;

        private JPanel groundPanel = new JPanel();

        private Profile profile = new Profile("temp");

        private DeckCollectionController deckCollectionController;

        private CurrentViewController currentViewController;

        private ObjectsInFocus objectsInFocus;

        private ObjectsInFocusController objectsInFocusController;

        public DeckCollectionWindow(ObjectsInFocus objectsInFocus, ObjectsInFocusController objectsInFocusController, DeckCollectionController newDeckCollectionController, CurrentViewController newCurrentViewController) {

            this.objectsInFocus = objectsInFocus;
            this.objectsInFocus.addObserver(this);

            deckCollectionController = newDeckCollectionController;
            currentViewController = newCurrentViewController;
            this.objectsInFocusController = objectsInFocusController;

            groundPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            groundPanel.setLayout(new BorderLayout(10, 10));

            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            setLayout(new BorderLayout(10, 10));
            add(groundPanel);
            groundPanel.add(grid);
            grid.add(addButton);

            createDeckButtons(profile);
        }

    public void createDeckButtons(Profile model){
        for (FlashcardDeck deck : model.getListOfDecks()) {
            deckController = new DeckController(deck);
            DeckButton deckButton = new DeckButton(deck);

            deckButton.addButtonListenerToDeleteButton(deckCollectionController);
            deckButton.addButtonListenerToClickedButton(currentViewController);

            deckButton.addButtonListenerToClickedButton(objectsInFocusController);
            deckButton.addShuffleButtonListenerToClickedButton(deckController);

            deckButton.addPlayButtonListenerToClickedButton(currentViewController);
            deckButton.addPlayButtonListenerToClickedButton(objectsInFocusController);

            grid.add(deckButton);

        }
        addButtonListenerToAddButton(deckCollectionController);
    }

    public void removeActionListeners(JButton currentButton){
        for( ActionListener al : currentButton.getActionListeners() ) {
            currentButton.removeActionListener( al );
        }
    }
    public void update() {
        removeActionListeners(addButton);

        profile = objectsInFocus.getCurrentProfile();
        profile.addObserver(this);
        deckCollectionController = new DeckCollectionController(profile);
        addButtonListenerToAddButton(deckCollectionController);

        System.out.println("Update");
        grid.removeAll();
        grid.add(addButton);

        for (FlashcardDeck deck : profile.getListOfDecks())

    {
        deckController = new DeckController(deck);
        DeckButton deckButton = new DeckButton(deck);
        deckButton.addButtonListenerToDeleteButton(deckCollectionController);
        deckButton.addButtonListenerToClickedButton(currentViewController);
        deckButton.addButtonListenerToClickedButton(objectsInFocusController);
        deckButton.addShuffleButtonListenerToClickedButton(deckController);
        deckButton.addPlayButtonListenerToClickedButton(currentViewController);
        deckButton.addPlayButtonListenerToClickedButton(objectsInFocusController);

        grid.add(deckButton);
    }
        grid.updateUI();
    }

    public void addButtonListener(){

    }
        public void addButtonListenerToAddButton(AddButtonListener buttonListener){
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String name = JOptionPane.showInputDialog("name of deck: ");
                    if (!name.isEmpty()){
                        buttonListener.onAddButtonClicked(name);
                    }else{
                        JOptionPane.showMessageDialog(DeckCollectionWindow.this,
                                "You must enter a name");
                    }

                }
            });
        }
    }




