package Windows;

import Controller.Flashcard.BackwardsButtonListener;
import Controller.Flashcard.AddButtonInMenusListener;
import Controller.CurrentViewController;

import Controller.Flashcard.AddMenuCard;
import Controller.Flashcard.DeckController;
import Controller.Observer;
import Model.Flashcards.Flashcard;
import Model.ObjectsInFocus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMenuWindow extends JPanel implements Window, Observer {

    private CurrentViewController currentViewController;
    private JButton addButton;

    private DeckController deckController;

    private JPanel grid;

    private JButton backButton;

    private ObjectsInFocus objectsInFocus;

        public AddMenuWindow(ObjectsInFocus objectsInFocus, CurrentViewController newCurrentViewController) {

            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            grid = new JPanel();
            currentViewController = newCurrentViewController;
            this.objectsInFocus = objectsInFocus;
            this.objectsInFocus.addObserver(this);
            deckController = new DeckController(objectsInFocus.getDeckInFocus());

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

            deckController = new DeckController(objectsInFocus.getDeckInFocus());
            addButtonListenerToAddButtonInMenu(deckController);

            grid.removeAll();

            objectsInFocus.getDeckInFocus().addObserver(this);
            for (Flashcard card : objectsInFocus.getDeckInFocus().getDeck()) {
                grid.add(new AddMenuCard(card, objectsInFocus.getDeckInFocus(), grid));
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


