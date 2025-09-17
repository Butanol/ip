package Shaniqua.Command;

import Shaniqua.Storage.Storage;
import Shaniqua.TaskCore.TaskList;
import Shaniqua.UI.Ui;

public class ListCommand extends Command{
    public void execute(TaskList tasks, Ui ui, Storage storage){
        tasks.list();
    }
}
