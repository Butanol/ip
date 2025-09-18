package shaniqua.taskcore.tasks;

public class Deadline extends Task {
    private final FlexibleDateTime dateTime;

    public Deadline(String name, String by) throws InvalidTaskDataException {
        super(name);
        try {
            dateTime = FlexibleDateTime.parse(by);
        } catch (FlexibleDateTimeException e) {
            throw new InvalidTaskDataException("Invalid date/ time entry");
        }
    }
    public boolean equals(Object O) {
        if (O instanceof Deadline) {
            Deadline temp = (Deadline) O;
            return super.name == temp.name && this.dateTime == temp.dateTime;
        }
        return false;
    }
    public String toString() {
        return "[D] " + super.toString() + String.format(" (by: %s)", dateTime.toString());
    }
}
