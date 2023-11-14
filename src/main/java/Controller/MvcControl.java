import java.awt.event.ActionEvent;

public class MvcControl {
    private MvcModel model;



    public MvcControl(MvcModel model) {
    this.model = model;

    }


    public void startButtonActionPerformed(ActionEvent ae) {

        model.setState(State.FLASHCARDS);
    }

    public void flashcardMenuActionPerformed(ActionEvent ae) {

        model.setState(State.FLASHCARDS);
    }

    public void timerMenuActionPerformed(ActionEvent ae) {

        model.setState(State.TIMER);
    }


}
