import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewTask implements ActionListener {
	
	DefaultComboBoxModel<User> usersList;
	ArrayList<Task> tasks;
	ArrayList<User> users;
	DefaultComboBoxModel<Task> tasksToday;
	
	public AddNewTask(DefaultComboBoxModel<User> usersList, ArrayList<Task> tasks, ArrayList<User> users, DefaultComboBoxModel<Task> tasksToday) {
		this.usersList= usersList;
		this.tasks= tasks;
		this.users= users;
		this.tasksToday= tasksToday;
	}
	
	// button for adding new task
	@Override
	public void actionPerformed(ActionEvent arg0) {

		// lists with years, months, days, hours and minutes- JComboBoxes in dialog for adding a new task
		DefaultComboBoxModel<String> dayListS = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> dayListE = new DefaultComboBoxModel<>();
		JList listWithDayS = new JList(dayListS);
		JList listWithDaysE = new JList(dayListE);
		for (int i = 1; i <= 31; i++) {
			dayListS.addElement(String.format("%02d", i));
			dayListE.addElement(String.format("%02d", i));
		}
	
		DefaultComboBoxModel<String> monthListS = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> monthListE = new DefaultComboBoxModel<>();
		JList listWithMonthS = new JList(monthListS);
		JList listWithMonthE = new JList(monthListE);
		for (int i = 1; i <= 12; i++) {
			monthListS.addElement(String.format("%02d", i));
			monthListE.addElement(String.format("%02d", i));
		}
	
		DefaultComboBoxModel<String> yearListS = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> yearListE = new DefaultComboBoxModel<>();
		JList listWithYearS = new JList(yearListS);
		JList listWithYearE = new JList(yearListE);
		for (int i = Calendar.getInstance().get(Calendar.YEAR); i < Calendar.getInstance().get(Calendar.YEAR) + 20; i++) {
			 yearListS.addElement(String.format("%02d", i));
			 yearListE.addElement(String.format("%02d", i));
		}
	
		DefaultComboBoxModel<String> hourListS = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> hourListE = new DefaultComboBoxModel<>();
		JList listWithHourS = new JList(hourListS);
		JList listWithHourE = new JList(hourListE);
		for (int i = 0; i < 24; i++) {
			hourListS.addElement(String.format("%02d", i));
			hourListE.addElement(String.format("%02d", i));
		}
	
		DefaultComboBoxModel<String> minuteListS = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> minuteListE = new DefaultComboBoxModel<>();
		JList listWithMinuteS = new JList(minuteListS);
		JList listWithMinuteE = new JList(minuteListE);
		for (int i = 0; i < 60 ; i++) {
			minuteListS.addElement(String.format("%02d", i));
			minuteListE.addElement(String.format("%02d", i));
		}
	
		JComboBox assignedTo = new JComboBox(usersList);
	    JComboBox dayStart = new JComboBox(dayListS);
	    JComboBox monthStart = new JComboBox(monthListS);
	    JComboBox yearStart = new JComboBox(yearListS);
	    JComboBox hourStart = new JComboBox(hourListS);
	    JComboBox minuteStart = new JComboBox(minuteListS);
	    JComboBox dayEnd = new JComboBox(dayListE);
	    JComboBox monthEnd = new JComboBox(monthListE);
	    JComboBox yearEnd = new JComboBox(yearListE);
	    JComboBox hourEnd = new JComboBox(hourListE);
	    JComboBox minuteEnd = new JComboBox(minuteListE);
		JTextField start = new JTextField(30);
	    JTextField end = new JTextField(30);
		JTextField taskName = new JTextField(25);
	    JTextField taskDescription = new JTextField(30);
	    JCheckBox repeatableEachYear = new JCheckBox("Repeatable yearly");
	    JCheckBox repeatableMonthly = new JCheckBox("Repeatable monthly");
	    JPanel taskPanel = new JPanel();
	    JPanel datePanelStart = new JPanel();
	    JPanel datePanelEnd = new JPanel();
		    
		start.setEditable(false);
		end.setEditable(false);
		    
		// JComboBoxes for choose the date- start with today's date 
		yearStart.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));
		monthStart.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
		dayStart.setSelectedIndex(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1);
		hourStart.setSelectedIndex(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		minuteStart.setSelectedIndex(Calendar.getInstance().get(Calendar.MINUTE));
		yearEnd.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));
		monthEnd.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
		dayEnd.setSelectedIndex(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1);
		hourEnd.setSelectedIndex(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		minuteEnd.setSelectedIndex(Calendar.getInstance().get(Calendar.MINUTE));
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		System.out.println(Calendar.getInstance().get(Calendar.MONTH));
		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		System.out.println("Hour " + Calendar.getInstance().get(Calendar.HOUR_OF_DAY));   
		// display the date from JComboBoxes in the JTextFields
		start.setText(yearStart.getSelectedItem().toString() + "-" + monthStart.getSelectedItem().toString() + "-" + 
			dayStart.getSelectedItem().toString() + " " + hourStart.getSelectedItem().toString() + ":" + minuteStart.getSelectedItem().toString() + ":00");		    
		end.setText(yearEnd.getSelectedItem().toString() + "-" + monthEnd.getSelectedItem().toString() + "-" + 
		 	dayEnd.getSelectedItem().toString() + " " + hourEnd.getSelectedItem().toString() + ":" + minuteEnd.getSelectedItem().toString() + ":00");
		    
		// listeners for JComboBoxes- start time
		yearStart.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						start.setText(yearStart.getSelectedItem().toString() + "-" + monthStart.getSelectedItem().toString() + "-" + 
								dayStart.getSelectedItem().toString() + " " + hourStart.getSelectedItem().toString() + ":" + minuteStart.getSelectedItem().toString() + ":00");
		    	    }
		    	});
		monthStart.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						start.setText(yearStart.getSelectedItem().toString() + "-" + monthStart.getSelectedItem().toString() + "-" + 
								dayStart.getSelectedItem().toString() + " " + hourStart.getSelectedItem().toString() + ":" + minuteStart.getSelectedItem().toString() + ":00");
		    	    }
		    	 });
		dayStart.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						start.setText(yearStart.getSelectedItem().toString() + "-" + monthStart.getSelectedItem().toString() + "-" + 
								dayStart.getSelectedItem().toString() + " " + hourStart.getSelectedItem().toString() + ":" + minuteStart.getSelectedItem().toString() + ":00");
		    	    }
		    	});
		hourStart.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						start.setText(yearStart.getSelectedItem().toString() + "-" + monthStart.getSelectedItem().toString() + "-" + 
								dayStart.getSelectedItem().toString() + " " + hourStart.getSelectedItem().toString() + ":" + minuteStart.getSelectedItem().toString() + ":00");
		    	    }	
		    	});
		minuteStart.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						start.setText(yearStart.getSelectedItem().toString() + "-" + monthStart.getSelectedItem().toString() + "-" + 
								dayStart.getSelectedItem().toString() + " " + hourStart.getSelectedItem().toString() + ":" + minuteStart.getSelectedItem().toString() + ":00");
		    	    }
		    	});
		    
		// listeners for JComboBoxes- end time
		yearEnd.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						end.setText(yearEnd.getSelectedItem().toString() + "-" + monthEnd.getSelectedItem().toString() + "-" + 
								dayEnd.getSelectedItem().toString() + " " + hourEnd.getSelectedItem().toString() + ":" + minuteEnd.getSelectedItem().toString() + ":00");
		    	    }
		    	});
		monthEnd.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						end.setText(yearEnd.getSelectedItem().toString() + "-" + monthEnd.getSelectedItem().toString() + "-" + 
								dayEnd.getSelectedItem().toString() + " " + hourEnd.getSelectedItem().toString() + ":" + minuteEnd.getSelectedItem().toString() + ":00");
		    	    }
		    	});
		dayEnd.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						end.setText(yearEnd.getSelectedItem().toString() + "-" + monthEnd.getSelectedItem().toString() + "-" + 
								dayEnd.getSelectedItem().toString() + " " + hourEnd.getSelectedItem().toString() + ":" + minuteEnd.getSelectedItem().toString() + ":00");
					}
		    	});
		hourEnd.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						end.setText(yearEnd.getSelectedItem().toString() + "-" + monthEnd.getSelectedItem().toString() + "-" + 
								dayEnd.getSelectedItem().toString() + " " + hourEnd.getSelectedItem().toString() + ":" + minuteEnd.getSelectedItem().toString() + ":00");
		    	    }	
		    	});
		minuteEnd.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						end.setText(yearEnd.getSelectedItem().toString() + "-" + monthEnd.getSelectedItem().toString() + "-" + 
								dayEnd.getSelectedItem().toString() + " " + hourEnd.getSelectedItem().toString() + ":" + minuteEnd.getSelectedItem().toString() + ":00");
		    	    }	
		    	});
		    
		// create the panels with the JComboBoxes (start and end date)
		datePanelStart.add(yearStart);
		datePanelStart.add(monthStart);
		datePanelStart.add(dayStart);
		datePanelStart.add(hourStart);
		datePanelStart.add(minuteStart);
		
		datePanelEnd.add(yearEnd);
		datePanelEnd.add(monthEnd);
		datePanelEnd.add(dayEnd);
		datePanelEnd.add(hourEnd);
		datePanelEnd.add(minuteEnd);
		
		//create the panel for tasks
		taskPanel.add(new JLabel("Name of task:"));
		taskPanel.add(taskName);
		taskPanel.add(Box.createVerticalStrut(15)); // a spacer
		taskPanel.add(new JLabel("Description of task:"));
		taskPanel.add(taskDescription);
		taskPanel.add(new JLabel("Choose the user:"));
		taskPanel.add(assignedTo);
		taskPanel.add(new JLabel("Start time: ")); 
		taskPanel.add(start); 
		taskPanel.add(datePanelStart);
		taskPanel.add(new JLabel("End time: "));
		taskPanel.add(end); 
		taskPanel.add(datePanelEnd);
		taskPanel.add(repeatableEachYear);
		taskPanel.add(repeatableMonthly);
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
		
		int result = JOptionPane.showConfirmDialog(null, taskPanel, 
				"Create a new Task", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			System.out.println("Name of task: " + taskName.getText());
			System.out.println("Description of task: " + taskDescription.getText());
			Task newTask = new Task(taskName.getText(), taskDescription.getText());
			newTask.setStartTime(start.getText());
			newTask.setEndTime(end.getText());
			newTask.setAssignedTo((User)assignedTo.getSelectedItem());
		   
			Task taskCreated = TaskDAO.insertTask(newTask, users);
			System.out.println("Start: " + newTask.getStartTime());
			System.out.println("End: " + newTask.getEndTime());
			System.out.println("Assigned to: " + newTask.getAssignedTo());
			System.out.println("Start: " + taskCreated.getStartTime());
			System.out.println("End: " + taskCreated.getEndTime());
			System.out.println("Assigned to: " + taskCreated.getAssignedTo());
			tasks.add(taskCreated);
			Date today = Calendar.getInstance().getTime();
			Date firstDate = CellRenderer.getZeroTimeDate(taskCreated.getStartTime());
		    Date secondDate = CellRenderer.getZeroTimeDate(today);
		    if (firstDate.equals(secondDate)) {
		    	System.out.println("Today's task");
	    		tasksToday.addElement(taskCreated);
	    	}
			
			// save tasks repeatable yearly
			if (repeatableEachYear.isSelected()) {
				int year = taskCreated.getStartTime().getYear();
				for (int i = 1; i <= 10; i++) {
					Task t = new Task(taskName.getText(), taskDescription.getText()); 
					Date startDate = taskCreated.getStartTime();
					startDate.setYear(year + i);
					t.setStartTime(startDate); 
					Date endDate = taskCreated.getEndTime();
					endDate.setYear(year + i);
					t.setEndTime(endDate); 	
					t.setAssignedTo(taskCreated.getAssignedTo());
					TaskDAO.insertTask(t, users); 
		        }
		     }
		         
			// save tasks repeatable monthly
			if (repeatableMonthly.isSelected()) {
				int month = taskCreated.getStartTime().getMonth();
				for (int i = 1; i <= 12 - month; i++) {
					Task t = new Task(taskName.getText(), taskDescription.getText()); 
					Date startDate = taskCreated.getStartTime();
					startDate.setMonth(month + i);
					t.setStartTime(startDate); 
					Date endDate = taskCreated.getEndTime();
					endDate.setMonth(month + i);
					t.setEndTime(endDate); 	
					t.setAssignedTo(taskCreated.getAssignedTo());
					TaskDAO.insertTask(t, users); 
				}
			}
}}};