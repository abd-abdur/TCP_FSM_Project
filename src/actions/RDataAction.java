
package actions;

import fsm.Action;
import fsm.FSM;
import fsm.Event;

public class RDataAction extends Action {
    private int rdataCount = 0;

    @Override
    public void execute(FSM fsm, Event event) {
        rdataCount++;
        System.out.println("DATA received " + rdataCount);
    }

    public int getRdataCount() {
        return rdataCount;
    }
}
