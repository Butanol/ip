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
        System.out.println("Here are the matching tasks in your list:");
        tasks.find(searchTerm, ui);
    }
}
