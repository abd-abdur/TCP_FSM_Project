package main;

import fsm.FSM;
import fsm.FsmException;
import fsm.Event;

import java.util.Scanner;

public class TcpFsmMain {
    public static void main(String[] args) {
        // Set up the FSM
        FSM tcpFsm = TcpFsmSetup.setupTcpFsm();

        System.out.println("TCP FSM Initialized. Current State: " + tcpFsm.currentState().getName());
        System.out.println(
                "Enter events (e.g., PASSIVE_OPEN, ACTIVE_OPEN, SYN, SYN_ACK, ACK, FIN, FIN_ACK, CLOSE, RDATA, SDATA). Type 'exit' to quit.");

        // Scanner for reading user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Event: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Exiting FSM.");
                break;
            }

            // Validate event input
            Event event = getEventByName(input);
            if (event == null) {
                System.out.println("Error: unexpected Event: " + input);
                continue;
            }

            // Process the event
            try {
                tcpFsm.doEvent(event);
                System.out.println("Transitioned to State: " + tcpFsm.currentState().getName());
            } catch (FsmException e) {
                System.out.println("FSM Exception: " + e.getMessage());
            }
        }

        scanner.close();
    }

    /**
     * Helper method to retrieve Event object by name.
     *
     * @param name Name of the event.
     * @return Event object or null if not found.
     */
    private static Event getEventByName(String name) {
        switch (name) {
            case "PASSIVE_OPEN":
                return events.Events.PASSIVE_OPEN;
            case "ACTIVE_OPEN":
                return events.Events.ACTIVE_OPEN;
            case "SYN":
                return events.Events.SYN;
            case "SYN_ACK":
                return events.Events.SYN_ACK;
            case "ACK":
                return events.Events.ACK;
            case "FIN":
                return events.Events.FIN;
            case "FIN_ACK":
                return events.Events.FIN_ACK;
            case "CLOSE":
                return events.Events.CLOSE;
            case "RDATA":
                return events.Events.RDATA;
            case "SDATA":
                return events.Events.SDATA;
            default:
                return null;
        }
    }
}
