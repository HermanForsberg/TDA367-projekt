package Windows;

import Controller.BackwardsButtonListener;
import Controller.Flashcard.AddButtonInMenusListener;
import Controller.CurrentViewController;

import Controller.Flashcard.AddMenuCard;
import Controller.Flashcard.DeckController;
import Controller.Observer;
import Model.CurrentView;
import Model.Flashcards.Flashcard;
import Model.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMenuWindow extends JPanel implements Window, Observer {

    private CurrentView currentView;

    private CurrentViewController currentViewController;
    private JButton addButton;

    private DeckController deckController;

    private JPanel grid;

    private JButton backButton;

        public AddMenuWindow(CurrentView newCurrentView, CurrentViewController newCurrentViewController) {

            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            grid = new JPanel();
            currentViewController = newCurrentViewController;
            currentView = newCurrentView;
            currentView.addObserver(this);
            deckController = new DeckController(currentView.getDeckInFocus());

            grid.setLayout(new GridLayout(5, 5, 10, 10));
            c.gridy = 2;
            c.gridwidth = 5;
            c.gridheight = 5;
            c.fill = GridBagConstraints.BOTH;
            add(grid, c);
            createAddButton(c);
            createBackwardsButton(c);
        }

        public void createAddButton(GridBagConstraints c) {
            addButton = new JButton("Add Card");
            addButtonListenerToAddButtonInMenu(deckController);
            c.gridy = 0;
            c.gridx = 0;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridheight = 2;
            c.gridwidth = 3;
            add(addButton, c);
        }

        public void update(){
            removeActionListeners(addButton);

            deckController = new DeckController(currentView.getDeckInFocus());
            addButtonListenerToAddButtonInMenu(deckController);

            grid.removeAll();

            currentView.getDeckInFocus().addObserver(this);
            for (Flashcard card : currentView.getDeckInFocus().getDeck()) {
                grid.add(new AddMenuCard(card, currentView.getDeckInFocus(), grid));
            }

            updateUI();
        }

        public void removeActionListeners(JButton currentButton) {
            for (ActionListener al : currentButton.getActionListeners()) {
                currentButton.removeActionListener(al);
            }
        }


        public void createBackwardsButton(GridBagConstraints c){

                backButton = new JButton("Finished");
                c.gridx = 3;
                c.gridheight = 2;
                c.gridwidth = 2;
                c.weightx = 0.3;
                c.fill = GridBagConstraints.HORIZONTAL;
                add(backButton,c);

                addButtonListenerToBackwardsButton(currentViewController);


            }


        public void addButtonListenerToBackwardsButton(BackwardsButtonListener bbl){
            backButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    bbl.onBackwardsClicked("flashcardFeature");

                }
            });
        }



        public void addButtonListenerToAddButtonInMenu(AddButtonInMenusListener addListener){

            addButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String question = JOptionPane.showInputDialog("Question: ");
                    String solution = JOptionPane.showInputDialog("Solution: ");
                    if(!question.isEmpty() && !solution.isEmpty()){
                        addListener.addButtonInMenuClicked(question,solution);
                    }
                    else {
                        JOptionPane.showMessageDialog(AddMenuWindow.this, "Need input in both fields");
                    }

                }

            });
        }

    }


