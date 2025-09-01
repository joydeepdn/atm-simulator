
import java.util.Scanner;
class MainMenu extends MainScreen{
    public void mainMenu(Scanner scan, NewUser n, ExistingUser ex, Customer c) {


        System.out.println("1->New-user\n2->Existing-user\n3->Exit");
        System.out.print("Enter choice:");
        try {
            userInput = scan.nextLine();
            while (!userInput.equals("3")) {
                switch (userInput) {

                    case "1": {
                        n.newUserAccountCreation(scan,c);
                        break;
                    }
                    case "2": {
                        ex.existingUser(scan, c);
                        break;
                    }
                    default: {
                        System.out.println("Invalid Choice!");
                    }
                }
                System.out.println("1->New-user\n2->Existing-user\n3->Exit");
                System.out.print("Enter Choice:");
                userInput = scan.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Input Mismatch, please ensure you enter proper inputs");
        } finally {
            System.out.println("Thank for using DEBNATH Bank");
        }
    }
}
