package Shaniqua.Command;

import Shaniqua.Storage.Storage;
import Shaniqua.Storage.StorageException;
import Shaniqua.TaskCore.TaskList;
import Shaniqua.UI.Ui;

import java.io.IOException;

public class LoadCommand extends Command{
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
