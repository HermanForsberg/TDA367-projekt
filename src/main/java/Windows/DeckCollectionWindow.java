package Windows;

import Controller.*;
import Controller.Flashcard.DeckButton;
import Controller.Flashcard.DeckCollectionController;
import Controller.Flashcard.DeckController;
import Model.FlashcardDeck;
import Model.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckCollectionWindow extends JPanel implements Window, Observer {


        private JButton addButton = new JButton("Add Deck");

        private JPanel grid = new JPanel(new GridLayout(2, 0, 5, 5));


        private JPanel groundPanel = new JPanel();

        private Profile profile;

        private DeckCollectionController deckCollectionController;

        private CurrentViewController currentViewController;



        public DeckCollectionWindow(Profile model, DeckCollectionController newDeckCollectionController, CurrentViewController newCurrentViewController) {


            profile = model;
            profile.addObserver(this);

            deckCollectionController = newDeckCollectionController;
            currentViewController = newCurrentViewController;

            groundPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            groundPanel.setLayout(new BorderLayout(10, 10));

            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            setLayout(new BorderLayout(10, 10));
            add(groundPanel);
            groundPanel.add(grid);
            grid.add(addButton);


            for (FlashcardDeck deck : model.getListOfDecks()) {
                //DeckController deckController = new DeckController(deck);
                DeckButton deckButton = new DeckButton(deck);
                deckButton.addButtonListenerToDeleteButton(deckCollectionController);
                deckButton.addButtonListenerToClickedButton(currentViewController);

                grid.add(deckButton);

            }


            addButtonListenerToAddButton(deckCollectionController);

        }

    public void update() {


        System.out.println("Update");
        grid.removeAll();
        grid.add(addButton);
        for (FlashcardDeck deck : profile.getListOfDecks()) {
            DeckButton deckButton = new DeckButton(deck);
            deckButton.addButtonListenerToDeleteButton(deckCollectionController);
            deckButton.addButtonListenerToClickedButton(currentViewController);
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




