import Model.Profile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProfileTest {

    @Test
    public void should_be_level_one_in_new_profile(){
        Profile profile = new Profile("test");
        assertEquals(1, profile.getLevel());
    }
    @Test
    public void should_be_level_two_after_added_exp(){
        Profile profile = new Profile("test");
        profile.addExp(245);
        assertEquals(2, profile.getLevel());
    }

}
