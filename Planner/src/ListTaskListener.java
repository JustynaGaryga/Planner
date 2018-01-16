import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ListTaskListener implements ListSelectionListener  {

	DefaultComboBoxModel<User> usersList;
	DefaultComboBoxModel<Task> tasksList;
	JList listWithTasks;
	ArrayList<User> users;
	
	public ListTaskListener(DefaultComboBoxModel<User> usersList, DefaultComboBoxModel<Task> tasksList, JList listWithTasks, ArrayList<User> users) {
		this.usersList= usersList;
		this.tasksList= tasksList;
		this.listWithTasks= listWithTasks;
		this.users= users;
	}
	
	@Override		
	// show a dialog for edit task, when we click on the task	 
	public void valueChanged(ListSelectionEvent evtT) {
		
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
		
		//JFrame to edit tasks
		JFrame editTaskFrame = new JFrame("Edit the task");
		editTaskFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //clicking on X - do nothing
		editTaskFrame.setSize(350, 400);
		editTaskFrame.setLocation(600, 200);
		JComboBox selectTask = new JComboBox(tasksList);
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
		JTextField taskName = new JTextField(25);
		JTextField taskDescription = new JTextField(30);
		JTextField start = new JTextField(30);
		JTextField end = new JTextField(30);
		JPanel okCancelPanel = new JPanel();
		JButton deleteTask = new JButton("Delete task");
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		Task editTask = (Task)listWithTasks.getSelectedValue();
		JPanel taskPanel = new JPanel();
		JPanel datePanelStart = new JPanel();
	    JPanel datePanelEnd = new JPanel();

		start.setEditable(false);
		end.setEditable(false);
		
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
		
		if (listWithTasks.getSelectedValue() != null) {
			taskName.setText(((Task)listWithTasks.getSelectedValue()).getNameTask());
			taskDescription.setText(((Task)listWithTasks.getSelectedValue()).getDescriptionTask());
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			System.out.println(((Task)listWithTasks.getSelectedValue()).getStartTime().toString());
			String startFormatted = formatter.format(((Task)listWithTasks.getSelectedValue()).getStartTime());
			String endFormatted = formatter.format(((Task)listWithTasks.getSelectedValue()).getEndTime());
			start.setText(startFormatted);
			end.setText(endFormatted);
			assignedTo.setSelectedItem(((Task)listWithTasks.getSelectedValue()).getAssignedTo());
			
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
		}
							
		taskPanel.add(new JLabel("Edit name of task:"));
		taskPanel.add(taskName);
		taskPanel.add(Box.createVerticalStrut(15)); // a spacer
		taskPanel.add(new JLabel("Edit description of task:"));
		taskPanel.add(taskDescription);
		taskPanel.add(new JLabel("Choose the user:"));
		taskPanel.add(assignedTo);
		taskPanel.add(new JLabel("Start time: ")); 
		taskPanel.add(start); 
		taskPanel.add(datePanelStart);
		taskPanel.add(new JLabel("End time: "));
		taskPanel.add(end);
		taskPanel.add(datePanelEnd);
		taskPanel.add(deleteTask);

		okButton.setEnabled(false);
		cancelButton.setEnabled(true);
		okCancelPanel.add(okButton);
		okCancelPanel.add(cancelButton);
		okCancelPanel.setLayout(new FlowLayout());
		taskPanel.add(Box.createRigidArea(new Dimension(0,20)));
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
						
		editTaskFrame.add(taskPanel, BorderLayout.CENTER);
		editTaskFrame.add(okCancelPanel, BorderLayout.PAGE_END);
		
		if (evtT.getValueIsAdjusting() == false && listWithTasks.getSelectedValue() != null) {
			System.out.println("set it visible");
			editTaskFrame.setVisible(true);
		}
						
		//button OK become clickable when all the text fields have been completed
		enableOKButtonTask(taskName, taskDescription, start, end, okButton);
		taskName.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				enableOKButtonTask(taskName, taskDescription, start, end, okButton);
			}
		});
		taskDescription.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				enableOKButtonTask(taskName, taskDescription, start, end, okButton);
			}
		});
		start.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				enableOKButtonTask(taskName, taskDescription, start, end, okButton);
			}
		});
		end.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				enableOKButtonTask(taskName, taskDescription, start, end, okButton);
			}
		});
						
		// button Cancel close the frame to edit user
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				editTaskFrame.dispose();
			}
		});
						
		// button OK to save the changed task's name, description, start, end time
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				editTask.setNameTask(taskName.getText());
				editTask.setDescriptionTask(taskDescription.getText());
				editTask.setStartTime(start.getText());
				editTask.setEndTime(end.getText());
				editTask.setAssignedTo((User)assignedTo.getSelectedItem());
				System.out.println("Name of task: " + taskName.getText());
				System.out.println("Description of task: " + taskDescription.getText());
				System.out.println("Start: " + editTask.getStartTime());
				System.out.println("End: " + editTask.getEndTime());
				System.out.println("Assigned to: " + editTask.getAssignedTo());
				Task t = TaskDAO.updateTask(editTask, users);
				if (t != null) {
					editTask.setNameTask(t.getNameTask());
					editTask.setDescriptionTask(t.getDescriptionTask());
					editTask.setStartTime(t.getStartTime());
					editTask.setEndTime(t.getEndTime());
					editTask.setAssignedTo(t.getAssignedTo());
				}
				editTaskFrame.dispose();
			}
		});
		
		// button to delete the task from the list of tasks
		deleteTask.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tasksList.getIndexOf(editTask);
				boolean result = TaskDAO.deleteTask(editTask); 
				if (result == true) {
					tasksList.removeElementAt(i);
				}
				editTaskFrame.dispose();
			}
		});
		System.out.println("Selected from " + evtT.getFirstIndex() + " to " + evtT.getLastIndex());	 
	}
	
	// method to set the OK button enabled- JFrame to edit tasks
	public void enableOKButtonTask (JTextField taskName, JTextField taskDescription, JTextField start, JTextField end, JButton okButton) {
		if (taskName.getText().length() == 0 || taskDescription.getText().length() == 0
				|| start.getText().length() == 0 || end.getText().length() == 0) {
	    			okButton.setEnabled(false);
	    } else {
	    	okButton.setEnabled(true);
	    }
	}
};		


