package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashcardDeckgui extends JFrame {
    private JPanel deck;
    private JPanel flashcard;
    private JButton previous;
    private JButton next;
    private JButton falseButton;
    private JButton correctButton;

    public FlashcardDeckgui() {
        setContentPane(deck);
        setTitle("TestDeck");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående Model.flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(FlashcardDeckgui.this, "föregående kort");
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående Model.flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(FlashcardDeckgui.this, "nästa kort");
            }
        });
        correctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående Model.flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(FlashcardDeckgui.this, "Korrekt!!");
            }
        });
        falseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående Model.flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(FlashcardDeckgui.this, "Fel...");
            }
        });
    }

    public static void main(String[] args) {
        new FlashcardDeckgui();
    }
}
