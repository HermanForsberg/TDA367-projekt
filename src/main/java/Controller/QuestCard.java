package Controller;

import Model.Quests.Quest;

import javax.swing.*;
import java.awt.*;

public class QuestCard extends JPanel {
    //private GridLayout grid = new GridLayout(3, 0);
    private JLabel title = new JLabel("", SwingConstants.CENTER);
    private JLabel description = new JLabel("", SwingConstants.CENTER);
    private JLabel progress = new JLabel("", SwingConstants.CENTER);
    public QuestCard(Quest quest) {
        setLayout(new GridLayout(3,0,0,0));
        Color customColor = new Color(186, 231, 255);
        if (quest.isCompleted()) {
            customColor = Color.GREEN;
        }

        setBackground(customColor);

        createTitle(quest);
        createDescription(quest);
        createProgress(quest);
        createGrid(quest);
    }

    private void createTitle(Quest quest){
        String text = "";
        text += quest.getTopic() + " - " + quest.getXpGain() + "xp";
        title.setText(text);
        title.setFont(new Font("Calibri", Font.BOLD, 16));
    }
    private void createDescription(Quest quest){
        String text = "";
        text += quest.getDescription();
        description.setText(text);
        description.setFont(new Font("Calibri", Font.PLAIN, 16));
    }
    private void createProgress(Quest quest){
        String text = "";
        text += "Progress: " + quest.getProgress() + "%";
        progress.setText(text);
        progress.setFont(new Font("Calibri", Font.PLAIN, 16));
    }
    private void createGrid(Quest quest){
        add(title);
        add(description);
        add(progress);
    }
}
