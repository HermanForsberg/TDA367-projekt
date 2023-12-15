package Controller;

import Controller.Flashcard.AddCardsButtonListener;
import Controller.Flashcard.DeckButtonListener;
import Controller.Flashcard.PlayButtonListener;
import Controller.Profile.ProfileButtonListener;

import Model.Flashcards.FlashcardDeck;
import Model.Profile;
import View.MvcView;

public class CurrentViewController implements DeckButtonListener, BackwardsButtonListener, PlayButtonListener, AddCardsButtonListener, ProfileButtonListener {
    private MvcView currentView;
    public CurrentViewController(MvcView newCurrentView){
        currentView = newCurrentView;
    }
    public void setView(String view){
        currentView.setView(view);
    }



    //De flesta av dessa bör ha egna interfaces, dem använder ej sina paramterar, men vi hann inte.
    @Override
    public void onDeckButtonClicked(FlashcardDeck deck) {
        setView("flashcardFeature");
    }

    @Override
    public void onBackwardsClicked(String viewName) {
        setView(viewName);
    }

    @Override
    public void onPlayButtonCLicked(FlashcardDeck deck) {
        onDeckButtonClicked(deck);
    }

    @Override
    public void onAddCardsClicked() {
        setView("addMenu");
    }

    @Override
    public void onProfileButtonClicked(Profile profile) {
        setView("profileWindow");
    }
}
