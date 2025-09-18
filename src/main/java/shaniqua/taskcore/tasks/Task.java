package shaniqua.taskcore.tasks;

import java.io.Serializable;

public abstract class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean done;
    final String name;

    /**
     * Constructs Task object.
     * @param name name of task
     * @throws InvalidTaskDataException
     */
    public Task(String name) throws InvalidTaskDataException {
        if (name == "" || name == null) {
            throw new InvalidTaskDataException("Please input name");
        }
        this.name = name;
        this.done = false;
    }

    /**
     * Returns string representation of Task, including whether it is done
     * @return String representation of task
     */
    @Override
    public String toString() {
        return String.format("[%s] ", done ? "X" : " ") + name;
    }

    /**
     * marks Task as complete.
     */
    public void mark() {
        this.done = true;
    }

    /**
     * Marks Task as incomplete
     */
    public void unmark() {
        this.done = false;
    }

    /**
     * Returns completed status of task
     * @return boolean of status
     */
    public boolean getMarked() {
        return done;
    }

    public String getName() {
        return name;
    }

    /**
     * Compares Task Object with another for equality
     * @param object the object to compare with task.
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Task) {
            Task temp = (Task) object;
            return temp.name == this.name;
        }
        return false;
    }
}
