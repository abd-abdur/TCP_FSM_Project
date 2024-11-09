package events;

import fsm.Event;

public class Events {
    public static final Event PASSIVE_OPEN = new Event("PASSIVE_OPEN");
    public static final Event ACTIVE_OPEN = new Event("ACTIVE_OPEN");
    public static final Event SYN = new Event("SYN");
    public static final Event SYN_ACK = new Event("SYN_ACK");
    public static final Event ACK = new Event("ACK");
    public static final Event FIN = new Event("FIN");
    public static final Event FIN_ACK = new Event("FIN_ACK");
    public static final Event CLOSE = new Event("CLOSE");
    public static final Event RDATA = new Event("RDATA");
    public static final Event SDATA = new Event("SDATA");
}
