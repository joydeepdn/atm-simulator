
import java.sql.*;
import java.util.Scanner;
import java.util.regex.*;

class NewUser{

    private String name;
    private String cardNumber;
    private String pin;


    DatabaseManager db = new DatabaseManager();
    PreparedStatement pstmt;
    Connection con;
    Scanner scan;

    NewUser(Scanner scan){
        this.scan =  scan;
        this.db.setConnection();
        this.con = this.db.get_Connection();
    }

    public void newuserCreation(){

        System.out.println("Enter Name:");
        name = scan.nextLine();

        cardNumber = cardNumberGenerator();
        System.out.println(cardNumber + " " +"is your card number please note it down!");

        pin = pin();

        sendData();
    }
    
    String pin(){

        String pin_no = null;
        Pattern p = Pattern.compile("[0-9]{4}");
        Matcher m = null;

        while (true){

            System.out.print("Enter your 4 digit PIN:");
            pin_no = scan.nextLine();
            m = p.matcher(pin_no);
            if(m.matches()){
                break;
            }
            else{
                System.out.println("pin must be 4 digit...");
            }
        }
        return pin_no;
    }
    String cardNumberGenerator(){

        String card_number = Integer.toString((int)(Math.random() * 1000001));
        return card_number;

    }
    void sendData(){
        try{
            String sql = "INSERT INTO customers (full_name, balance, card_number, pin) VALUES (?,?,?,?)";

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1,name);
            pstmt.setString(2, "0");
            pstmt.setString(3,cardNumber);
            pstmt.setString(4, pin); 
            
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "no. of rows affected");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
                con.close();
                pstmt.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
    

