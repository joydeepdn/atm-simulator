
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

class ExistingUser{

    // private int Bal = 0;
    // Scanner scan = new Scanner(System.in);
    Scanner scan;
    DatabaseManager db = new DatabaseManager();
    Connection con = db.getConnection();
    
    ExistingUser(Scanner scan){
        this.scan = scan;
    }

    public void existingUser() throws InputMismatchException {

        String test_cardnumber;
        String test_pin;

        // HashMap<String,String> testInfo;
        /*
        * This retrieves the user account-Information from the Customer Class to validate user
        * */

      /*  testInfo = c.getAccountInfo();*/

        // testInfo = c.getCusInfo();

        System.out.println("Enter account details");
        System.out.print("Enter your Card Number:");
        test_cardnumber = scan.nextLine();

       /*
          This will check the user entered Card Number and
          PIN, if Card Number and PIN is valid user is granted Access
         */

    //         if(testInfo.containsKey(testCardNumber)){
    //             System.out.print("Enter your 4 digit PIN:");

    //             testPIN = scan.nextLine();

    //             if(testInfo.containsValue(testPIN)){
    //                 scan.nextLine();
    //                 existingUserMenu(scan);
    //             }
    //             else {
    //                 System.out.println("Incorrect PIN!");
    //             }
    //         }
    //         else {
    //             System.out.println("Card No. not found in database!");
    //             scan.nextLine();
    //         }
    // }
        test_pin = scan.nextLine();


        try{
            // int rowFound;

            String sql = "SELECT card_number, pin FROM customers WHERE card_number = ? AND pin = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, test_cardnumber);
            pstmt.setString(2, test_pin);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println("User exists!");
                // existingUserMenu();
            }
            else{
                System.out.println("User do not exist");
            }
        }catch(SQLException e){

            System.out.println("Error");
        }
    }
}

//     public void existingUserMenu() {

//         System.out.println("1->Deposit\n2->Withdraw\n3->Check Balance\n4->Quick Withdraw\n5->Back to Main Menu");
//         System.out.print("Enter Choice:");
//         userInput = scan.nextLine();

//         while (!userInput.equals("5")) {
//             switch (userInput) {
//                 case "1" -> Bal = depositAmt(scan);
//                 case "2" -> Bal = withdrawAmt(scan);
//                 case "3" -> System.out.println("Your Balance is:" + Bal);
//                 case "4" -> quickWithdraw(scan);
//                 default -> System.out.println("Invalid Choice!");
//             }
//             System.out.println("1->Deposit\n2->Withdraw\n3->Balance-Checking\n4->Quick Withdraw\n5->Back to Main Menu");
//             System.out.print("Enter Choice:");
//             userInput = scan.nextLine();
//         }
//     }

//     public int depositAmt(Scanner scan) {
//         System.out.print("Enter Amount to be deposited:");
//         int deposit = scan.nextInt();

//         if (deposit < 0) {
//             System.out.println("Invalid Amount!");
//         } else {
//             Bal += deposit;
//             System.out.println("Amount Successfully Deposited!");
//         }
//         scan.nextLine();
//         return Bal;
//     }

//     public int withdrawAmt(Scanner scan) {
//         System.out.print("Enter amount to be withdrawn:");
//         int wit = scan.nextInt();
//         if (wit > Bal) {
//             System.out.println("Not Enough Balance!");
//         } else {
//             Bal -= wit;
//             System.out.println("Amount Successfully Withdrawn!");
//         }
//         scan.nextLine();
//         return Bal;
//     }

//     public void quickWithdraw(Scanner scan) {

//         int amt = 0;

//         HashMap<String,Integer> amountInfo = new HashMap<>();

//         amountInfo.put("1",500);
//         amountInfo.put("2",1000);
//         amountInfo.put("3",1500);
//         amountInfo.put("4",2000);

//         System.out.println("Select amount to be withdrawn:");
//         System.out.println("1->500\n2->1000\n3->1500\n4->2000\n5->Back");

//         userInput = scan.nextLine();

//         /*
//         * This will check if the entered userInput is a key in the amountMap
//         * */

//         if(!amountInfo.containsKey(userInput)){
//             System.out.println("Invalid choice!");
//             return;
//         }
//         else {
//             for (String _ : amountInfo.keySet()) {
//                 if (amountInfo.containsKey(userInput)) {
//                     amt = amountInfo.get(userInput);
//                 }
//             }
//         }

//         if (amt > Bal) {
//             System.out.println("Not Enough Balance!");

//         } else {
//             switch (userInput) {
//                 case "1" -> Bal -= 500;
//                 case "2" -> Bal -= 1000;
//                 case "3" -> Bal -= 1500;
//                 case "4" -> Bal -= 2000;
//             }
//             System.out.println("Amount Successfully withdrawn!");
//         }
//     }
// }
