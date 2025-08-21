import java.util.Scanner;

import java.util.ArrayList;

public class Shaniqua {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        System.out.print("Kia Ora! I'm Shaniqua!\nWhat can I do for you?\n");
        while (true) {
            String in = input.nextLine();
            if (in.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            } else if (in.equals("list")) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, tasks.get(i));
                }
            } else {
                tasks.add(in);
                System.out.printf("Added: %s\n", in);
            }
        }
    }
}
