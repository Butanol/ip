package Shaniqua;

import java.io.Serializable;

import static Shaniqua.Shaniqua.isInteger;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean done;
    private final String name;
    public Task(String name) throws InsufficientException{
        if (name == "" || name == null) {
            throw new InsufficientException();
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

}
