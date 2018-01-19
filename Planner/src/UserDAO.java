import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
	static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
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
	 
	        ResultSet rset = stmt.executeQuery(strSelect);
	 
	        // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	        //  For each row, retrieve the contents of the cells with getXxx(columnName).
	        int rowCount = 0;
	        while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	            String name = rset.getString("firstName");
	            String surname = rset.getString("surname");
	            int id = rset.getInt("ID");
	            User user = new User(name, surname, id);
	            users.add(user);
	            ++rowCount;
	        }
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
		return users;
	}
	
	static User updateUser(User u) {
		User user = null;
		try {
			// Step 1: Allocate a database 'Connection' object
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234"); // MySQL
		 
			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
		      
			// Step 3 & 4: Execute a SQL UPDATE via executeUpdate()
			//   which returns an int indicating the number of rows affected.
			String strUpdate = "update users set firstName =' " + u.getName() + "', surname= '" +
			u.getSurname() + "' where ID=" + String.valueOf(u.getId());
			int countUpdated = stmt.executeUpdate(strUpdate);
		 
			// Step 3 & 4: Issue a SELECT to check the UPDATE.
			String strSelect = "select * from users" + " where ID=" + String.valueOf(u.getId());
			ResultSet rset = stmt.executeQuery(strSelect);
			
			while(rset.next()) {   // Move the cursor to the next row
				String name = rset.getString("firstName");
	            String surname = rset.getString("surname");
	            int id = rset.getInt("ID");
	            user = new User(name, surname, id);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		 return user;
	}
	
	static User insertUser(User u) {
		User user = null;
		try {
			// Step 1: Allocate a database 'Connection' object
			Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234"); // MySQL
			
			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			
			// Step 3: Execute a SQL INSERT statement via executeUpdate(),
			//   which returns an int indicating the number of rows affected.
			// INSERT a record
			String sqlInsert = "insert into users (firstName, surname) " // need a space
					+ "values ('" + u.getName() + "', '" +u.getSurname() + "')";
			int countInserted = stmt.executeUpdate(sqlInsert);
			
			// Issue a SELECT to check the changes
			String strSelect = "select * from users order by ID desc limit 1";
			ResultSet rset = stmt.executeQuery(strSelect);
			while(rset.next()) {   // Move the cursor to the next row
				String name = rset.getString("firstName");
	            String surname = rset.getString("surname");
	            int id = rset.getInt("ID");
	            user = new User(name, surname, id);
		    }
		} catch(SQLException ex) {
			ex.printStackTrace();
	} 
		return user;
	}
	
	static boolean deleteUser(User u) throws SQLException {
		try {
			// Step 1: Allocate a database 'Connection' object
			Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234"); // MySQL
			
			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			
			// Step 3: Execute a SQL DELETE statement via executeUpdate(),
			//   which returns an int indicating the number of rows affected.
			// DELETE selected record
			String sqlDelete = "delete from users" + " where ID=" + String.valueOf(u.getId());
			int countDeleted = stmt.executeUpdate(sqlDelete);
			if (countDeleted > 0) {
				return true;
			} else {
				return false;
			}
		} catch(SQLException ex) {
			throw(ex);
		} 
	}
}
