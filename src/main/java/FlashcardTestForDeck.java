
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashcardTestForDeck extends JButton{



    private JButton questButton;

    private String question;

    private String answer;

    public FlashcardTestForDeck(String question, String answer) {

        this.questButton = new JButton(question);
        this.question = question;
        this.answer = answer;
        questButton.addActionListener(new ActionListener() {
            // all the buttons do is call methods of the control
            public void actionPerformed(ActionEvent e) {

                //if (control != null) {

                    //control.startButtonActionPerformed(e); // e.g., here

                    if (questButton.getText().equals(question))
                    {
                        questButton.setText(answer);}
                    else{questButton.setText(question);
                    }
                }

        });
    }
    public JButton get(){
        return this.questButton;

    }

}

