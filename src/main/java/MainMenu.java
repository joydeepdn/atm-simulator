
import java.util.Scanner;
class MainMenu extends MainScreen{
    public void mainMenu(Scanner scan, NewUser n, ExistingUser ex, Customer c) {


        System.out.println("1->New-user\n2->Existing-user\n3->Exit");
        System.out.print("Enter choice:");


            String userInput = scan.nextLine();
            while (!userInput.equals("3")) {

                switch (userInput) {
                    case "1": {
                        n.newUserAccountCreation();
                        break;
                    }
                    case "2": {
                        ex.existingUser(scan, c);
                        break;
                    }
                    case "3": {
                        System.out.println("Thankyou");
                        break;
                    }
                    default : {
                        System.out.println("Invalid choice!");
                    }
                }
                System.out.println("1->New-user\n2->Existing-user\n3->Exit");
                System.out.print("Enter Choice:");
                userInput = scan.nextLine();
            }
        }
    }
