package dbconnect;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class dbconnect {
    public static Connection connect()
    {
        Connection con=null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
}
