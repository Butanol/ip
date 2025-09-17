package Shaniqua.Command;

import Shaniqua.Storage.Storage;
import Shaniqua.TaskCore.TaskList;
import Shaniqua.TaskCore.Tasks.Task;
import Shaniqua.UI.Ui;

public class AddTaskCommand extends Command{
    Task task;
    public AddTaskCommand(Task task) {
        this.task = task;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
    }
}
