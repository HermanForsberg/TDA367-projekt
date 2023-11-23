package Controller;

import Model.FlashcardDeck;
import Model.FlashcardFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashcardFeatureController extends JPanel {

    private JButton addButton = new JButton("Add Deck");

    private JPanel grid = new JPanel(new GridLayout(2, 0, 5, 5));

    private JPanel fill = new JPanel(new GridLayout(1, 0, 0, 5));

    private JPanel groundPanel = new JPanel();

    public FlashcardFeatureController(FlashcardFeature model) {

        groundPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        groundPanel.setLayout(new BorderLayout(10,10));

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setLayout(new BorderLayout(10,10));
        add(groundPanel);
        groundPanel.add(grid);
        fill.add(addButton);
        grid.add(fill);



        //Deckformat deckformat = new Deckformat(model.getNewestDeck());


        for (FlashcardDeck deck : model.GetListOfDecks()) {
            JButton backwardsButton = new JButton("Tillbaka");


            backwardsButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    removeAll();
                    add(groundPanel);
                    updateUI();
                }

            });
            DeckButtonController deckButtonController = new DeckButtonController(deck);
            Deckformat deckController = new Deckformat(deck, backwardsButton);

            grid.add(fill);
            grid.add(deckButtonController);

            deckButtonController.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    removeAll();

                    add(deckController);
                    updateUI();
                }

            });
            //grid.add(fill)

        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("name of deck: ");
                    JButton backwardsButton = new JButton("Tillbaka");
                    backwardsButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {

                            removeAll();
                            add(groundPanel);
                            updateUI();
                        }

                    });
                    if (!name.isEmpty()){
                        model.addClicked(name);
                        DeckButtonController deckButtonController = new DeckButtonController(model.getNewestDeck());
                        Deckformat deckController = new Deckformat(model.getNewestDeck(), backwardsButton);
                        grid.add(deckButtonController);
                        grid.updateUI();
                        deckButtonController.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                                removeAll();
                                add(deckController);
                                updateUI();
                            }

                        });
                    }else{
                        JOptionPane.showMessageDialog(FlashcardFeatureController.this,
                                "You must enter a name");
                    }



                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                //JOptionPane.showMessageDialog(flashcardDeckgui.this, "föregående kort");


            }
        });
    }



        /*public void addClicked(String deckName){

            model.addClicked(deckName);

        }

        public void deck1Clicked() {

        }*/

    }

