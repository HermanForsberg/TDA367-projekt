package Controller.Flashcard;

import Controller.Observer;
import Controller.Updater;
import Model.FlashcardDeck;
import Model.FlashcardFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckCollectionController extends JPanel implements Observer {



    private JButton addButton = new JButton("Add Deck");

    private JPanel grid = new JPanel(new GridLayout(2, 0, 5, 5));

    //private JPanel fill = new JPanel(new GridLayout(1, 0, 0, 5));

    private JPanel groundPanel = new JPanel();

    public DeckCollectionController(FlashcardFeature model) {

        groundPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        groundPanel.setLayout(new BorderLayout(10,10));

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setLayout(new BorderLayout(10,10));
        add(groundPanel);
        groundPanel.add(grid);
        grid.add(addButton);



        //TODO På något sätt merga deckformat och deckbuttoncontroller till en fil "DeckController"
        //Deckformat deckformat = new Deckformat(model.getNewestDeck());
        JButton backwardsButton = new JButton("<-------");
        backwardsButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                removeAll();
                add(groundPanel);
                updateUI();
            }

        });

        DeckController deckController = new DeckController(backwardsButton);

        for (FlashcardDeck deck : model.GetListOfDecks()) {

            DeckButton deckButtonController = new DeckButton(deck);

            grid.add(deckButtonController);

            deckButtonController.getClicked().addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    removeAll();
                    add(deckController);
                    deckController.setDeck(deck);
                    updateUI();
                }

            });

            deckButtonController.getDeleteButton().addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    int ans = JOptionPane.showConfirmDialog(null,
                            "Do you want to delete the card?","Delete", JOptionPane.YES_NO_OPTION);
                    if(ans == 0){
                        model.deleteDeck(deck);
                        grid.remove(deckButtonController);
                        remove(deckButtonController);
                        grid.updateUI();
                        updateUI();
                    }
                }

            });

        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("name of deck: ");
                    JButton backwardsButton = new JButton("<-------");
                    backwardsButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {

                            removeAll();
                            add(groundPanel);
                            updateUI();
                        }

                    });
                    if (!name.isEmpty()){
                        model.addNewDeck(name);
                        DeckButton deckButtonController = new DeckButton(model.getNewestDeck());
                        grid.add(deckButtonController);
                        grid.updateUI();
                        deckButtonController.getClicked().addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                                removeAll();
                                add(deckController);
                                updateUI();
                            }

                        });
                        deckButtonController.getDeleteButton().addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {
                                int ans = JOptionPane.showConfirmDialog(null,
                                        "Do you want to delete the card?","Delete", JOptionPane.YES_NO_OPTION);
                                if(ans == 0){
                                    grid.remove(deckButtonController);
                                    remove(deckButtonController);
                                    grid.updateUI();

                                    updateUI();
                                }
                            }

                        });

                    }else{
                        JOptionPane.showMessageDialog(DeckCollectionController.this,
                                "You must enter a name");
                    }



                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                //JOptionPane.showMessageDialog(flashcardDeckgui.this, "föregående kort");


            }
        });
    }

    @Override
    public void update() {

    }




        /*public void addClicked(String deckName){

            model.addClicked(deckName);

        }

        public void deck1Clicked() {

        }*/

    }

