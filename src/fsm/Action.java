package fsm;

public abstract class Action {
    /**
     * Defines the action to execute during a transition.
     *
     * @param fsm The FSM instance.
     * @param e   The event triggering the transition.
     */
    public abstract void execute(FSM fsm, Event e);
}
