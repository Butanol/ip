import java.util.Scanner;

public class Shaniqua {
    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        Scanner input = new Scanner(System.in);
        System.out.print("Kia Ora! I'm Shaniqua!\nWhat can I do for you?\n");
        while (true) {
            String in = input.nextLine();
            String[] commands = Shaniqua.handleInput(in);
            if (commands[0].equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            } else if (commands[0].equals("list")) {
                tasks.list();
            } else if (commands[1].contains("mark")) {
                if (!Shaniqua.integerCheck(commands[1])) {
                    System.out.println("Invalid Task");
                    continue;
                }
                int nums = Integer.parseInt(commands[1]);
                if (tasks.mark(nums)) {
                    System.out.printf("Nice! I've marked this as done:\n%s\n", tasks.getTask(nums - 1));
                }
            } else if (commands[0].equals("unmark")) {
                String[] temp = in.split(" ");
                if (temp.length > 2) {
                    System.out.println("Invalid mark input");
                    continue;
                }
                int nums = Integer.parseInt(temp[1]);
                if (tasks.unmark(nums)) {
                    System.out.printf("Nice! I've marked this as done:\n%s\n", tasks.getTask(nums - 1));
                }
            } else if (commands[0].equals("todo")){
                tasks.addTask(new Todo(commands[1]));
            } else if (commands[0].equals("deadline")) {
                String[] params = Shaniqua.handleDeadline(commands[1]);
                tasks.addTask(new Deadline(params[0], params[1]));
            } else if (commands[0].equals("event")){
                String[] params = Shaniqua.handleEvent(commands[1]);
                tasks.addTask(new Event(params[0], params[1], params[2]));
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
    private static String[] handleDeadline(String param) {
        return param.split("/by");
    }
    private static String[] handleEvent(String param) {
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

