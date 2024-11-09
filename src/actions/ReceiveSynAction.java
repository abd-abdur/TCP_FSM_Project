
package actions;

import fsm.Action;
import fsm.FSM;
import fsm.Event;

public class ReceiveSynAction extends Action {
    @Override
    public void execute(FSM fsm, Event event) {
        System.out.println("Received SYN packet.");
    }
}
