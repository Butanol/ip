package Shaniqua;

import Shaniqua.Command.Command;
import Shaniqua.Parser.ParserException;
import Shaniqua.Storage.Storage;
import Shaniqua.TaskCore.TaskList;
import Shaniqua.UI.Ui;
import Shaniqua.Parser.Parser;

import java.util.Scanner;

public class Shaniqua {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    public Shaniqua(String filepath) {
        this.storage = new Storage(filepath);
        this.ui = new Ui();
        tasks = new TaskList();
    }

    public void run() {
        ui.greeting();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.readCommand();
                Command cmd = Parser.parse(input);
                if (cmd == null) {
                    ui.invalidInput();
                }
                cmd.execute(tasks, ui, storage);
                isExit = cmd.isExit();
            } catch (ShaniquaException e) {
                ui.error(e);
            }
        }
    }
    public static void main(String[] args) {
        new Shaniqua("data/tasks.ser").run();
    }
}

