package shaniqua.command;

import shaniqua.storage.Storage;
import shaniqua.storage.StorageException;
import shaniqua.taskcore.TaskList;
import shaniqua.ui.Ui;

public class LoadCommand extends Command {
    /**
     * Executes the command to load tasks from local storage.
     * Warns user that loading may create duplicate tasks.
     *
     * @param tasks the task list to load tasks into
     * @param ui the user interface for getting user confirmation
     * @param storage the storage system to load tasks from
     */
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
