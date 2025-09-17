package Shaniqua.Command;

import Shaniqua.Storage.Storage;
import Shaniqua.TaskCore.TaskList;
import Shaniqua.UI.Ui;

public class MarkCommand extends ModifyCommand{
    public MarkCommand(int idx) {
        super(idx);
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.getTask(idx).mark();
    }
}
