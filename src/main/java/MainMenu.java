import java.util.Scanner;

class MainMenu{

    String userInput;

    Scanner scan = new Scanner(System.in);
    NewUser newuser = new NewUser(scan);
    ExistingUser existinguser = new ExistingUser(scan);

            public void mainMenu() {
        do {
            System.out.println("+----------------------------------+");
            System.out.println("|  1.New-user                      |\n|  2.Existing-user                 |\n|  3.Exit                          |");
            System.out.println("+----------------------------------+");

            System.out.print("Enter choice:");
            userInput = scan.nextLine();

            switch (userInput) {
                case "1": {
                    newuser.newuserCreation();
                    break;
                }
                case "2": {
                    existinguser.existingUser();
                    break;
                }
                case "3": {
                    System.out.println("Thank You");
                    scan.close();
                    break;
                }
                default: {
                    System.out.println("Invalid choice!");
                }
            }
        } while (!userInput.equals("3"));
    }
}
