package shaniqua.ui;

import java.util.concurrent.CompletableFuture;

public class Ui {
    private StringBuilder outputString;
    private CompletableFuture<String> userResponse;
    private CompletableFuture<String> outputResponse;

    public Ui() {
        userResponse = new CompletableFuture<>();
        outputResponse = new CompletableFuture<>();
    }

    public void output(String message) {
        outputString.append(message).append("\n");
    }

    public String getOutput() {
        try {
            return outputResponse.get();
        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong!";
        }
    }

    public void endOutput() {
        outputResponse.complete(outputString.toString());
    }

    public String readCommand() {
        userResponse = new CompletableFuture<>();
        outputResponse = new CompletableFuture<>();
        clearOutput();
        try {
            return userResponse.get();
        } catch (Exception e) {
            return "n";
        }
    }

    /**
     * Completes response with string from GUI when response is given.
     * Reserved for GUI
     * @param response string representation of response;
     */
    public void provideResponse(String response) {
        if (userResponse != null) {
            userResponse.complete(response);
        }
    }

    public void clearOutput() {
        outputString = new StringBuilder();
    }

    public void greeting() {
        output("Kia Ora! I'm Shaniqua! What can I do you for?");
    }

    public void farewell() {
        output("Bye. Hope to see you again soon!");
    }

    public void taskAdded(String taskDescription, int totalTasks) {
        output("Got it. I've added this task:");
        output("  " + taskDescription);
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

    public void taskDeleted(String taskDescription, int totalTasks) {
        output("Noted. I've removed this task:");
        output("  " + taskDescription);
        output("Now you have " + totalTasks + " tasks in the list.");
    }

    public void showTasks(String taskList) {
        output(taskList);
    }

    public void showFoundTasks(String foundTasks) {
        output("Here are the matching tasks in your list:");
        if (foundTasks.trim().isEmpty()) {
            output("There aren't any tasks that match your search :(");
        } else {
            output(foundTasks);
        }
    }

    public void confirmMessage(String msg) {
        output(msg);
    }

    public boolean isConfirmed(String msg) {
        System.out.println(msg + " Confirm? (Y/n)");
        return readCommand().equals("Y");
    }

    public void error(Exception e) {
        output("Oops, I can't do that because:");
        output(e.getMessage());
    }

    public void invalidInput() {
        output("I didn't quite get that, could you give it another go?");
    }

    public void loadSuccess(int count) {
        output("Successfully loaded " + count + " tasks");
    }

    public void saveSuccess() {
        output("Tasks saved successfully!");
    }

}
