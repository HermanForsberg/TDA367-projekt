import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class flashcardDeckguiTest extends JFrame {
    private JPanel deck;
    private JPanel flashcard;
    private JButton previous;
    private JButton next;
    private JButton falseButton;
    private JButton correctButton;



    public flashcardDeckguiTest() {

        setContentPane(deck);
        setTitle("TestDeck");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        setVisible(true);

        FlashcardTestForDeck startButton = new FlashcardTestForDeck("Question", "Answer");
        FlashcardTestForDeck Button2 = new FlashcardTestForDeck("Question2", "Answer2");


        flashcard.setLayout(new GridLayout(1, 0, 10, 0));
        flashcard.add(startButton.get());



        //deck.add(button);

        //flashcard.add(new JButton("swag"));
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                //JOptionPane.showMessageDialog(flashcardDeckgui.this, "föregående kort");
                flashcard.removeAll();
                flashcard.add(Button2.get());
                flashcard.updateUI();
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                //JOptionPane.showMessageDialog(flashcardDeckgui.this, "nästa kort");
                flashcard.removeAll();
                flashcard.add(startButton.get());
                flashcard.updateUI();
            }
        });
        correctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(flashcardDeckguiTest.this, "Korrekt!!");
            }
        });
        falseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lägg in att man byter till föregående flashcard här
                //just nu öppnar den bara ett fönster
                JOptionPane.showMessageDialog(flashcardDeckguiTest.this, "Fel...");
            }
        });
    }

    public static void main(String[] args) {
        new flashcardDeckguiTest();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
