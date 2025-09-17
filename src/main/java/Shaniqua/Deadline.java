package Shaniqua;

public class Deadline extends Task{
    FlexibleDateTime dateTime;
    private boolean hasTime; // false: date; true: dateTime

    public Deadline(String name, String by) throws InsufficientException, UnsuccessfulException {
        super(name);
        try {
            dateTime = FlexibleDateTime.parse(by);
        } catch (UnsuccessfulException e) {
            throw e;
        } catch (Exception e) {
            throw new UnsuccessfulException("Invalid date/ time");
        }
    }
    public String toString() {
        return "[D] " + super.toString() + String.format(" (by: %s)", dateTime.toString());
    }
}
