package Controller;

import Model.Flashcard;

import javax.swing.*;
import java.awt.*;

public class MiniFlashcard extends JPanel {
    public MiniFlashcard(Flashcard flashcard) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setBorder(BorderFactory.createLineBorder(Color.black));
        c.gridy = 0;
        JLabel question = new JLabel("Question: " + flashcard.getQuestion());
        add(question,c);
        c.gridy = 1;
        JLabel solution = new JLabel("Solution: " + flashcard.getSolution());
        add(solution,c);
    }

}
