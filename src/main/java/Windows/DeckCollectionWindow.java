package Windows;

import Controller.AddButtonListener;
import Controller.CurrentViewController;
import Controller.DeleteButtonListener;
import Controller.Flashcard.DeckButton;
import Controller.Flashcard.DeckCollectionController;
import Controller.Observer;
import Model.FlashcardDeck;
import Model.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckCollectionWindow extends JPanel implements Window, Observer {


        private JButton addButton = new JButton("Add Deck");

        private JPanel grid = new JPanel(new GridLayout(2, 0, 5, 5));

        //private JPanel fill = new JPanel(new GridLayout(1, 0, 0, 5));

        private JPanel groundPanel = new JPanel();

        private Profile profile;

        private DeckButton deckButton;

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


            //TODO På något sätt merga deckformat och deckbuttoncontroller till en fil "DeckController"
            //Deckformat deckformat = new Deckformat(model.getNewestDeck());
            JButton backwardsButton = new JButton("<-------");
            backwardsButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    //Säg till view att byta
                    //removeAll();
                    //add(groundPanel);
                    //updateUI();
                }

            });

            for (FlashcardDeck deck : model.GetListOfDecks()) {

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
            for (FlashcardDeck deck : profile.GetListOfDecks()) {
                DeckButton deckButton = new DeckButton(deck);
                deckButton.addButtonListenerToDeleteButton(deckCollectionController);
                deckButton.addButtonListenerToClickedButton(currentViewController);
                grid.add(deckButton);
            }
            grid.updateUI();
        }


        public void addButtonListenerToAddButton(AddButtonListener buttonListener){

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("name of deck: ");

                    if (!name.isEmpty()){

                        //Controller ska göra
                        buttonListener.onAddButtonClicked(name);
                        /*DeckButton deckButton = new DeckButton(profile.getNewestDeck());
                        grid.add(deckButton);
                        grid.updateUI();
                        //TODO borde dessa två action-listeners vara någon annanstans?
                        deckButton.getClicked().addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                                //Controller ska göra
                                //removeAll();
                                //deckController.setDeck(model.getNewestDeck());
                                //add(deckController);
                                //updateUI();
                            }

                        });


                        deckButton.addButtonListenerToDeleteButton(deckCollectionController);

*/
                    }else{
                        JOptionPane.showMessageDialog(DeckCollectionWindow.this,
                                "You must enter a name");
                    }

                }
            });

        }


    }




