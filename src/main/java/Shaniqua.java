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
                    case "bye" -> {
                        System.out.println("Bye. Hope to see you again soon!");
                        return;
                    }
                    case "list" -> tasks.list();
                    case "mark" -> {
                        if (!Shaniqua.integerCheck(commands[1])) {
                            throw new ChatException("Invalid task");
                        }
                        int nums = Integer.parseInt(commands[1]);
                        tasks.mark(nums);
                        System.out.printf("Nice! I've marked this as done:\n%s\n", tasks.getTask(nums - 1));
                    }
                    case "unmark" -> {
                        if (!Shaniqua.integerCheck(commands[1])) {
                            throw new ChatException("Invalid task");
                        }
                        int nums = Integer.parseInt(commands[1]);
                        tasks.unmark(nums);
                        System.out.printf("Nice! I've marked this as done:\n%s\n", tasks.getTask(nums - 1));
                    }
                    case "remove" -> {
                        if (!Shaniqua.integerCheck(commands[1])) {
                            throw new ChatException("Invalid task");
                        }
                        int nums = Integer.parseInt(commands[1]);
                        tasks.remove(nums);
                    }
                    case "todo" -> tasks.addTask(new Todo(commands[1]));
                    case "deadline" -> {
                        String[] params = Shaniqua.handleDeadline(commands[1]);
                        tasks.addTask(new Deadline(params[0], params[1]));
                    }
                    case "event" -> {
                        String[] params = Shaniqua.handleEvent(commands[1]);
                        tasks.addTask(new Event(params[0], params[1], params[2]));
                    }
                }
            } catch (UnsuccessfulException e){
                System.out.println("Oh non, I can't do that ja. " + e.getMessage() + "!");
            } catch (ChatException e) {
                System.out.println("Oops, I've got an error: " + e.getMessage());
            }
        }
    }

    /**
     *
     * @param param an array of strings
     * @return String without the first argument
     */
    private static String[] handleInput(String param) {
        String[] temp = param.split(" ");
        StringBuilder x = new StringBuilder();
        for (int i = 1; i < temp.length; i++) {
            x.append(temp[i]);
        }
        return new String[]{temp[0], x.toString(), };
    }

    private static String[] handleDeadline(String param) throws ChatException {
        String[] res = param.split("/by");
        if (res.length == 1) throw new InsufficientException();
        return res;
    }
    private static String[] handleEvent(String param) throws ChatException{
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

