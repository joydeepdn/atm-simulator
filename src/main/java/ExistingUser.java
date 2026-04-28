
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExistingUser{

    private String Bal;
    String sql;
    String userInput;
    Scanner scan;
    Pattern pt = Pattern.compile("[0-9]{0,5}");
    Matcher mt;
    DatabaseManager db = new DatabaseManager();
    Connection con = db.getConnection();
    PreparedStatement pstmt;
    ResultSet rs;
    
    ExistingUser(Scanner scan){
        this.scan = scan;
    }

    public void existingUser() throws InputMismatchException {

        String test_cardnumber;
        String test_pin;

        System.out.println("Enter account details");
        System.out.print("Enter your Card Number:");
        test_cardnumber = scan.nextLine();


        System.out.print("Enter Pin No:");
        test_pin = scan.nextLine();


        try{
            // int rowFound;

            sql = "SELECT full_name, balance card_number, pin FROM customers WHERE card_number = ? AND pin = ?";

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, test_cardnumber);
            pstmt.setString(2, test_pin);

            rs = pstmt.executeQuery();

            if(rs.next()){
                existingUserMenu();
            }
            else{
                System.out.println("User do not exist");
            }
        }catch(SQLException e){

            System.out.println("Error"+e.getMessage());
        }
    }


    public void existingUserMenu() {
        try{
        System.out.println("Welcome"+" "+ rs.getString("full_name"));
        }catch(SQLException e){
            System.out.println("Error..."+e.getErrorCode()+e.getMessage());
        }
        System.out.println("+---------------------------------+");
        System.out.println("|  1.Deposit                      |\n|  2.Withdraw                     |\n|  3.Check Balance                |\n|  4.Quick Withdraw               |\n|  5.Back to Main Menu            |");
        System.out.println("+---------------------------------+");
        System.out.print("Enter Choice:");
        userInput = scan.nextLine();

        switch (userInput) {
            case "1":
            depositAmt();
        }
            
}

    

    void depositAmt() {
        System.out.print("Enter Amount to be deposited:$");
        String amt = scan.nextLine();
        mt = pt.matcher(amt);
        if(mt.matches()){
            try{
            Bal = rs.getString("balance");
            System.out.println(Bal);
            int temp = Integer.parseInt(amt);
            int temp2 = Integer.parseInt(Bal);
            int temp3 = temp + temp2;
            Bal = Integer.toString(temp3);
            sql = "UPDATE customers SET balance = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Bal);
            }
            catch(SQLException e){
                System.out.println("Error ocurred..."+e.getMessage());
            }
        }
        else{
            System.out.println("Invalid Amount...");
        }
    }
}

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
