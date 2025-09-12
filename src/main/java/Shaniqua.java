import java.io.IOException;
import java.util.Objects;
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
                    break;
                case "list":
                    tasks.list();
                    break;
                case "mark":
                    if (!Shaniqua.integerCheck(commands[1])) {
                        throw new ChatException("Invalid task");
                    }
                    int idxA = Integer.parseInt(commands[1]);
                    tasks.mark(idxA);
                    System.out.printf("Nice! I've marked this as done:\n%s\n",
                            tasks.getTask(idxA - 1));
                    break;
                case "unmark":
                    if (!Shaniqua.integerCheck(commands[1])) {
                        throw new ChatException("Invalid task");
                    }
                    int idxB = Integer.parseInt(commands[1]);
                    tasks.unmark(idxB);
                    System.out.printf("Nice! I've marked this as done:\n%s\n",
                            tasks.getTask(idxB - 1));
                    break;
                case "remove":
                    if (!Shaniqua.integerCheck(commands[1])) {
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
        }
        return new String[]{temp[0], res.toString()};
    }

    private static String[] handleDeadline(String param) throws ChatException {
        String[] res = param.split("/by");
        if (res.length == 1) throw new InsufficientException();
        return res;
    }
    private static String[] handleEvent(String param) throws ChatException {
        String[] res = param.split("/by|/from");
        if (res.length < 3) throw new InsufficientException();
        return param.split("/to|/from");
    }
    private static boolean integerCheck(String param) {
        try {
            Integer.valueOf(param);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}

