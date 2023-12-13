package Controller.Flashcard;

import Model.Flashcards.Flashcard;
import Model.Flashcards.FlashcardDeck;

import javax.swing.*;
import java.awt.*;


public class AddMenuCard extends JComponent {
    private final GridBagConstraints constraints = new GridBagConstraints();
    public AddMenuCard(Flashcard flashcard, FlashcardDeck deck, JPanel grid) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));

        createQuestionLabel(flashcard);
        createAnswerLabel(flashcard);
        createDeleteButton(deck, flashcard, grid);

    }

    public void createQuestionLabel(Flashcard flashcard){
        constraints.gridy = 0;
        JLabel question = new JLabel("Question: " + flashcard.getQuestion());
        add(question,constraints);
    }

    public void createAnswerLabel(Flashcard flashcard){
        constraints.gridy = 1;
        JLabel solution = new JLabel("Solution: " + flashcard.getSolution());
        add(solution,constraints);
    }

    public void createDeleteButton(FlashcardDeck deck, Flashcard flashcard, JPanel grid){
        JButton deleteButton = new JButton("delete");
        deleteButton.setBackground(Color.RED);
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.BOTH;
        add(deleteButton,constraints);
        deleteButton.addActionListener(e -> {
            System.out.println(deck.getDeck().toString());
            deck.delete(flashcard);
            System.out.println(deck.getDeck().toString());
            grid.remove(AddMenuCard.this);
            grid.updateUI();
        });
    }
}
