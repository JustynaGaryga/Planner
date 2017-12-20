import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

public class TaskDAO {
	
	static ArrayList<Task> getTasks(ArrayList<User> users) {
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
			String strSelect = "select taskID, nameTask, descriptionTask, assignedTo, startTime, endTime from tasks";
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
	            Date startTime = null;
	            Date endTime = null;
	            try {
	            	startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rset.getString("startTime"));
	            	endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rset.getString("endTime"));
	            } catch (ParseException e) {
	            	System.out.println("ParseException date");
	            }
	            int assignedTo = rset.getInt("assignedTo");
	            int taskID = rset.getInt("taskID");
	            
	            User assignedUser = null;
	            for (User user : users) {
	            	int selectedID = user.getId();
	            	if (selectedID== assignedTo) {
	            		 assignedUser = user;
	            	     break;
	            	}
	    		}
	            Task task = new Task(nameTask, descriptionTask, startTime, endTime, assignedUser, taskID);
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
	
	static Task updateTask(Task t, ArrayList<User> users) {
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
				String nameTask = rset.getString("nameTask");
	            String descriptionTask = rset.getString("descriptionTask");
	            Date startTime = null;
	            Date endTime = null;
	            try {
	            	startTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(rset.getString("startTime"));
	            	endTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(rset.getString("endTime"));
	            } catch (ParseException e) {
	            }
	            int assignedTo = rset.getInt("assignedTo");
	            int taskID = rset.getInt("taskID");
	            
	            User assignedUser = null;
	            for (User user : users) {
	            	int selectedID = user.getId();
	            	if (selectedID== assignedTo) {
	            		 assignedUser = user;
	            	     break;
	            	}
	    		}
	            task = new Task(nameTask, descriptionTask, startTime, endTime, assignedUser, taskID);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		 return task;
	}
	
	static Task insertTask(Task t, ArrayList<User> users) {
		Task task = null;
		try {
			// Step 1: Allocate a database 'Connection' object
			Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/planner?useSSL=false", "Justyna", "qwer1234"); // MySQL
			
			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			
			// Step 3: Execute a SQL INSERT statement via executeUpdate(),
			//   which returns an int indicating the number of rows affected.
			// INSERT a record
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String startFormatted = formatter.format(t.getStartTime());
			String endFormatted = formatter.format(t.getEndTime());
			
			String sqlInsert = "insert into tasks  (nameTask, descriptionTask, startTime, endTime, assignedTo) " // need a space
					+ "values ('" + t.getNameTask() + "', '" + t.getDescriptionTask() + "', '" + startFormatted + "', '" + endFormatted +  "', " + t.getAssignedTo().getId() + ")";
			System.out.println("The SQL query is: " + sqlInsert);  // Echo for debugging
			int countInserted = stmt.executeUpdate(sqlInsert);
			System.out.println(countInserted + " records inserted.\n");
		
			// Issue a SELECT to check the changes
			String strSelect = "select * from tasks order by taskID desc limit 1";
			System.out.println("The SQL query is: " + strSelect);  // Echo For debugging
			ResultSet rset = stmt.executeQuery(strSelect);
			while(rset.next()) {   // Move the cursor to the next row
				String nameTask = rset.getString("nameTask");
	            String descriptionTask = rset.getString("descriptionTask");
	            Date startTime = null;
	            Date endTime = null;
	            try {
	            	startTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(rset.getString("startTime"));
	            	endTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(rset.getString("endTime"));
	            } catch (ParseException e) {
	            }
	            int assignedTo = rset.getInt("assignedTo");
	            int taskID = rset.getInt("taskID");
	            User assignedUser = null;
	            for (User user : users) {
	            	int selectedID = user.getId();
	            	if (selectedID== assignedTo) {
	            		 assignedUser = user;
	            	     break;
	            	}
	    		}
	            task = new Task(nameTask, descriptionTask, startTime, endTime, assignedUser, taskID);
		    }
		} catch(SQLException ex) {
			ex.printStackTrace();
	} 
		return task;
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

