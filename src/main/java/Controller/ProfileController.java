package Controller;

import Model.FlashcardDeck;
import Model.Profile;

public class ProfileController {

    private Profile profile;

    public ProfileController(){

    }

    public void setProfile(Profile profile){
        this.profile = profile;
    }

    public void deleteDeck(FlashcardDeck deck){
        profile.removeDeck(deck);
    }
}
