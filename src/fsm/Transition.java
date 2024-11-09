package fsm;

public class Transition {
    private State currentState;
    private Event event;
    private State nextState;
    private Action action;
    private Long key;

    public Transition(State cs, Event evt, State ns, Action act) {
        this.currentState = cs;
        this.event = evt;
        this.nextState = ns;
        this.action = act;
        this.key = key(cs, evt);
    }

    /**
     * Executes the associated action during the transition.
     *
     * @param fsm The FSM instance.
     * @param evt The event triggering the transition.
     */
    public void doAction(FSM fsm, Event evt) {
        if (action != null) {
            action.execute(fsm, evt);
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public Event getEvent() {
        return event;
    }

    public State getNextState() {
        return nextState;
    }

    public Long getKey() {
        return key;
    }

    /**
     * Generates a unique key based on the current state and event.
     *
     * @param s The current state.
     * @param e The event.
     * @return A unique Long key representing the state-event pair.
     */
    public static Long key(State s, Event e) {
        return (long) (s.getName().hashCode() ^ e.getName().hashCode());
    }

    @Override
    public String toString() {
        return "Transition{" +
                "currentState=" + currentState.getName() +
                ", event=" + event.getName() +
                ", nextState=" + nextState.getName() +
                '}';
    }
}
