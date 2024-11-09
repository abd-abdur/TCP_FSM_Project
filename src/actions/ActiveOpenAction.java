
package actions;

import fsm.Action;
import fsm.FSM;
import fsm.Event;

public class ActiveOpenAction extends Action {
    @Override
    public void execute(FSM fsm, Event event) {
        System.out.println("Active Open Action executed.");
    }
}
