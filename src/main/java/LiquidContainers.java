
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;
        while (true) {
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");
            String input = scan.nextLine();
            String[] parts = input.split(" ");

            if (parts.length != 2) {
                if (input.equals("quit")) {
                    break;
                }
                continue;
            }

            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                if (amount < 0) {
                    System.out.println("");
                    continue;
                }
                firstContainer += amount;
                if (firstContainer > 100) {
                    firstContainer = 100;
                }
                System.out.println("");
            }
            if (command.equals("move")) {
                if (amount < 0) {
                    System.out.println("");
                    continue;
                }
                if (firstContainer < amount) {
                    int amountToMove = firstContainer;
                    firstContainer = 0;
                    secondContainer += amountToMove;
                    if (secondContainer > 100) {
                        secondContainer = 100;
                    }
                } else {
                    firstContainer -= amount;
                    secondContainer += amount;
                    if (secondContainer > 100) {
                        secondContainer = 100;
                    }
                }
                System.out.println("");
            }
            if (command.equals("remove")) {
                if (amount < 0) {
                    System.out.println("");
                    continue;
                }
                if (secondContainer < amount) {
                    secondContainer = 0;
                } else {
                    secondContainer -= amount;
                }
                System.out.println("");
            }
        }
    }
}
