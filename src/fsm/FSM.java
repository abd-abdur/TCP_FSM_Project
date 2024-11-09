package fsm;

import java.util.HashMap;
import java.util.Map;

public class FSM {
    private String name;
    private State currentState;
    private Map<Long, Transition> transitions;
    private boolean tracing;

    public FSM() {
        this("DefaultFSM", null);
    }

    public FSM(String fsmName) {
        this(fsmName, null);
    }

    public FSM(String fsmName, State start) {
        this.name = fsmName;
        this.currentState = start;
        this.transitions = new HashMap<>();
        this.tracing = false;
    }

    public void addTransition(Transition t) throws FsmException {
        Long key = t.getKey();
        if (transitions.containsKey(key)) {
            throw new FsmException("Transition already exists for key: " + key);
        }
        transitions.put(key, t);
    }

    public void doEvent(Event e) throws FsmException {
        Long key = Transition.key(currentState, e);
        Transition t = transitions.get(key);
        if (t == null) {
            throw new FsmException(
                    "No transition defined for event: " + e.getName() + " in state: " + currentState.getName());
        }
        if (tracing) {
            System.out.println("Transitioning from " + currentState.getName() + " to " + t.getNextState().getName()
                    + " on event " + e.getName());
        }
        currentState = t.getNextState();
        t.doAction(this, e);
    }

    public State currentState() {
        return currentState;
    }

    public void nextState(State s) {
        this.currentState = s;
    }

    public void traceOn() {
        this.tracing = true;
    }

    public void traceOff() {
        this.tracing = false;
    }
}
