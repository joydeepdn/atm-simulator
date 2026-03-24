
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.*;

class NewUser extends MainScreen{


    private String cardNumber;
    private String pin;



    String url = "jdbc:mysql://localhost:3306/learning_jdbc";
    String username = "root";
    String password = "joydeep05102003";


    public void newUserAccountCreation(Scanner scan, Customer c) throws InputMismatchException{

        Pattern p = Pattern.compile("[0-9]{4}");
        Matcher m;

        /*
         * This will generate a random cardNumber for the user
         */
        


        System.out.printf(cardNumberGenerator());
        System.out.println(" "+"is your card number please note it down!");

        /*
         * This will check that the entered PIN is 4 digit and successfully creates an account
         * */

        while (true){

            System.out.print("Enter your 4 digit PIN:");
            pin = scan.nextLine();
            m = p.matcher(pin);
            if(m.matches()){
                break;
            }
            else{
                System.out.println("pin must be 4 digit...");
            }
        }
    }
    String cardNumberGenerator(){
        cardNumber = Integer.toString((int)(Math.random() * 1000001));
        return cardNumber;
    }
}

