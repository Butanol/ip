package shaniqua;

import shaniqua.command.Command;
import shaniqua.gui.GuiController;
import shaniqua.parser.Parser;
import shaniqua.storage.Storage;
import shaniqua.taskcore.TaskList;
import shaniqua.ui.Ui;

import java.util.concurrent.CompletableFuture;

public class Shaniqua {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private GuiController controller;

    /**
     * Constructs Shaniqua object with filepath
     * @param filepath string input of folder path with respect to root
     */
    public Shaniqua(String filepath) {
        this.storage = new Storage(filepath);
        this.ui = new Ui();
        tasks = new TaskList();
    }

    /**
     * Runs chatbot
     */
    public void run() {
        GuiController.launch(this);
        ui.greeting();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.readCommand();
                Command cmd = Parser.parse(input);
                if (cmd == null) {
                    ui.invalidInput();
                    continue;
                }
                cmd.execute(tasks, ui, storage);
                isExit = cmd.isExit();
            } catch (ShaniquaException e) {
                ui.error(e);
            }
            ui.endOutput();
        }
        ui.farewell();
    }

    /**
     * Main argument that starts chatbot.
     * @param args
     */
    public static void main(String[] args) {
        new Shaniqua("data/tasks.ser").run();
    }

    public Ui getUi() {
        return ui;
    }
}

