import java.util.Date;

public class Deadline extends Task{
    private String by;
    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }
    public String toString() {
        return "[D] " + super.toString() + String.format(" (by: %s)", by);
    }
}
