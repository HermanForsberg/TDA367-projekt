package Controller.Flashcard;

import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeckController extends JPanel{

    private JPanel panelForFlashcard;

    private FlashcardDeck deck = new FlashcardDeck("temp");

    private final GridBagConstraints c = new GridBagConstraints();
    private final JLabel currentCard = new JLabel("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());

    public void setDeck(FlashcardDeck deck) {
        this.deck = deck;
    }

    public DeckController(JButton backwardsButton) throws HeadlessException {

        //Set up the content pane.
        setLayout(new GridBagLayout());
        this.panelForFlashcard = new JPanel(new GridLayout(1, 0, 10 ,10));

        addCardCounter();
        createNextButton();
        createPreviousButton();
        createCorrectButton();
        createWrongButton();
        createAddCardsButton();
        createDeleteButton();

        //shitcode men orkade inte göra bra :))))
        FlashcardController flashcard = new FlashcardController(new Flashcard("PlaceHolder", "PlaceHolderAnswer"));
        try {
            flashcard = new FlashcardController(deck.getDeck().get(0));
        }
        catch (Exception e){

        }

        c.gridy = 2;
        c.gridx = 1;
        c.weightx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(40, 100, 40, 100);
        c.ipadx = 300;
        c.ipady = 200;
        panelForFlashcard.add(flashcard);
        add(panelForFlashcard,c);



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
                panelForFlashcard.removeAll();
                panelForFlashcard.add(new FlashcardController(deck.getDeck().get(deck.getCurrentIndex())));
                panelForFlashcard.updateUI();
                currentCard.setText("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());
                updateUI();
            }
        });
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
        deck.nextClicked();
        panelForFlashcard.removeAll();
        try {
            panelForFlashcard.add(new FlashcardController(deck.getDeck().get(deck.getCurrentIndex())));
        }catch(Exception e2){
            panelForFlashcard.add(new FlashcardController(new Flashcard("PlaceHolder", "PlaceHolderAnswer")));
        }
        panelForFlashcard.updateUI();
        currentCard.setText("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());
        updateUI();
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
            deck.previousClicked();
            panelForFlashcard.removeAll();
            try {
                panelForFlashcard.add(new FlashcardController(deck.getCurrentFlashcard()));
            }catch(Exception e2){
                panelForFlashcard.add(new FlashcardController(new Flashcard("PlaceHolder", "PlaceHolderAnswer")));
            }
            panelForFlashcard.updateUI();
            currentCard.setText("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());
            updateUI();
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
            flashcard.setCorrect(true);
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
            flashcard.setCorrect(false);
        });
    }

    public void createAddCardsButton(){
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
            AddMenu adder = new AddMenu(deck, DeckController.this);
            Component[] test = getComponents();
            for (Component test2: test) {
                test2.setVisible(false);
            }
            c.fill = GridBagConstraints.BOTH;
            c.weighty = 0.5;
            c.weightx = 0.5;
            add(adder,c);
            updateUI();

        });
    }
}
