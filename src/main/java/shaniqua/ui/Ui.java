package shaniqua.ui;

import java.util.Scanner;

public class Ui {
    private final Scanner input;
    public Ui() {
        this.input = new Scanner(System.in);
    }
    public void greeting() {
        System.out.print("Kia Ora! I'm Shaniqua! What can I do you for?\n");
    }
    public void farewell() {
        System.out.println("Bye. Hope to see you again soon!");
    }
    public void confirmMessage(String msg) {
    }
    public boolean isConfirmed(String msg) {
        System.out.println(msg + " Confirm? (Y/n)");
        if (readCommand().equals("Y")) {
            System.out.println("Confirmed.");
            return true;
        }
        System.out.println("Not Confirmed.");
        return false;
    }
    public String readCommand() {
        return input.nextLine();
    }
    public void error(Exception e) {
        System.out.println("Oops, I can't do that because:");
        System.out.println(e.getMessage());
    }
    public void invalidInput() {
        System.out.println("I didn't quite get that, could you give it another go?");
    }
    private void printStraightLine() {
        for (int i = 0; i < 20; i++) {
            System.out.print("─");
        }
        System.out.print("\n");
    }
}
