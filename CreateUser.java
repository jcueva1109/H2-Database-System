
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;  
import javax.swing.JOptionPane;

public class CreateUser {

    static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:~/test";  
   
   //  Database credentials 
   static final String USER = "sa"; 
   static final String PASS = ""; 

    void crearUser(String user,String pass, int admin){
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
          
            // STEP 1: Register JDBC driver 
            Class.forName(JDBC_DRIVER); 

            //STEP 2: Open a connection 
            conn = DriverManager.getConnection(DB_URL,USER,PASS);  

            //STEP 3: Execute a query 
            stmt = conn.createStatement();
            
            if(admin == 1){
            
                String sql = "CREATE USER "+user+" PASSWORD '"+pass+"' admin";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Se ha creado exitosamente el usuario!");
            
            }else{
                
                String sql = "CREATE USER "+user+" PASSWORD '"+pass+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Se ha creado exitosamente el usuario!");
                
            }
            
            stmt.close(); 
            conn.close(); 

        } catch(SQLException se) { 
           //Handle errors for JDBC 
           se.printStackTrace(); 
        } catch(Exception e) { 
           //Handle errors for Class.forName 
           e.printStackTrace(); 
        } finally { 
           //finally block used to close resources 
           try{ 
              if(stmt!=null) stmt.close(); 
           } catch(SQLException se2) { 
           } // nothing we can do 
           try { 
              if(conn!=null) conn.close(); 
           } catch(SQLException se){ 
              se.printStackTrace(); 
           } //end finally try 
        } //end try 
    }
    
}
