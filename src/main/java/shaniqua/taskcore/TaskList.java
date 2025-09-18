package shaniqua.taskcore;

import java.io.Serializable;
import java.util.ArrayList;

import shaniqua.taskcore.tasks.Task;

public class TaskList implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ArrayList<Task> tasks;

    /**
     * Constructs TaskList
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds Task to TaskList
     * @param task Task to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Prints out a numbered list of tasks in TaskList
     */
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

    /**
     * Marks task at index as completed
     * @param idx integer of position of task in TaskList
     * @throws TaskListException if task is not found
     */
    public void mark(int idx) throws TaskListException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new TaskListException("Task not found");
        }
        tasks.get(idx - 1).mark();
    }

    /**
     * Marks task at index as uncompleted
     * @param idx integer of position of task in TaskList
     * @throws TaskListException if task is not found
     */
    public void unmark(int idx) throws TaskListException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new TaskListException("Task not found");
        }
        tasks.get(idx - 1).unmark();
    }

    /**
     * Removes task at index
     * @param idx integer of position of task in TaskList
     * @throws TaskListException if task is not found
     */
    public void remove(int idx) throws TaskListException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new TaskListException("Task not found");
        }
        tasks.remove(idx - 1);
    }

    /**
     * Returns Task at index
     * @param idx integer of position of task in TaskList
     * @return Task at index.
     */
    public Task getTask(int idx) {
        if (idx >= tasks.size()) {
            System.out.println("Invalid Task");
            return null;
        }
        return tasks.get(idx);
    }

    /**
     * Prints list of items in search
     * @param searchTerm String to search for
     */
    public void find(String searchTerm) {
        int count = 0;
        for (int i = 0; i < getLength(); i++) {
            if (getTask(i).getName().contains(searchTerm)) {
                System.out.printf("%d. " + tasks.get(i).toString() + "\n", i + 1);
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println("There aren't any tasks that match your search :(");
        }
    }

    /**
     * Returns number of tasks in TaskList
     * @return integer of the number of tasks in TaskList
     */
    public int getLength() {
        return tasks.size();
    }

    /**
     * Compares instance of TaskList with Object O for equality
     * @param object object to be compared with TaskList
     * @return boolean of equality
     */
    public boolean equals(Object object) {
        if (object instanceof TaskList) {
            TaskList temp = (TaskList) object;
            if (temp.getLength() == this.getLength()) {
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
