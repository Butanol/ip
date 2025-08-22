public class TaskList {
    private final Task[] tasks;
    private int right;
    public TaskList() {
        this.tasks = new Task[100];
        this.right = 0;
    }
    public void addTask(Task x) {
        tasks[right] = x;
        right++;
    }
    public void list() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < right; i++) {
            System.out.printf("%d. %s", i + 1, tasks[i]);
        }
    }
    public boolean mark(int idx) {
        if (idx > right || idx <= 0) {
            System.out.println("Invalid Task");
            return false;
        }
        tasks[idx - 1].mark();
        return true;
    }
    public boolean unmark(int idx) {
        if (idx > right || idx <= 0) {
            System.out.println("Invalid Task");
            return false;
        }
        tasks[idx - 1].unmark();
        return true;
    }
    public Task getTask(int idx) {
        if (idx > right || idx <= 0) {
            System.out.println("Invalid Task");
            return null;
        }
        return tasks[idx];
    }

}
