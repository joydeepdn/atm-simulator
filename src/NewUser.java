
import java.util.InputMismatchException;
import java.util.Scanner;

class NewUser extends MainScreen{
    public void newUserAccountCreation(Scanner scan, Customer c) throws InputMismatchException{

        int cardNumber;
        int PIN;
        String test = "";

        /*
         * This will generate a random cardNumber for the user
         */

        cardNumber = (int) (Math.random() * 1000001);

        System.out.printf("'%d'",cardNumber);
        System.out.println(" "+"is your card number please note it down!");

        /*
         * This will check that the entered PIN is 4 digit and successfully creates an account
         * */

        while (test.length() != 4) {

            System.out.print("Enter your 4 digit PIN:");
            PIN = scan.nextInt();
            test = String.valueOf(PIN);

            if (test.length() == 4) {
                System.out.println("Account created successfully");
                c.setAccountInfo(cardNumber,PIN);
                scan.nextLine();

            } else {
                System.out.println("PIN must be 4 digit!");
            }
        }
    }
}
