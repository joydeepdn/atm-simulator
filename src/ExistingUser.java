
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

class ExistingUser extends MainScreen {

    private int Bal = 0;
    public void existingUser(Scanner scan, Customer c) throws InputMismatchException {

        int testCardNumber;
        int testPIN;

        HashMap<Integer,Integer> testInfo;
        /*
        * This retrieves the user account-Information from the Customer Class to validate user
        * */

      /*  testInfo = c.getAccountInfo();*/

        testInfo = c.getCusInfo();

        System.out.println("Enter account details:\n");
        System.out.println("Enter your Card Number:");
        testCardNumber = scan.nextInt();

       /*
          This will check the user entered Card Number and
          PIN, if Card Number and PIN is valid user is granted Access
         */

        for (int _ : testInfo.keySet()){
            if(testInfo.containsKey(testCardNumber)){
                System.out.println("Enter your 4 digit PIN:");
                testPIN = scan.nextInt();
                if(testInfo.containsValue(testPIN)){
                    scan.nextLine();
                    existingUserMenu(scan);
                }
                else {
                    System.out.println("Incorrect PIN!");
                }
            }
            else {
                System.out.println("Card No. not found in database!");
                scan.nextLine();
            }
        }
    }

    public void existingUserMenu(Scanner scan) {
        System.out.println("Enter your choice:");

        System.out.println("1->Deposit\n2->Withdraw\n3->Check Balance\n4->Quick Withdraw\n5->Back to Main Menu\n");
        userInput = scan.nextLine();

        while (!userInput.equals("5")) {
            switch (userInput) {
                case "1" -> Bal = depositAmt(scan);
                case "2" -> Bal = withdrawAmt(scan);
                case "3" -> System.out.println("Your Balance is:" + Bal);
                case "4" -> quickWithdraw(scan);
                default -> System.out.println("******************** Invalid Choice! ************************");
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
            System.out.println("Amount Successfully Deposited!");
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
            System.out.println("Amount Successfully Withdrawn!");
        }
        scan.nextLine();
        return Bal;
    }

    public void quickWithdraw(Scanner scan) {

        int amt = 0;

        HashMap<String,Integer> amountInfo = new HashMap<>();

        amountInfo.put("1",500);
        amountInfo.put("2",1000);
        amountInfo.put("3",1500);
        amountInfo.put("4",2000);

        System.out.println("Select amount to be withdrawn:");
        System.out.println("1->500\n2->1000\n3->1500\n4->2000\n5->Back");

        userInput = scan.nextLine();

        /*
        * This will check if the entered userInput is a key in the amountMap
        * */

        if(!amountInfo.containsKey(userInput)){
            System.out.println("Invalid choice!");
            return;
        }
        else {
            for (String _ : amountInfo.keySet()) {
                if (amountInfo.containsKey(userInput)) {
                    amt = amountInfo.get(userInput);
                }
            }
        }

        if (amt > Bal) {
            System.out.println("Not Enough Balance!");

        } else {
            switch (userInput) {
                case "1" -> Bal -= 500;
                case "2" -> Bal -= 1000;
                case "3" -> Bal -= 1500;
                case "4" -> Bal -= 2000;
            }
            System.out.println("Amount Successfully withdrawn!");
        }
    }
}
