import Model.Quests.Quest;
import Model.Quests.QuestFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class QuestTest {
    @Test
    public void update_progress_updates_progress_correctly(){
        QuestFactory questFactory = new QuestFactory();
        ArrayList<Quest> quests = questFactory.getQuests();
        Quest quest = quests.get(0);
        quest.updateProgress(20);
        assertTrue(quest.getProgress()>0);
    }
}

