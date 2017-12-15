import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class TaskDAO {
	
	static ArrayList<Task> getTasks() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		try {
			// Step 1: Allocate a database 'Connection' object
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234");
				// MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
	 
	        // Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			
			// Step 3: Execute a SQL SELECT query, the query result
			//  is returned in a 'ResultSet' object.
			String strSelect = "select taskID, nameTask, descriptionTask, assigendTo, startTime, endTime from tasks";
			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
	        System.out.println();
	 
	        ResultSet rset = stmt.executeQuery(strSelect);
	 
	        // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	        //  For each row, retrieve the contents of the cells with getXxx(columnName).
	        System.out.println("The records selected are:");
	        int rowCount = 0;
	        while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	            String nameTask = rset.getString("nameTask");
	            String descriptionTask = rset.getString("descriptionTask");
	            Date startTime = rset.getString("startTime");
	            Date endTime = rset.getString("endTime");
	            String assignedTo = rset.getString("assignedTo");
	            int taskID = rset.getInt("taskID");
	            Task task = new Task(nameTask, descriptionTask, startTime, endTime, assignedTo, taskID);
	            tasks.add(task);
	            System.out.println(nameTask + ", " + descriptionTask + ", " + startTime + ", " + endTime + ", " + assignedTo + ", " + taskID);
	            ++rowCount;
	        }
	        System.out.println("Total number of records = " + rowCount);
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
		return tasks;
	}
	
	static Task updateTask(Task t) {
		Task task = null;
		try {
			// Step 1: Allocate a database 'Connection' object
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234"); // MySQL
		 
			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
		      
			// Step 3 & 4: Execute a SQL UPDATE via executeUpdate()
			//   which returns an int indicating the number of rows affected.
			String strUpdate = "update tasks set nameTask =' " + t.getNameTask() + "', descriptionTask= '" + t.getDescriptionTask() + "' where taskID=" + String.valueOf(t.getTaskID());
			System.out.println("The SQL query is: " + strUpdate);  // Echo for debugging
			int countUpdated = stmt.executeUpdate(strUpdate);
			System.out.println(countUpdated + " records affected.");
		 
			// Step 3 & 4: Issue a SELECT to check the UPDATE.
			String strSelect = "select * from tasks" + " where taskID=" + String.valueOf(t.getTaskID());
			System.out.println("The SQL query is: " + strSelect);  // Echo for debugging
			ResultSet rset = stmt.executeQuery(strSelect);
			
			while(rset.next()) {   // Move the cursor to the next row
				String nameTask = rset.getString("firstName");
	            String descriptionTask = rset.getString("descriptionTask");
	            Date startTime = rset.getString("startTime");
	            Date endTime = rset.getString("endTime");
	            String assignedTo = rset.getString("assignedTo");
	            int taskID = rset.getInt("taskID");
	            task = new Task(nameTask, descriptionTask, startTime, endTime, assignedTo, taskID);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		 return task;
	}
	
	static Task insertTask(Task t) {
		try {
			// Step 1: Allocate a database 'Connection' object
			Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234"); // MySQL
			
			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			
			// Step 3: Execute a SQL INSERT statement via executeUpdate(),
			//   which returns an int indicating the number of rows affected.
			// INSERT a record
			String sqlInsert = "insert into tasks " // need a space
					+ "values ('" + t.getNameTask() + "', '" + t.getDescriptionTask() + "', '" + t.getStartTime() + "', '" + t.getEndTime() +  "', '" + t.getAssignedTo() + "')";
			System.out.println("The SQL query is: " + sqlInsert);  // Echo for debugging
			int countInserted = stmt.executeUpdate(sqlInsert);
			System.out.println(countInserted + " records inserted.\n");
		
			// Issue a SELECT to check the changes
			String strSelect = "select * from tasks where taskID= ";
			System.out.println("The SQL query is: " + strSelect);  // Echo For debugging
			ResultSet rset = stmt.executeQuery(strSelect);
			while(rset.next()) {   // Move the cursor to the next row
				/*
				System.out.println(rset.getInt("id") + ", "
						+ rset.getString("author") + ", "
						+ rset.getString("title") + ", "
						+ rset.getDouble("price") + ", "
						+ rset.getInt("qty"));
						*/
	
		    }
		} catch(SQLException ex) {
			ex.printStackTrace();
	} 
		return t;
	}
	
	static boolean deleteTask(Task t) {
		try {
			// Step 1: Allocate a database 'Connection' object
			Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234"); // MySQL
			
			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			
			// Step 3: Execute a SQL DELETE statement via executeUpdate(),
			//   which returns an int indicating the number of rows affected.
			// DELETE selected record
			String sqlDelete = "delete from tasks" + " where taskID=" + String.valueOf(t.getTaskID());
			System.out.println("The SQL query is: " + sqlDelete);  // Echo for debugging
			int countDeleted = stmt.executeUpdate(sqlDelete);
			System.out.println(countDeleted + " records deleted.\n");
			if (countDeleted > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} 
		return false;
	}
	
}

