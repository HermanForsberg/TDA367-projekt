import Model.Quests.Quest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuestTest {
    @Test
    public void updateProgress_updates_progress_correctly(){
        Quest quest = new Quest("Daily","Clock", "Testing clock", 5, 35, 100);
        float startProgress = quest.getProgress();
        quest.updateProgress(20);
        assertTrue(quest.getProgress()>startProgress);
    }
}

