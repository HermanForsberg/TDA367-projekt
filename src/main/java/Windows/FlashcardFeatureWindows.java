package Windows;

import Controller.BackwardsButtonListener;
import Controller.CurrentViewController;
import Controller.Flashcard.DeckController;
import Controller.Flashcard.FlashcardController;
import Controller.Observer;
import Model.CurrentView;
import Model.Flashcard;
import Model.FlashcardDeck;
import Model.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FlashcardFeatureWindows extends JPanel implements Observer, Window{

        private JButton forFlashcard = new JButton("Placeholder");

        private JPanel panelForFlashcard;

        private Profile profile;

        private FlashcardWindow flashcardWindow;

        private DeckController deckController;

        private FlashcardDeck deck = new FlashcardDeck("temp");

        private final GridBagConstraints c = new GridBagConstraints();
        private final JLabel currentCard = new JLabel("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());

        private JButton backwardsButton;

        private CurrentViewController currentViewController;

        private CurrentView currentView;



        public void setDeck(FlashcardDeck deck) {
            this.deck = deck;
            deck.addObserver(this);

        }

        public void setForFlashcard(JButton newFlashcard){
            forFlashcard = newFlashcard;
            updateUI();
        }

        public void setControl(DeckController newDeckController) {
            deckController = newDeckController;
        }


        public FlashcardFeatureWindows(CurrentView newCurrentView, CurrentViewController newCurrentViewController) throws HeadlessException {
            //TODO backwardsButton
            //Set up the content pane.
            currentView = newCurrentView;
            deck = currentView.getDeckInFocus();
            currentViewController = newCurrentViewController;

            setLayout(new GridBagLayout());
            this.panelForFlashcard = new JPanel(new GridLayout(1, 0, 10 ,10));



            addCardCounter();
            createNextButton();
            createPreviousButton();
            createCorrectButton();
            createWrongButton();
            createAddCardsButton();
            createDeleteButton();

            //TODO vart skall widgets och controller skapas.

            //TODO FlashcardController ska bli FlashcardWidget och skapas i swinvgmvctest, och bara ändras beroende vilket flashcard som är i fokus

            //shitcode men orkade inte göra bra :))))

            FlashcardWindow flashcard = new FlashcardWindow(new Flashcard("palce", "palce"));


            c.gridy = 2;
            c.gridx = 1;
            c.weightx = 0;
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(40, 100, 40, 100);
            c.ipadx = 300;
            c.ipady = 200;
            panelForFlashcard.add(flashcard);
            add(panelForFlashcard,c);


            backwardsButton = new JButton("<-------");
            addButtonListenerToBackwardsButton(currentViewController);
            backwardsButton.setBackground(Color.BLACK);
            backwardsButton.setForeground(Color.WHITE);
            c.gridx = 0;
            c.gridy = 1;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0, 0, 0, 0);
            c.ipadx = 50;
            c.ipady = 20;

            add(backwardsButton,c);


        }

        /*public void paint(){
            flashcardWindow.setCard(currentView.getDeckInFocus().getCurrentFlashcard());
        }*/

    public void addButtonListenerToBackwardsButton(BackwardsButtonListener buttonListener){
        backwardsButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                buttonListener.onBackwardsClicked("deckCollection");

            }
        });
    }


        private void createDeleteButton() {
            JButton deleteButton = new JButton("Delete Card");
            deleteButton.setBackground(Color.BLUE);
            deleteButton.setForeground(Color.RED);
            c.gridx = 2;
            c.gridy = 1;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0, 0, 0, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(deleteButton,c);
            deleteButton.addActionListener(e -> {
                int ans = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete the card?","yes", JOptionPane.YES_NO_OPTION);
                if(ans == 0){
                    deck.deleteIndex(deck.getCurrentIndex());
                    deck.previousClicked();

                }
            });
        }

        public void update(){



            deckController = new DeckController(currentView.getDeckInFocus());
            flashcardWindow.setCard(deck.getCurrentFlashcard());
            currentCard.setText("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());

            updateUI();
        }

        public void createNextButton(){
            JButton next = new JButton("Next");
            next.setBackground(Color.CYAN);
            c.gridx = 2;
            c.gridy = 2;
            c.insets = new Insets(0, 0, 0, 100);
            c.ipadx = 50;
            c.ipady = 20;
            add(next, c);
            next.addActionListener(this::nextActionPerformed);
        }
        public void nextActionPerformed(ActionEvent e) {
            deckController.nextClicked();
        }

        public void createPreviousButton(){
            JButton prev = new JButton("Previous");
            prev.setBackground(Color.CYAN);
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(0, 100, 0, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(prev, c);
            prev.addActionListener(e -> {
                deckController.previousClicked();
            });
        }

        public void addCardCounter(){
            c.gridx = 0;
            c.gridy = 4;
            c.insets = new Insets(0, 0, 0, 0);
            //c.fill = GridBagConstraints.BOTH;
            c.ipadx = 50;
            c.ipady = 20;
            add(currentCard, c);
        }

        public void createCorrectButton(){
            JButton correct = new JButton("Correct");
            correct.setBackground(Color.GREEN);
            c.gridx = 1;
            c.gridy = 3;
            c.insets = new Insets(0, 0, 20, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(correct,c);
            correct.addActionListener(e -> {
                Flashcard flashcard = deck.getCurrentFlashcard();
                //flashcard.setCorrect(true);
            });
        }

        public void createWrongButton(){
            JButton wrong = new JButton("Wrong");
            wrong.setBackground(Color.RED);
            c.gridx = 1;
            c.gridy = 4;
            c.insets = new Insets(0, 0, 20, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(wrong,c);
            wrong.addActionListener(e -> {
                Flashcard flashcard = deck.getCurrentFlashcard();
                //flashcard.setCorrect(false);
            });
        }

        public void createAddCardsButton(){
            //TODO Eget window!!!
            JButton addCards = new JButton("Add Cards");
            addCards.setBackground(Color.BLUE);
            addCards.setForeground(Color.WHITE);
            c.gridx = 1;
            c.gridy = 1;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0, 0, 0, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(addCards,c);
            addCards.addActionListener(e -> {
                currentViewController.setView("addMenu");
                updateUI();

            });
        }
    }


