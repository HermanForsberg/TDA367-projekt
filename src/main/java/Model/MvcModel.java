package Model;

import java.beans.*;

public class MvcModel {
    public static final String STATE_PROP_NAME = "State";
    private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);
    private State state = State.NO_STATE;




    public void setState(State state) {
        State oldState = this.state;
        this.state = state;
        // notify all listeners that the state property has changed

        pcSupport.firePropertyChange(STATE_PROP_NAME, oldState, state);

    }


    public State getState() {
        return state;
    }

    public String getStateText() {
        return state.getText();
    }

    // allow addition of listeners or observers
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);

        System.out.println(listener);
    }

}
