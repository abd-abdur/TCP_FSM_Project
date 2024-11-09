package fsm;

public class Event {
    private String name;

    public Event(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the event.
     *
     * @return Name of the event.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                '}';
    }
}
