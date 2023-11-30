package Controller.Flashcard;

import Model.Flashcard;
import Model.FlashcardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeckController extends JPanel{

    private JPanel panelForFlashcard;


    public DeckController(FlashcardDeck deck, JButton backwardsButton) throws HeadlessException {
        //Set up the content pane.
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.panelForFlashcard = new JPanel(new GridLayout(1, 0, 10 ,10));

        JLabel currentCard = new JLabel("Card: "+(deck.getCurrentIndex()+1)+"/"+ deck.getSize());
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 0, 0);
        //c.fill = GridBagConstraints.BOTH;
        c.ipadx = 50;
        c.ipady = 20;
        add(currentCard, c);

        JButton next = new NextButton("Next");
        next.setBackground(Color.CYAN);
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 0, 100);
        c.ipadx = 50;
        c.ipady = 20;
        add(next, c);
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        });

        JButton prev = new JButton("Previous");
        prev.setBackground(Color.CYAN);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 100, 0, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(prev, c);
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            }
        });

        JButton correct = new JButton("Correct");
        correct.setBackground(Color.GREEN);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 0, 20, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(correct,c);
        correct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Flashcard flashcard = deck.getCurrentFlashcard();
                flashcard.setCorrect(true);
            }

        });

        JButton wrong = new JButton("Wrong");
        wrong.setBackground(Color.RED);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 20, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(wrong,c);
        wrong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Flashcard flashcard = deck.getCurrentFlashcard();
                flashcard.setCorrect(false);
            }

        });

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
        addCards.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
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

                /*
                String question = JOptionPane.showInputDialog("Question: ");
                String answer = JOptionPane.showInputDialog("Answer: ");
                if(!question.isEmpty() && !answer.isEmpty()){
                    Flashcard flash = new Flashcard(question, answer);
                    deck.addFlashcard(flash);
                    currentCard.setText((deck.getCurrentIndex()+1)+"/"+ deck.getSize());
                    updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(Deckformat.this, "Need input in both fields");
                }*/
            }

        });


        backwardsButton.setBackground(Color.BLACK);
        backwardsButton.setForeground(Color.WHITE);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 50;
        c.ipady = 20;
        add(backwardsButton,c);

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
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            }

        });

    }

}
