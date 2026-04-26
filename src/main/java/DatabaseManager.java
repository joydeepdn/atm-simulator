import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private String url = "jdbc:mysql://localhost:3306/learning_jdbc";
    private String username = "root";
    private String password = "joydeep05102003";
    Connection con;

    void setConnection(){
    try{
        con = DriverManager.getConnection(url,username,password);
    }catch(SQLException e){
        System.out.println("Error connecting database..."+" "+e.getMessage());
    }
 } 
 Connection getConnection(){
    return con;
 } 
}
