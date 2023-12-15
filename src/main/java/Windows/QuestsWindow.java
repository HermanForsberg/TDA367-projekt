package Windows;

import Controller.Observer;
import Controller.Quests.QuestCard;
import Model.CurrentView;
import Model.Quests.Quest;
import Model.Quests.QuestFeature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuestsWindow extends JPanel implements Window, Observer {

    private JLabel dailyLabel = new JLabel("Daily", SwingConstants.CENTER);
    private JLabel weeklyLabel = new JLabel("Weekly", SwingConstants.CENTER);
    private ImageIcon flameImage = new ImageIcon("src/main/img/flame_64.png");
    private JLabel dailyStreakLabel = new JLabel("Streak 56", SwingConstants.CENTER);
    private JLabel weeklyStreakLabel = new JLabel("Streak 2", SwingConstants.CENTER);
    ArrayList<Quest> dailyQuests;

    private CurrentView currentView;

    private QuestFeature questFeature;
    public QuestsWindow(CurrentView currentView) {

        this.currentView = currentView;

        questFeature = currentView.getProfile().getQuestFeature();

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




        QuestCard questCard = new QuestCard(dailyQuests.get(0));
        questFeature.addObserver(questCard);
        add(questCard);

        QuestCard questCard1 = (new QuestCard(dailyQuests.get(3)));
        questFeature.addObserver(questCard1);
        add(questCard1);

        QuestCard questCard2 = (new QuestCard(dailyQuests.get(1)));
        questFeature.addObserver(questCard2);
        add(questCard2);

        QuestCard questCard3 = (new QuestCard(dailyQuests.get(4)));
        questFeature.addObserver(questCard3);
        add(questCard3);

        QuestCard questCard4 = (new QuestCard(dailyQuests.get(2)));
        questFeature.addObserver(questCard4);
        add(questCard4);

        QuestCard questCard5 = (new QuestCard(dailyQuests.get(5)));
        questFeature.addObserver(questCard5);
        add(questCard5);

        add(dailyStreakLabel);
        add(weeklyStreakLabel);
    }

    public void update(){

    }
}
