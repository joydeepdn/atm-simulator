import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.*;

public class DatabaseManager {

    Dotenv dotenv = Dotenv.load();

    private String url = dotenv.get("url");
    private String username = dotenv.get("user");
    private String password = dotenv.get("password");

    Connection con;

    void setConnection(){
    try{
        con = DriverManager.getConnection(url,username,password);
    }catch(SQLException e){
        System.out.println(username+password+url);
        System.out.println("Error connecting database..."+" "+e.getErrorCode());
    }
 } 
 Connection get_Connection(){
    return con;
    }
 }
