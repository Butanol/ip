package shaniqua.taskcore.tasks;

public class Todo extends Task {
    public Todo(String name) throws InvalidTaskDataException {
        super(name);
    }
    public String toString() {
        return "[T] " + super.toString();
    }
}
