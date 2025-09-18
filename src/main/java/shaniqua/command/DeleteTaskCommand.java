package shaniqua.command;

import shaniqua.storage.Storage;
import shaniqua.taskcore.TaskList;
import shaniqua.taskcore.TaskListException;
import shaniqua.ui.Ui;

public class DeleteTaskCommand extends ModifyCommand {
    public DeleteTaskCommand(int idx) {
        super(idx);
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) throws CommandFailException {
        try {
            tasks.remove(idx);
        } catch (TaskListException e) {
            throw new CommandFailException(e.getMessage());
        }
    }
}
