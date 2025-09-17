package Shaniqua.TaskCore.Tasks;

public class Deadline extends Task{
    FlexibleDateTime dateTime;
    private boolean hasTime; // false: date; true: dateTime

    public Deadline(String name, String by) throws InvalidTaskDataException {
        super(name);
        try {
            dateTime = FlexibleDateTime.parse(by);
        } catch (FlexibleDateTimeException e) {
            throw new InvalidTaskDataException("Invalid date/ time entry");
        }
    }
    public String toString() {
        return "[D] " + super.toString() + String.format(" (by: %s)", dateTime.toString());
    }
}
