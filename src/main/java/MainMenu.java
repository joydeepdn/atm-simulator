
import java.util.Scanner;

class MainMenu extends MainScreen {
    public void mainMenu(Scanner scan, NewUser n, ExistingUser e, Customer c) {

        do {
            System.out.println("+----------------------------------+");
            System.out.println("|  1.New-user                      |\n|  2.Existing-user                 |\n|  3.Exit                          |");
            System.out.println("+----------------------------------+");

            System.out.print("Enter choice:");
            userInput = scan.nextLine();

            switch (userInput) {
                case "1": {
                    n.newUserAccountCreation();
                    break;
                }
                case "2": {
                    e.existingUser(c);
                    break;
                }
                case "3": {
                    System.out.println("Thank You");
                    break;
                }
                default: {
                    System.out.println("Invalid choice!");
                }
            }
        } while (!userInput.equals("3"));
    }
}
