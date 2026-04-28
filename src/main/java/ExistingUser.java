
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

class ExistingUser{
    String userInput;
    Scanner scan;
    DatabaseManager db = new DatabaseManager();
    Connection con = db.getConnection();
    ResultSet rs;
    
    ExistingUser(Scanner scan){
        this.scan = scan;
    }

    public void existingUser() throws InputMismatchException {

        String test_cardnumber;
        String test_pin;
        String name;

        System.out.println("Enter account details");
        System.out.print("Enter your Card Number:");
        test_cardnumber = scan.nextLine();


        System.out.println("Enter Pin No.");
        test_pin = scan.nextLine();


        try{
            // int rowFound;

            String sql = "SELECT name, card_number, pin FROM customers WHERE card_number = ? AND pin = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, test_cardnumber);
            pstmt.setString(2, test_pin);

            rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println("User exists!");
                existingUserMenu();
            }
            else{
                System.out.println("User do not exist");
            }
        }catch(SQLException e){

            System.out.println("Error");
        }
    }


    public void existingUserMenu() {
        try{
        System.out.println("Welcome" + rs.getString("name"));
        }catch(SQLException e){
            System.out.println("Error..."+e.getMessage());
        }
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|  1.Deposit\n|  2.Withdraw\n|  3.Check Balance\n|  4.Quick Withdraw|  5.Back to Main Menu");
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.print("Enter Choice:");
        userInput = scan.nextLine();    
   
    }
}

    

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
