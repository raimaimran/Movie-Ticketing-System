
package ap_project;

import java.sql.Connection;
import java.sql.DriverManager;

       
import java.sql.Statement;

public class dbConnectivity {
    
    Connection con;
    Statement stmt;
   
    dbConnectivity() 
    {
        try
        {
            String connection = "jdbc:sqlserver://localhost:1433;databaseName=cinema";
            con= (Connection) DriverManager.getConnection(connection,"sa","123456");
            stmt = con.createStatement();
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public Connection getConnString(){
        return con;
    }
    
    
    public Statement getStmt(){
        return stmt;
    }
    
    
}
