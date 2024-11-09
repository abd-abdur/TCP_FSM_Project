
package actions;

import fsm.Action;
import fsm.FSM;
import fsm.Event;

public class PassiveOpenAction extends Action {
    @Override
    public void execute(FSM fsm, Event event) {
        System.out.println("Passive Open Action executed.");
    }
}
