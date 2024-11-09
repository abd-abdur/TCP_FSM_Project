package actions;

import fsm.Action;
import fsm.FSM;
import fsm.Event;

public class TimeWaitAction extends Action {
    @Override
    public void execute(FSM fsm, Event event) {
        System.out.println("Entering TIME_WAIT state.");
    }
}
