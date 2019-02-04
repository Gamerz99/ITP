package transportmanagement;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class dbconnect{
    public static Connection connect()
    {
        Connection conn = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","");
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
        return conn;
    }
}
