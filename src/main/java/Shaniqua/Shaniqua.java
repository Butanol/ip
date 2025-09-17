package Shaniqua;

import java.io.IOException;

import java.util.Scanner;

public class Shaniqua {
    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        Scanner input = new Scanner(System.in);
        System.out.print("Kia Ora! I'm Shaniqua!\nWhat can I do for you?\n");
        while (true) {
            try {
                String in = input.nextLine();
                String[] commands = Shaniqua.handleInput(in);
                switch (commands[0]) {
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!");
                    return;
                case "list":
                    tasks.list();
                    break;
                case "mark":
                    if (!Shaniqua.isInteger(commands[1])) {
                        throw new ChatException("Invalid task");
                    }
                    int idxA = Integer.parseInt(commands[1]);
                    tasks.mark(idxA);
                    System.out.printf("Nice! I've marked this as done:\n%s\n",
                            tasks.getTask(idxA - 1));
                    break;
                case "unmark":
                    if (!Shaniqua.isInteger(commands[1])) {
                        throw new ChatException("Invalid task");
                    }
                    int idxB = Integer.parseInt(commands[1]);
                    tasks.unmark(idxB);
                    System.out.printf("Nice! I've marked this as done:\n%s\n",
                            tasks.getTask(idxB - 1));
                    break;
                case "remove":
                    if (!Shaniqua.isInteger(commands[1])) {
                        throw new ChatException("Invalid task");
                    }
                    int idxC = Integer.parseInt(commands[1]);
                    tasks.remove(idxC);
                    break;
                case "todo":
                    tasks.addTask(new Todo(commands[1]));
                    break;
                case "deadline":
                    String[] paramsDeadline = Shaniqua.
                            handleDeadline(commands[1]);
                    tasks.addTask(new Deadline(paramsDeadline[0],
                            paramsDeadline[1]));
                    break;
                case "event":
                    String[] paramsEvents = Shaniqua.
                            handleEvent(commands[1]);
                    tasks.addTask(new Event(paramsEvents[0], paramsEvents[1],
                            paramsEvents[2]));
                    break;
                case "save":
                    tasks.saveToFile();
                    break;
                case "load":
                    System.out.println("Doing so will replace the entire list. Are you sure? (y/n)");
                    if (input.nextLine().equalsIgnoreCase("y")) {
                        tasks.loadTasks();
                    }
                }
            } catch (UnsuccessfulException e) {
                System.out.println("Oh non, I can't do that ja. " + e.getMessage()
                        + "!");
            } catch (ChatException e) {
                System.out.println("Oops, I've got an error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Oops, I can't do that! " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param param input string
     * @return String without the first argument
     */
    private static String[] handleInput(String param) {
        String[] temp = param.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < temp.length; i++) {
            res.append(temp[i]);
            res.append(" ");
        }
        return new String[]{temp[0], res.toString().trim()};
    }

    private static String[] handleDeadline(String param) throws ChatException {
        String[] res = param.split("/by");
        if (res.length < 2) throw new InsufficientException();
        return new String[]{res[0].trim(), res[1].trim()};
    }
    private static String[] handleEvent(String param) throws ChatException {
        String[] res = param.split(" ");
        String[] reorderedString = new String[3];
        if (res.length < 5) throw new InsufficientException();
        reorderedString[0] = res[0];
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i].trim();
            if (res[i].isEmpty()) {
                throw new InsufficientException();
            }
            if (res[i].equals("/to")) {
                if (i + 1 >= res.length) {
                    throw new InsufficientException();
                }
                reorderedString[2] = res[i + 1].trim();
            } else if (res[i].equals("/from")) {
                if (i + 1 >= res.length) {
                    throw new InsufficientException();
                }
                reorderedString[1] = res[i + 1].trim();
            }
        }
        return reorderedString;
    }
    protected static boolean isInteger(String param) {
        try {
            Integer.valueOf(param);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

}

