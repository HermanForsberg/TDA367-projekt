package Controller;

import Model.CurrentView;
import Windows.Window;

public class CurrentViewController implements DeckButtonListener, BackwardsButtonListener{

    private CurrentView currentView;
    public CurrentViewController(CurrentView newCurrentView){
        currentView = newCurrentView;
    }

    public void setView(String view){
        currentView.setCurrentView(view);
    }


    @Override
    public void onDeckButtonClicked(String viewName) {
        setView(viewName);
    }

    @Override
    public void onBackwardsClicked(String viewName) {
        setView(viewName);
    }
}
