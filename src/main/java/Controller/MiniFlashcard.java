package Controller;

import Model.Flashcard;

import javax.swing.*;
import java.awt.*;

public class MiniFlashcard extends JPanel {
    public MiniFlashcard(Flashcard flashcard) {
        setLayout(new GridBagLayout());
        JLabel question = new JLabel(flashcard.getQuestion());
        JLabel solution = new JLabel(flashcard.getSolution());
        add(question);
        add(solution);
    }

}
