package Windows;

import Controller.Flashcard.AddButtonInMenusListener;
import Controller.CurrentViewController;

import Controller.Flashcard.AddMenuCard;
import Controller.Flashcard.DeckController;
import Controller.Observer;
import Model.CurrentView;
import Model.Flashcard;
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

        public AddMenuWindow(Profile profile, CurrentView newCurrentView, CurrentViewController newCurrentViewController) {

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

            for(ActionListener al: addButton.getActionListeners()){
                addButton.removeActionListener(al);
            }

            deckController = new DeckController(currentView.getDeckInFocus());
            addButtonListenerToAddButtonInMenu(deckController);

            grid.removeAll();
            try {
                currentView.getDeckInFocus().addObserver(this);
                for (Flashcard card : currentView.getDeckInFocus().getDeck()) {
                    grid.add(new AddMenuCard(card, currentView.getDeckInFocus(), grid));
                }
            }catch(Exception e){

            }
            updateUI();
        }

        public void createBackwardsButton(GridBagConstraints c){

                JButton backButton = new JButton("Finished");
                c.gridx = 3;
                c.gridheight = 2;
                c.gridwidth = 2;
                c.weightx = 0.3;
                c.fill = GridBagConstraints.HORIZONTAL;
                add(backButton,c);



                backButton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        currentViewController.setView("flashcardFeature");
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


