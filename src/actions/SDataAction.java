
package actions;

import fsm.Action;
import fsm.FSM;
import fsm.Event;

public class SDataAction extends Action {
    private int sdataCount = 0;

    @Override
    public void execute(FSM fsm, Event event) {
        sdataCount++;
        System.out.println("DATA sent " + sdataCount);
    }

    public int getSdataCount() {
        return sdataCount;
    }
}
