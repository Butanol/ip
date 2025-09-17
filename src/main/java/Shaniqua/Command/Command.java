package Shaniqua.Command;

import Shaniqua.Storage.Storage;
import Shaniqua.TaskCore.TaskList;
import Shaniqua.UI.Ui;

public abstract class Command {
    protected boolean isExit = false;
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws CommandFailException;
    public boolean isExit() {
        return isExit;
    }
}
