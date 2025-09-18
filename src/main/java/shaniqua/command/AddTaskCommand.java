package shaniqua.command;

import shaniqua.storage.Storage;
import shaniqua.taskcore.TaskList;
import shaniqua.taskcore.tasks.Task;
import shaniqua.ui.Ui;

public class AddTaskCommand extends Command {
    private Task task;
    public AddTaskCommand(Task task) {
        this.task = task;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
    }
}
