package Shaniqua;

public class Event extends Task{
    private FlexibleDateTime from;
    private FlexibleDateTime to;
    public Event(String name, String from, String to) throws InsufficientException, UnsuccessfulException {
        super(name);
        this.from = FlexibleDateTime.parse(from);
        this.to = FlexibleDateTime.parse(to);
    }
    public String toString() {
        return "[E] " + super.toString() + String.format(" (from: %s to: %s)", from, to);
    }
}
