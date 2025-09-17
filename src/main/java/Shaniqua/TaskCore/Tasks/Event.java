package Shaniqua.TaskCore.Tasks;

public class Event extends Task{
    private FlexibleDateTime from;
    private FlexibleDateTime to;
    public Event(String name, String from, String to) throws InvalidTaskDataException {
        super(name);
        try {
            this.from = FlexibleDateTime.parse(from);
            this.to = FlexibleDateTime.parse(to);
        } catch (FlexibleDateTimeException e) {
            throw new InvalidTaskDataException("Invalid date/ time entry");
        }
    }
    public String toString() {
        return "[E] " + super.toString() + String.format(" (from: %s to: %s)", from, to);
    }
}
