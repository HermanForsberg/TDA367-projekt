import Model.Quests.Quest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuestTest {
    @Test
    public void update_progress_updates_progress_correctly(){
        Quest quest = new Quest("Daily","Clock", "Testing clock", 5, 35, 100);
        quest.updateProgress(20);
        assertTrue(quest.getProgress()>0);
    }
}

