package Controller;

import Controller.Flashcard.AddCardsButtonListener;
import Controller.Flashcard.DeckButtonListener;
import Controller.Flashcard.PlayButtonListener;
import Controller.Profile.ProfileButtonListener;
import Model.CurrentView;
import Model.Flashcards.FlashcardDeck;
import Model.Profile;

public class CurrentViewController implements DeckButtonListener, BackwardsButtonListener, PlayButtonListener, AddCardsButtonListener, ProfileButtonListener {
    private CurrentView currentView;
    public CurrentViewController(CurrentView newCurrentView){
        currentView = newCurrentView;
    }
    public void setView(String view){
        currentView.setCurrentView(view);
    }
    public void setProfile(Profile profile){
        currentView.setProfile(profile);
    }

    @Override
    public void onDeckButtonClicked(FlashcardDeck deck) {
        currentView.setDeckInFocus(deck);
    }

    @Override
    public void onBackwardsClicked(String viewName) {
        setView(viewName);
    }

    @Override
    public void onPlayButtonCLicked(FlashcardDeck deck) {
        System.out.println("Updat");
        currentView.setDeckInFocus(deck);
    }

    @Override
    public void onAddCardsClicked() {
        setView("addMenu");
    }

    @Override
    public void onProfileButtonClicked(Profile profile) {
        currentView.setProfile(profile);
    }
}
