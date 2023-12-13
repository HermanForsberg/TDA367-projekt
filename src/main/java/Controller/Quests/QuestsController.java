package Controller.Quests;

import Model.Quests.Quest;
import Model.Quests.QuestFeature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuestsController extends JPanel {
    private JLabel dailyLabel = new JLabel("Daily", SwingConstants.CENTER);
    private JLabel weeklyLabel = new JLabel("Weekly", SwingConstants.CENTER);
    private ImageIcon flameImage = new ImageIcon("src/main/img/flame_64.png");
    private JLabel dailyStreakLabel = new JLabel("Streak 56", SwingConstants.CENTER);
    private JLabel weeklyStreakLabel = new JLabel("Streak 2", SwingConstants.CENTER);
    ArrayList<Quest> dailyQuests;
    public QuestsController(QuestFeature questFeature) {
        setBorder(BorderFactory.createEmptyBorder(20,50,20,50));
        setLayout(new GridLayout(5,2,50,10));
        setBackground(Color.WHITE);

        Font font = new Font("Calibri", Font.BOLD, 24);
        dailyLabel.setFont(font);
        weeklyLabel.setFont(font);
        dailyStreakLabel.setFont(font);
        weeklyStreakLabel.setFont(font);

        dailyQuests = questFeature.getQuests();

        createGrid();
    }

    private void createGrid(){
        add(dailyLabel);
        add(weeklyLabel);

        add(new QuestCard(dailyQuests.get(0)));
        add(new QuestCard(dailyQuests.get(3)));

        add(new QuestCard(dailyQuests.get(1)));
        add(new QuestCard(dailyQuests.get(4)));

        add(new QuestCard(dailyQuests.get(2)));
        add(new QuestCard(dailyQuests.get(5)));

        add(dailyStreakLabel);
        add(weeklyStreakLabel);
    }
}
