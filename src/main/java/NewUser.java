
import java.sql.*;
import java.util.Scanner;
import java.util.regex.*;

class NewUser extends MainScreen{

    private String url = "jdbc:mysql://localhost:3306/learning_jdbc";
    private String username = "root";
    private String password = "joydeep05102003";  
    private String name;
    private String cardNumber;
    private String pin; 
    Scanner scan = new Scanner(System.in);


    public void newUserAccountCreation(){

        System.out.println("Enter Name:");
        name = scan.nextLine();

        cardNumber = cardNumberGenerator();
        System.out.println(cardNumber + " " +"is your card number please note it down!");

        pin = pin();

        custData();

    }

        /*
         * This will check that the entered PIN is 4 digit and successfully creates an account
         * */
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
    void custData(){
        try(Connection con = DriverManager.getConnection(url, username, password)){

            System.out.println("success....");


            String sql = "INSERT INTO customers (full_name, balance, card_number, pin) VALUES (?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1,name);
            pstmt.setInt(2, 0);
            pstmt.setString(3,cardNumber);
            pstmt.setString(4, pin); 
            
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "no. of rows affected successfully");

        }catch(SQLException e){
            System.out.println("error conncecting database...."+ e.getErrorCode()+ e.getMessage());
        }
    }
}
    

