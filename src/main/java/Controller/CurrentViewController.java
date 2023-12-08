package Controller;

import Model.CurrentView;
import Windows.Window;

public class CurrentViewController implements DeckButtonListener{

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
}
