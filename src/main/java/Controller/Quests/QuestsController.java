package Controller.Quests;

import Controller.Observer;
import Model.Quests.Quest;
import Model.Quests.QuestFeature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuestsController extends JPanel implements Observer {
    private JLabel dailyLabel = new JLabel("Daily", SwingConstants.CENTER);
    private JLabel weeklyLabel = new JLabel("Weekly", SwingConstants.CENTER);
    private ImageIcon flameImage = new ImageIcon("src/main/img/flame_64.png");
    ArrayList<Quest> quests;
    public QuestsController(QuestFeature questFeature) {
        setBorder(BorderFactory.createEmptyBorder(20,50,20,50));
        setLayout(new GridLayout(4,2,50,10));
        setBackground(Color.WHITE);

        Font font = new Font("Calibri", Font.BOLD, 24);
        dailyLabel.setFont(font);
        weeklyLabel.setFont(font);

        quests = questFeature.getQuests();

        createGrid();
    }

    private void createGrid(){
        add(dailyLabel);
        add(weeklyLabel);

        add(new QuestCard(quests.get(0)));
        add(new QuestCard(quests.get(3)));

        add(new QuestCard(quests.get(1)));
        add(new QuestCard(quests.get(4)));

        add(new QuestCard(quests.get(2)));
        add(new QuestCard(quests.get(5)));
    }

    @Override
    public void update() {

    }
}
