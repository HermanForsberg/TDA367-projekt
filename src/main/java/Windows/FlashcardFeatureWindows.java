package Windows;

import Controller.Flashcard.BackwardsButtonListener;
import Controller.CurrentViewController;
import Controller.Flashcard.*;
import Controller.Observer;

import Model.Flashcards.Flashcard;
import Model.Flashcards.FlashcardDeck;
import Model.ObjectsInFocus;
import Model.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FlashcardFeatureWindows extends JPanel implements Observer, Window{



        private JPanel panelForFlashcard;

        private Flashcard flashcard = new Flashcard("temp", "temp");

        private FlashcardWindow flashcardWindow;

        private DeckController deckController;

        private Profile temp = new Profile("temp");

        private FlashcardDeck deck = new FlashcardDeck("temp", temp);

        private final GridBagConstraints c = new GridBagConstraints();
        private final JLabel currentCard = new JLabel("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());

        private JButton backwardsButton;

        private CurrentViewController currentViewController;

        private JButton next;

        private JButton previousButton;

        private JButton addCards;

        private JButton wrong;

        private JButton correct;

        private JButton deleteButton;

        private FlashcardController flashcardController = new FlashcardController(flashcard);

        private ObjectsInFocus objectsInFocus;


        public FlashcardFeatureWindows(ObjectsInFocus objectsInFocus, CurrentViewController newCurrentViewController) throws HeadlessException {
            //TODO backwardsButton
            //Set up the content pane.

            this.objectsInFocus = objectsInFocus;
            this.objectsInFocus.addObserver(this);
            deck = objectsInFocus.getDeckInFocus();
            currentViewController = newCurrentViewController;
            deckController = new DeckController(deck);

            setLayout(new GridBagLayout());
            this.panelForFlashcard = new JPanel(new GridLayout(1, 1));



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

            flashcardWindow = new FlashcardWindow(flashcard);


            c.gridy = 2;
            c.gridx = 1;
            c.weightx = 0;
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(40, 100, 40, 100);
            c.ipadx = 300;
            c.ipady = 200;
            panelForFlashcard.add(flashcardWindow);
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
            deleteButton = new JButton("Delete Card");
            deleteButton.setBackground(Color.BLUE);
            deleteButton.setForeground(Color.RED);
            c.gridx = 2;
            c.gridy = 1;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0, 0, 0, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(deleteButton, c);
            addButtonListenerToDelete(deckController);

        }

        public void addButtonListenerToDelete(DeleteCardButtonListener dcbl){
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int ans = JOptionPane.showConfirmDialog(null,
                            "Do you want to delete the card?","yes", JOptionPane.YES_NO_OPTION);
                    if(ans == 0) {
                        dcbl.onDeleteCardClicked();
                    }
                }
            });
        }

        public void removeActionListeners(JButton currentButton){
            for( ActionListener al : currentButton.getActionListeners() ) {
                currentButton.removeActionListener( al );
            }
    }

        public void update(){

            removeActionListeners(deleteButton);
            removeActionListeners(next);
            removeActionListeners(wrong);
            removeActionListeners(correct);
            removeActionListeners(previousButton);

            panelForFlashcard.removeAll();
            panelForFlashcard.add(flashcardWindow);

            deck = objectsInFocus.getDeckInFocus();
            deckController = new DeckController(deck);
            deck.addObserver(this);
            addNextButtonListener(deckController);
            addButtonListenerToPrev(deckController);
            addButtonListenerToDelete(deckController);

            flashcardWindow.setCard(deck.getCurrentFlashcard());
            currentCard.setText("Card: " + (deck.getCurrentIndex() + 1) + "/" + deck.getSize());

            flashcardController = new FlashcardController(deck.getCurrentFlashcard());


            if(deck.getCurrentIndex() == deck.getSize()-1){
                addButtonListenerToCorrect(flashcardController);
                addButtonListenerToWrong(flashcardController);
                next.setBackground(Color.MAGENTA);
                next.setText("Finish");

            }else if(deck.getCurrentIndex() >= deck.getSize()){

                next.setText("Restart");
                panelForFlashcard.removeAll();
                panelForFlashcard.add(new JLabel("Number of Correct: " + deck.getNumberOfCorrect() +
                        "/" + deck.getSize()));
                deckController.resetAnswers();
            }else{

                addButtonListenerToCorrect(flashcardController);
                addButtonListenerToWrong(flashcardController);
                next.setBackground(Color.CYAN);
                next.setText("Next");
            }
            updateUI();
        }

        public void createNextButton(){
            next = new JButton("Next");
            next.setBackground(Color.CYAN);
            c.gridx = 2;
            c.gridy = 2;
            c.insets = new Insets(0, 0, 0, 100);
            c.ipadx = 50;
            c.ipady = 20;
            add(next, c);
            addNextButtonListener(deckController);

        }

        public void addNextButtonListener(NextButtonListener nl){
            next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nl.onNextButtonClicked();
                }

                });
        }


        public void createPreviousButton(){
            previousButton = new JButton("Previous");
            previousButton.setBackground(Color.CYAN);
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(0, 100, 0, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(previousButton, c);
            addButtonListenerToPrev(deckController);
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
            correct = new JButton("Correct");
            correct.setBackground(Color.GREEN);
            c.gridx = 1;
            c.gridy = 3;
            c.insets = new Insets(0, 0, 20, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(correct,c);
            addButtonListenerToCorrect(flashcardController);


        }

        public void createWrongButton(){
            wrong = new JButton("Wrong");
            wrong.setBackground(Color.RED);
            c.gridx = 1;
            c.gridy = 4;
            c.insets = new Insets(0, 0, 20, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(wrong,c);
            addButtonListenerToWrong(flashcardController);
        }

        public void createAddCardsButton(){
            //TODO Eget window!!!
            addCards = new JButton("Add Cards");
            addCards.setBackground(Color.BLUE);
            addCards.setForeground(Color.WHITE);
            c.gridx = 1;
            c.gridy = 1;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0, 0, 0, 0);
            c.ipadx = 50;
            c.ipady = 20;
            add(addCards,c);
            addButtonListenerToAddCards(currentViewController);
        }

        public void addButtonListenerToCorrect(CorrectButtonListener cbl){
            correct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cbl.onCorrectClicked(Flashcard.correct);
                }
            });
        }

        public void addButtonListenerToWrong(WrongButtonListener wbl){
            wrong.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                wbl.onWrongClicked(Flashcard.wrong);
                }
            });
        }

        public void addButtonListenerToAddCards(AddCardsButtonListener acbl){
            addCards.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    acbl.onAddCardsClicked();
                }
            });
        }

        public void addButtonListenerToPrev(PreviousButtonListener pbl){

            previousButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pbl.onPreviousClicked();
                }
            });
        }
    }


