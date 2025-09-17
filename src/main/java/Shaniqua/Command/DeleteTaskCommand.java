package Shaniqua.Command;

import Shaniqua.Storage.Storage;
import Shaniqua.TaskCore.TaskList;
import Shaniqua.TaskCore.TaskListException;
import Shaniqua.UI.Ui;

public class DeleteTaskCommand extends ModifyCommand{
    public DeleteTaskCommand(int idx) {
        super(idx);
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) throws CommandFailException{
        try {
            tasks.remove(idx);
        } catch (TaskListException e) {
            throw new CommandFailException(e.getMessage());
        }
    }
}
