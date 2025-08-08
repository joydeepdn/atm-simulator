
import java.util.Scanner;

class MainMenu extends MainScreen{
    public void mainMenu(Scanner scan, NewUser n, ExistingUser ex, MainMenu m, CustomerInfo c){

        System.out.println("\nPlease Enter your Choice:\n");
        System.out.println("1->New-user\n2->Existing-user\n3->Exit\n");
        try{
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
                            System.out.println("************** Invalid choice...! ******************\n");
                        }
                    }
                    System.out.println("Enter your choice:\n");
                    System.out.println("1->New-user\n2->Existing-user\n3->Exit\n");
                    userInput = scan.nextLine();
            }
        } catch (Exception e) {
            System.out.println("*********** Input Mismatch Please ensure you enter proper Input **************\n");
        }
        System.out.println("\nThank for using DEBNATH Bank\n");
    }
}
