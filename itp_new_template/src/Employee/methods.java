
package Employee;

import dbconnect.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class methods {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int year=Calendar.getInstance().get(Calendar.YEAR);
    int month=Calendar.getInstance().get(Calendar.MONTH)+1;
    DateFormat day=new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal=Calendar.getInstance();
    String dates=day.format(cal.getTime());
    
    //Constructor
    public methods()
    {
        conn=dbconnect.connect();
    }
    //Check whether a text field has letters
    public boolean check_txt_field(String txt)
    {
        int x=txt.length();
        for(int i=0;i<x;i++)
        {
            char c=txt.charAt(i);
            if(Character.isLetter(c)&&c!='.')
                return false;
        }
        return true;
    }
    
    //------------------Emp_Details----------------------
    public boolean check_names(String Name,String Sname) //Check wheather Fname and Surname have numbers or not 
    {
        int x=Name.length();
        for(int i=0;i<x;i++)
        {
            char w=Name.charAt(i);
            if(Character.isDigit(w))
            {
                return false;
            }
        }
        int y=Sname.length();
        for(int i=0;i<y;i++)
        {
            char w=Sname.charAt(i);
            if(Character.isDigit(w))
            {
                return false;
            }
        }
        return true;
        
    }
    public boolean check_nic(String NationalIC) //Check wheather NIC is valid
    {
        int x=NationalIC.length();
        for(int i=0;i<x-1;i++)
        {
            char w=NationalIC.charAt(i);
            if(Character.isLetter(w))
            {
                return false;
            }
        }
        if((NationalIC.length()!=10)||(!NationalIC.endsWith("v")))
        {
            return false;
        }
        return true;
    }
    
    //------------------------Viewattendance------------------------
    
    //------------------------MarkAttendance------------------------
    
    //------------------------Perm_emp_sal--------------------------
    
    //------------------------Temp_emp_sal--------------------------
    
    //------------------------Update_salary-------------------------
    
    //------------------------AssignEmp-----------------------------
    
    //------------------------Gen_Reports---------------------------
}
