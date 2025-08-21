import java.util.Scanner;

import java.util.ArrayList;

public class Shaniqua {
    public static void main(String[] args) {
        String[] tasks = new String[100];
        boolean[] done = new boolean[100];
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
                        System.out.printf("%d. [%s] %s\n", i + 1, done[i] ? "X" : " " , tasks[i]);
                    }
                }
            } else if (in.contains("mark")) {
                String[] temp = in.split(" ");
                if (temp.length > 2) {
                    System.out.println("Invalid mark input");
                    continue;
                }
                int nums = Integer.parseInt(temp[1]);
                done[nums] = !done[nums];
            } else {
                if (frontier < 100) {
                    tasks[frontier] = in;
                    frontier++;
                    System.out.printf("Added: %s\n", in);
                } else {
                    System.out.println("Maximum capacity reached");
                }
            }
        }
    }
}

