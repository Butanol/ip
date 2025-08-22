import java.util.Scanner;

public class Shaniqua {
    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        int frontier = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Kia Ora! I'm Shaniqua!\nWhat can I do for you?\n");
        while (true) {
            String in = input.nextLine();
            if (in.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            } else if (in.equals("list")) {
                for (int i = 0; i < frontier; i++) {
                    if (tasks[i] != null) {
                        System.out.printf("%d. %s\n", i + 1, tasks[i]);
                    }
                }
            } else if (in.contains("mark")) {
                String[] temp = in.split(" ");
                if (temp.length > 2) {
                    System.out.println("Invalid mark input");
                    continue;
                }
                int nums = Integer.parseInt(temp[1]);
                if (nums > frontier || nums <= 0) {
                    System.out.println("Invalid Task");
                    continue;
                }
                tasks[nums + 1].mark();
                System.out.printf("Nice! I've marked this as done:\n%s\n", tasks[nums + 1]);
            } else if (in.contains("unmark")) {
                String[] temp = in.split(" ");
                if (temp.length > 2) {
                    System.out.println("Invalid mark input");
                    continue;
                }
                int nums = Integer.parseInt(temp[1]);
                if (nums >= frontier) {
                    System.out.println("Invalid Task");
                    continue;
                }
                tasks[nums + 1].unmark();
                System.out.printf("Nice! I've marked this as done:\n%s\n", tasks[nums + 1]);
            } else {
                if (frontier < 100) {
                    tasks[frontier] = new Task(in);
                    frontier++;
                    System.out.printf("Added: %s\n", in);
                } else {
                    System.out.println("Maximum capacity reached");
                }
            }
        }
    }
}

