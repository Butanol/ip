package shaniqua.command;

import shaniqua.storage.Storage;
import shaniqua.taskcore.TaskList;
import shaniqua.ui.Ui;

public class FindCommand extends Command {
    private String searchTerm;
    public FindCommand(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.find(searchTerm, ui);
    }
}
