
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExistingUser {

    private String id;
    private String test_cardnumber;
    private String test_pin;
    private String Bal;

    String sql;
    String userInput;

    Scanner scan;
    DatabaseManager db = new DatabaseManager();
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    Pattern pt = Pattern.compile("[0-9]{0,5}");
    Matcher mt;


    ExistingUser(Scanner scan) {
        this.scan = scan;
    }

    public void existingUser() throws InputMismatchException {

        this.db.setConnection();
        this.con = db.get_Connection();

        System.out.println("Enter account details");
        System.out.print("Enter your Card Number:");
        test_cardnumber = scan.nextLine();

        System.out.print("Enter Pin No:");
        test_pin = scan.nextLine();

        try{

            sql = "SELECT id, full_name, balance FROM customers WHERE card_number = ? AND pin = ?";

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, test_cardnumber);
            pstmt.setString(2, test_pin);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                id = rs.getString("id");
                existingUserMenu();
            } else {
                System.out.println("User do not exist");
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    public void existingUserMenu() {
        try {
            System.out.println("+------------------------------------------------+");
            System.out.println("Welcome"+" "+rs.getString("full_name"));
            System.out.println("+------------------------------------------------+");
        } catch (SQLException e) {
            System.out.println("Error..." + e.getErrorCode() + e.getMessage());
        }
        do{
        System.out.println("+---------------------------------+");
        System.out.println(
                "|  1.Deposit                      |\n|  2.Withdraw                     |\n|  3.Check Balance                |\n|  4.Back to Main Menu            |");
        System.out.println("+---------------------------------+");
        System.out.print("Enter Choice:");
        userInput = scan.nextLine();

        switch (userInput) {
            case "1":
                deposit();
                break;
            case "2":
                withdraw();
                break;
            case "3":
                balance();
                break;
            case "4":
                try{
                    con.close();
                    pstmt.close();
                    rs.close();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice...");
        }
    }while (!userInput.equals("4")); 
    }

    void deposit() {
        System.out.print("Enter Amount to be deposited:$");
        String damt = scan.nextLine();
        mt = pt.matcher(damt);

        if (mt.matches()) {
            try{
                Bal = rs.getString("balance");

                int temp = Integer.parseInt(damt);
                int temp2 = Integer.parseInt(Bal);
                int temp3 = temp + temp2;
                Bal = Integer.toString(temp3);

                sql = "UPDATE customers SET balance = ? WHERE id = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Bal);
                pstmt.setString(2, id);

                int rowsAffected = pstmt.executeUpdate();

                System.out.println(rowsAffected + "Nos of row affected");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid Amount...");
        }
    }

    void withdraw() {
        System.out.print("Enter amount to be withdrawn:$");
        String wamt = scan.nextLine();
        mt = pt.matcher(wamt);
        if(mt.matches()){
            try{
                Bal = rs.getString("balance");
                int temp = Integer.parseInt(Bal);
                int temp2 = Integer.parseInt(wamt);

                if(temp2 > temp){
                    System.out.println("Insufficient amount...");
                }
                else{
                    int temp3 = temp - temp2;
                    Bal = Integer.toString(temp3);
                    sql = "UPDATE customers SET balance = ? WHERE id = ? ";
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, Bal);
                    pstmt.setString(2, id);
                    int rowsAffected = pstmt.executeUpdate();
                    System.out.println(rowsAffected+" "+"No. of row affected");
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    void balance(){
        try{
            Bal = rs.getString("balance");
            System.out.println("$"+ Bal);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}            
