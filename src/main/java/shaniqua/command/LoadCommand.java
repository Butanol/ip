package shaniqua.command;

import shaniqua.storage.Storage;
import shaniqua.storage.StorageException;
import shaniqua.taskcore.TaskList;
import shaniqua.ui.Ui;

public class LoadCommand extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (ui.isConfirmed("Doing so may create duplicates.")) {
            try {
                storage.loadTasks(tasks);
            } catch (StorageException e) {
                return;
            }
        }
    }
}
