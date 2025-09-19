package shaniqua.ui;

import shaniqua.Shaniqua;

import java.util.concurrent.CompletableFuture;

public class Ui {
    private StringBuilder outputString;
    private boolean isExited = false;

    public Ui() {
        outputString = new StringBuilder();
    }

    public String handle(String input, Shaniqua s) {
        clearOutput();
        s.handle(input);
        return outputString.toString();
    }

    public void output(String message) {
        outputString.append(message).append("\n");
    }

    public void clearOutput() {
        outputString = new StringBuilder();
    }

    public void farewell() {
        output("Bye. Hope to see you again soon!");
        isExited = true;
    }

    public boolean shouldExit() {
        return isExited;
    }

    public void taskAdded(String taskDescription, int totalTasks) {
        output("Got it. I've added this task:");
        output(totalTasks + ". " + taskDescription);
        output("Now you have " + totalTasks + " tasks in the list.");
    }

    public void taskMarked(String taskDescription) {
        output("Nice! I've marked this task as done:");
        output("  " + taskDescription);
    }

    public void taskUnmarked(String taskDescription) {
        output("OK, I've marked this task as not done yet:");
        output("  " + taskDescription);
    }

    public void taskDeleted(int totalTasks) {
        output("Task deleted successfully. Now you have " + totalTasks + " tasks in the list.");
    }

    public void showTasks(String taskList) {
        output("Here are the tasks in your list:");
        if (taskList.trim().isEmpty()) {
            output("Looks pretty empty now, add something!");
        } else {
            output(taskList);
        }
        output(taskList);
    }

    public void showFoundTasks(String foundTasks, int count) {
        output("Here are the matching tasks in your list:");
        if (count == 0) {
            output("There aren't any tasks that match your search :(");
        } else {
            output(foundTasks);
        }
    }

    public void error(Exception e) {
        output("Oops, I can't do that because:");
        output(e.getMessage());
    }

    public void invalidInput() {
        output("I didn't quite get that, could you give it another go?");
    }

    public void loadSuccess(int count) {
        output("Warning: Duplicates may be created.");
        output("Successfully loaded " + count + " tasks");
    }

    public void saveSuccess() {
        output("Tasks saved successfully!");
    }

}
