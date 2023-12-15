package Controller.Quests;

import Controller.Observer;
import Model.Quests.Quest;

import javax.swing.*;
import java.awt.*;

public class QuestCard extends JPanel implements Observer{
    private final JLabel title = new JLabel("", SwingConstants.CENTER);
    private final JLabel description = new JLabel("", SwingConstants.CENTER);
    private final JLabel progress = new JLabel("", SwingConstants.CENTER);

    private Quest quest;
    public QuestCard(Quest quest) {
        this.quest = quest;
        //this.quest.addObserver(this);
        setLayout(new GridLayout(3,0,0,0));
        Color customColor = new Color(186, 231, 255);
        if (quest.isCompleted()) {
            customColor = Color.GREEN;
        }

        setBackground(customColor);

        createTitle(quest);
        createDescription(quest);
        createProgress(quest);
        createGrid();
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
    private void createGrid(){
        add(title);
        add(description);
        add(progress);
    }

    public void update(){
        System.out.println(quest.getProgress() + "PRogreeeesa");
        progress.setText("Progress: " + quest.getProgress() + "%");
    }
}
