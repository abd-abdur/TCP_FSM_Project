package main;

import fsm.FSM;
import fsm.FsmException;
import fsm.Transition;
import fsm.Action;
import events.Events;
import states.*;

import actions.*;

public class TcpFsmSetup {
    public static FSM setupTcpFsm() {
        // Initialize FSM with starting state
        FSM fsm = new FSM("TCP_FSM", new ClosedState());

        // Define actions
        Action passiveOpenAction = new PassiveOpenAction();
        Action activeOpenAction = new ActiveOpenAction();
        Action sendSynAction = new SendSynAction();
        Action receiveSynAction = new ReceiveSynAction();
        Action sendAckAction = new SendAckAction();
        Action establishedAction = new EstablishedAction();
        Action sendFinAction = new SendFinAction();
        Action timeWaitAction = new TimeWaitAction();
        Action closingAction = new ClosingAction();
        Action closeConnectionAction = new CloseConnectionAction();
        Action rDataAction = new RDataAction();
        Action sDataAction = new SDataAction();

        try {
            // Define transitions from CLOSED state
            fsm.addTransition(new Transition(
                    fsm.currentState(), // CLOSED
                    Events.PASSIVE_OPEN,
                    new ListenState(),
                    passiveOpenAction));

            fsm.addTransition(new Transition(
                    fsm.currentState(), // CLOSED
                    Events.ACTIVE_OPEN,
                    new SynSentState(),
                    activeOpenAction));

            // Define transitions from LISTEN state
            fsm.addTransition(new Transition(
                    new ListenState(),
                    Events.SYN,
                    new SynReceivedState(),
                    receiveSynAction));

            fsm.addTransition(new Transition(
                    new ListenState(),
                    Events.CLOSE,
                    new ClosedState(),
                    closeConnectionAction));

            // Define transitions from SYN_SENT state
            fsm.addTransition(new Transition(
                    new SynSentState(),
                    Events.SYN_ACK,
                    new EstablishedState(),
                    establishedAction));

            fsm.addTransition(new Transition(
                    new SynSentState(),
                    Events.SYN,
                    new SynReceivedState(),
                    receiveSynAction));

            // Define transitions from SYN_RECEIVED state
            fsm.addTransition(new Transition(
                    new SynReceivedState(),
                    Events.ACK,
                    new EstablishedState(),
                    establishedAction));

            // Define transitions from ESTABLISHED state
            fsm.addTransition(new Transition(
                    new EstablishedState(),
                    Events.FIN,
                    new FinWait1State(),
                    sendFinAction));

            fsm.addTransition(new Transition(
                    new EstablishedState(),
                    Events.RDATA,
                    new EstablishedState(), // Remain in ESTABLISHED
                    rDataAction));

            fsm.addTransition(new Transition(
                    new EstablishedState(),
                    Events.SDATA,
                    new EstablishedState(), // Remain in ESTABLISHED
                    sDataAction));

            // Define transitions from FIN_WAIT_1 state
            fsm.addTransition(new Transition(
                    new FinWait1State(),
                    Events.FIN_ACK,
                    new TimeWaitState(),
                    timeWaitAction));

            fsm.addTransition(new Transition(
                    new FinWait1State(),
                    Events.FIN,
                    new ClosingState(),
                    closingAction));

        } catch (FsmException e) {
            System.err.println("Error setting up TCP FSM: " + e.getMessage());
        }

        return fsm;
    }
}
