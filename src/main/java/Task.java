public class Task {
    private boolean done;
    private final String name;
    public Task(String name) {
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
}
