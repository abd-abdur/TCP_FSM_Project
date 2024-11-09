package fsm;

public abstract class State {
    private String name;

    public State(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the state.
     *
     * @return Name of the state.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }
}
