import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.*;

public class DatabaseManager {

    Dotenv dotenv = Dotenv.load();
    

    private String url = dotenv.get("url");
    private String username = dotenv.get("username");
    private String password = dotenv.get("password");
    Connection con;

    void setConnection(){
    try{
        con = DriverManager.getConnection(url,username,password);
    }catch(SQLException e){
        System.out.println("Error connecting database..."+" "+e.getMessage());
    }
 } 
 Connection get_Connection(){
    return con;
    }
 }
