package Controller;

import Model.Quests.Quest;
import Model.Quests.QuestFeature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuestsController extends JPanel {
    private JLabel dailyLabel = new JLabel("Daily", SwingConstants.CENTER);
    private JLabel weeklyLabel = new JLabel("Weekly", SwingConstants.CENTER);
    ArrayList<Quest> dailyQuests;
    public QuestsController(QuestFeature questFeature) {
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        setLayout(new GridLayout(4,2, 10, 10));
        setBackground(Color.WHITE);

        dailyLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        weeklyLabel.setFont(new Font("Calibri", Font.BOLD, 24));

        dailyQuests = questFeature.getDailyQuests();

        createGrid();
    }

    private void createGrid(){
        add(dailyLabel);
        add(weeklyLabel);

        add(new QuestCard(dailyQuests.get(0)));
        add(new QuestCard(dailyQuests.get(0)));

        add(new QuestCard(dailyQuests.get(1)));
        add(new QuestCard(dailyQuests.get(1)));

        add(new QuestCard(dailyQuests.get(2)));
        add(new QuestCard(dailyQuests.get(2)));
    }
}
