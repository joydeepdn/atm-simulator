import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class ExistingUser extends MainScreen {
    private int Bal = 0;


    public void existingUser(Scanner scan, CustomerInfo c) throws InputMismatchException {

        int testCardNumber;
        int testPIN;

        ArrayList<Integer> newarr;

        /*
        * This retrieves the user account-Information from the Customer Class to validate user
        * */

        newarr = c.getAccountInfo();


        System.out.println("Enter account details:\n");
        System.out.println("Enter your Card Number:");
        testCardNumber = scan.nextInt();

        /*
         * This will check the user entered Card Number and
         * PIN, if Card Number and PIN is valid user is granted Access
         * */


        for (int i = 0; i < newarr.size(); i = i + 2) {
            if (newarr.get(i) == testCardNumber) {
                System.out.println("Enter your 4 digit PIN:\n");
                testPIN = scan.nextInt();
                for (int j = i + 1; j < newarr.size(); j = j + 2) {
                    if (newarr.get(j) == testPIN) {
                        scan.nextLine();
                        existingUserMenu(scan);
                    } else {
                        System.out.println("**************** Incorrect PIN! *******************");
                    }
                }
            } else {
                System.out.println("**************** Card Number not found in database! *****************");
            }
        }
    }

    public void existingUserMenu(Scanner scan) {
        System.out.println("Enter your choice:");

        System.out.println("1->Deposit\n2->Withdraw\n3->Check Balance\n4->Quick Withdraw\n5->Back to Main Menu\n");
        userInput = scan.nextLine();

        while (!userInput.equals("5")) {
            switch (userInput) {
                case "1" -> {
                    Bal = depositAmt(scan);
                }
                case "2" -> {
                    Bal = withdrawAmt(scan);
                }
                case "3" -> {
                    System.out.println("Your Balance is:" + Bal);
                }
                case "4" -> {
                    Bal = quickWithdraw(scan);
                }
                default -> {
                    System.out.println("******************** Invalid Choice! ************************");
                }
            }
            System.out.println("Enter your choice:");
            System.out.println("1->Deposit\n2->Withdraw\n3->Balance-Checking\n4->Quick Withdraw\n5->Back to Main Menu\n");
            userInput = scan.nextLine();
        }
    }

    public int depositAmt(Scanner scan) {
        System.out.println("Enter Amount to be deposited:");
        int deposit = scan.nextInt();

        if (deposit < 0) {
            System.out.println("********************* Invalid Amount! *****************************");
        } else {
            Bal += deposit;
        }
        scan.nextLine();
        return Bal;
    }

    public int withdrawAmt(Scanner scan) {
        System.out.println("Enter amount to be withdrawn:");
        int wit = scan.nextInt();
        if (wit > Bal) {
            System.out.println("********************** Not Enough Balance! *************************");
        } else {
            Bal -= wit;
        }
        scan.nextLine();
        return Bal;
    }

    public int quickWithdraw(Scanner scan) {

        int amt = 0;

        System.out.println("Select amount to be withdrawn:");
        System.out.println("1->500\n2->1000\n3->1500\n4->2000\n5->Back");
        userInput = scan.nextLine();

        switch (userInput) {
            case "1" -> amt = 500;
            case "2" -> amt = 1000;
            case "3" -> amt = 1500;
            case "4" -> amt = 2000;
            default -> System.out.println("Invalid Input!");
        }

        if (amt > Bal) {
            System.out.println("Not Enough Balance!");
        } else {
            switch (userInput) {
                case "1" -> {
                    Bal -= 500;
                    System.out.println("Amount successfully Withdrawn!");
                }
                case "2" -> {
                    Bal -= 1000;
                    System.out.println("Amount successfully Withdrawn!");
                }
                case "3" -> {
                    Bal -= 1500;
                    System.out.println("Amount successfully Withdrawn!");
                }
                case "4" -> {
                    Bal -= 2000;
                    System.out.println("Amount successfully Withdrawn!");
                }
            }
        }
        return Bal;
    }
}
