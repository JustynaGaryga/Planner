import java.awt.EventQueue;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 // Step 1: Allocate a database 'Connection' object
			 Connection conn = DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234");
			 		 // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
			 
			 // Step 2: Allocate a 'Statement' object in the Connection
			 Statement stmt = conn.createStatement();
			 // Step 3: Execute a SQL SELECT query, the query result
			 //  is returned in a 'ResultSet' object.
			 String strSelect = "select ID, firstName, surname from users";
			 System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			 System.out.println();
		 
			 ResultSet rset = stmt.executeQuery(strSelect);
		 
			 // Step 4: Process the ResultSet by scrolling the cursor forward via next().
			 //  For each row, retrieve the contents of the cells with getXxx(columnName).
			 System.out.println("The records selected are:");
			 int rowCount = 0;
			 while(rset.next()) {   // Move the cursor to the next row, return false if no more row
				 String name = rset.getString("firstName");
				 String surname = rset.getString("surname");
				 int ID = rset.getInt("ID");
				 System.out.println(name + ", " + surname + ", " + ID);
				 ++rowCount;
		     }
			 System.out.println("Total number of records = " + rowCount);
		 } catch (SQLException ex) {
			 ex.printStackTrace();
		 }
		 EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Planner();
			}
		});
	}
}
