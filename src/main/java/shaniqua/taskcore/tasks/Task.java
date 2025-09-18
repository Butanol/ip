package shaniqua.taskcore.tasks;

import java.io.Serializable;

public abstract class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean done;
    final String name;
    public Task(String name) throws InvalidTaskDataException {
        if (name == "" || name == null) {
            throw new InvalidTaskDataException("Please input name");
        }
        this.name = name;
        this.done = false;
    }
    public String toString() {
        return String.format("[%s] ", done ? "X" : " ") + name;
    }
    public void mark() {
        this.done = true;
    }
    public void unmark() {
        this.done = false;
    }
    public boolean getMarked() {
        return done;
    }
    public boolean equals(Object O) {
        if (this == O) {
            return true;
        }
        if (O instanceof Task) {
            Task temp = (Task) O;
            return temp.name == this.name;
        }
        return false;
    }
}
