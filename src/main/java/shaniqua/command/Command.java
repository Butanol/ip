package shaniqua.command;

import shaniqua.storage.Storage;
import shaniqua.taskcore.TaskList;
import shaniqua.ui.Ui;

public abstract class Command {
    protected boolean isExit = false;
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws CommandFailException;
    public boolean isExit() {
        return isExit;
    }
}
