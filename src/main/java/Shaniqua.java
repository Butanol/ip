import java.util.Scanner;

public class Shaniqua {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Kia Ora! I'm Shaniqua!\nWhat can I do for you?\n");
        while (true) {
            String in = input.nextLine();
            if (in.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            }
            System.out.println(in);
        }
    }
}
