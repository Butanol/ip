package Shaniqua;

public class Todo extends Task {
    public Todo(String name) throws InsufficientException {
        super(name);
    }
    public String toString() {
        return "[T] " + super.toString();
    }
}
