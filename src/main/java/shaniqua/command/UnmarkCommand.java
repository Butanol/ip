package shaniqua.command;

import shaniqua.storage.Storage;
import shaniqua.taskcore.TaskList;
import shaniqua.ui.Ui;

public class UnmarkCommand extends ModifyCommand {
    public UnmarkCommand(int idx) {
        super(idx);
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.getTask(idx).unmark();
    }
}
