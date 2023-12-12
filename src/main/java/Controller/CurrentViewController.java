package Controller;

import Model.CurrentView;
import Model.FlashcardDeck;
import Windows.Window;

public class CurrentViewController implements DeckButtonListener, BackwardsButtonListener, PlayButtonListener{

    private CurrentView currentView;
    public CurrentViewController(CurrentView newCurrentView){
        currentView = newCurrentView;
    }

    public void setView(String view){
        currentView.setCurrentView(view);
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
}
