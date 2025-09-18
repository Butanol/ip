package shaniqua.taskcore;

import java.io.Serializable;
import java.util.ArrayList;

import shaniqua.taskcore.tasks.Task;

public class TaskList implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(Task x) {
        tasks.add(x);
    }
    public void list() {
        System.out.println("Here are the tasks in your list:");
        if (tasks.isEmpty()) {
            System.out.println("Looks pretty empty ja. Populate it with tasks!");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. " + tasks.get(i).toString() + "\n", i + 1);
        }
    }
    public void mark(int idx) throws TaskListException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new TaskListException("Task not found");
        }
        tasks.get(idx - 1).mark();
    }
    public void unmark(int idx) throws TaskListException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new TaskListException("Task not found");
        }
        tasks.get(idx - 1).unmark();
    }
    public void remove(int idx) throws TaskListException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new TaskListException("Task not found");
        }
        tasks.remove(idx - 1);
    }
    public Task getTask(int idx) {
        if (idx >= tasks.size()) {
            System.out.println("Invalid Task");
            return null;
        }
        return tasks.get(idx);
    }
    public int getLength() {
        return tasks.size();
    }
    public boolean equals(Object O) {
        if (O instanceof TaskList) {
            TaskList temp = (TaskList) O;
            if (temp.getLength() == this.getLength()){
                for (int i = 0; i < this.getLength(); i++) {
                    if (this.getTask(i).equals(temp.getTask(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
