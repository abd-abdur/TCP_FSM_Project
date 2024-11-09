
package actions;

import fsm.Action;
import fsm.FSM;
import fsm.Event;

public class CloseConnectionAction extends Action {
    @Override
    public void execute(FSM fsm, Event event) {
        System.out.println("Closing connection.");
    }
}
