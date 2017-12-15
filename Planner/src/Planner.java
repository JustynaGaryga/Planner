import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Planner extends JFrame {
	JFrame plannerFrame = new JFrame("Planner. Learn IT, Girl!");
	DefaultTableModel model;
	Calendar cal = new GregorianCalendar(Locale.ENGLISH);
	JPanel listPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel changeMonthPanel = new JPanel();
	JPanel calPanel = new JPanel();
	JButton addUserButton = new JButton("Add new User");
	JButton addTaskButton = new JButton("Add new Task");
	JButton selectTaskButton = new JButton("Choose new task");
	JLabel userLabel = new JLabel (" USERS: ", SwingConstants.LEFT);
	JLabel taskLabel = new JLabel (" TASKS: ", SwingConstants.LEFT);
	JLabel monthLabel = new JLabel();
	
	DefaultComboBoxModel<User> usersList = new DefaultComboBoxModel<>();
	DefaultComboBoxModel<Task> tasksList = new DefaultComboBoxModel<>();
	JList listWithUsers = new JList(usersList);
	JList listWithTasks = new JList(tasksList);
	
	public Planner() {
		super ("Planner. Learn IT, Girl!");
		plannerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plannerFrame.setSize(800, 500);
		plannerFrame.setLocation(300, 50);
		plannerFrame.getContentPane().setBackground(Color.yellow); // temporary color
		plannerFrame.setVisible(true);
		
		//click on button 
		addUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JTextField userName = new JTextField(25);
			    JTextField userSurname = new JTextField(25);
			    JPanel userPanel = new JPanel();
			    userPanel.add(new JLabel("Name:"));
			    userPanel.add(userName);
			    userPanel.add(Box.createVerticalStrut(15)); // a spacer
			    userPanel.add(new JLabel("Surname:"));
			    userPanel.add(userSurname);
			    userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));

			    int result = JOptionPane.showConfirmDialog(null, userPanel, 
			               "Create a new User", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION) {
			         System.out.println("Name: " + userName.getText());
			         System.out.println("Surname: " + userSurname.getText());
			         User newUser = new User(userName.getText(), userSurname.getText());
			         usersList.addElement(newUser);
			    }}});
		
		// click on button
		addTaskButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JComboBox selectTask = new JComboBox(tasksList);
				JComboBox assignedTo = new JComboBox(usersList);
				JTextField start = new JTextField(30);
			    JTextField end = new JTextField(30);
				JTextField taskName = new JTextField(25);
			    JTextField taskDescription = new JTextField(30);
			    JPanel taskPanel = new JPanel();
			    taskPanel.add(new JLabel("Name of task:"));
			    taskPanel.add(taskName);
			    taskPanel.add(Box.createVerticalStrut(15)); // a spacer
			    taskPanel.add(new JLabel("Description of task:"));
			    taskPanel.add(taskDescription);
			    taskPanel.add(new JLabel("Choose the user:"));
			    taskPanel.add(assignedTo);
			    taskPanel.add(new JLabel("Start time. Enter dd/mm/yyyy hh:mm")); 
			    taskPanel.add(start); // change to field where user can select the date and time
			    taskPanel.add(new JLabel("End time. Enter dd/mm/yyyy hh:mm"));
			    taskPanel.add(end); // change to field where user can select the date and time
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
			         System.out.println("Start: " + newTask.getStartTime());
			         System.out.println("End: " + newTask.getEndTime());
			         System.out.println("Assigned to: " + newTask.getAssignedTo());
			         tasksList.addElement(newTask);
			       
			    }}});
		
		// click on button
		selectTaskButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JComboBox selectTask = new JComboBox(tasksList);
				JComboBox assignedTo = new JComboBox(usersList);
				JTextField start = new JTextField(30);
			    JTextField end = new JTextField(30);
			    JPanel selectPanel = new JPanel();
			    selectPanel.add(new JLabel("Choose the task:"));
			    selectPanel.add(selectTask);
			    selectPanel.add(Box.createVerticalStrut(15)); // a spacer
			    selectPanel.add(new JLabel("Choose the user:"));
			    selectPanel.add(assignedTo);
			    selectPanel.add(new JLabel("Start time. Enter dd/mm/yyyy hh:mm")); 
			    selectPanel.add(start); // change to field where user can select the date and time
			    selectPanel.add(new JLabel("End time. Enter dd/mm/yyyy hh:mm"));
			    selectPanel.add(end); // change to field where user can select the date and time
			    selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
			    
			    int result = JOptionPane.showConfirmDialog(null, selectPanel, 
			               "Choose the task and user", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION) {
			    
			    }}});
				
		// add buttons to panelButtons
		buttonPanel.add(addUserButton);
	    buttonPanel.add(addTaskButton);
	    buttonPanel.setSize(200, 200);
	    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		/*User's list
		User user1 = new User("Justyna", "Garyga");
		User user2 = new User("Peter", "Garyga");
		User user3 = new User("Chris", "Garyga");
		User user4 = new User("Barbara", "Garyga");
		
		usersList.addElement(user1);
		usersList.addElement(user2);
		usersList.addElement(user3);
		usersList.addElement(user4);
		/*/ 
	    // Users that want to use the application and don't have a database yet can use this code to have a working version
		
	    ArrayList<User> users = UserDAO.getUsers();
		for (User u : users) {
			usersList.addElement(u);
		}
		System.out.println(users.toString());
		
	    /* Task's list
		Task task1 = new Task("Wash clothes", "washing clothes");
		Task task2 = new Task("Shopping", "buying food and ");
		Task task3 = new Task("Wash a car", "go to a car wash ");
		Task task4 = new Task("Prepare breakfast", "at 6:00 AM");
		Task task5 = new Task("Prepare dinner", "at 16: PM");
		Task task6 = new Task("Visit my parents", "Majakowskiego Street");
		Task task7 = new Task("Visit Piter's parents", "Panewnicka Street");
	
		tasksList.addElement(task1);
		tasksList.addElement(task2);
		tasksList.addElement(task3);
		tasksList.addElement(task4);
		tasksList.addElement(task5);
		tasksList.addElement(task6);
		tasksList.addElement(task7);
		*/
		// Tasks that want to use the application and don't have a database yet can use this code to have a working version
		
		ArrayList<Task> tasks = TaskDAO.getTasks();
		for (Task t : tasks) {
			tasksList.addElement(t);
		}
		System.out.println(tasks.toString());
		
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		userLabel.setBorder(border); 
		taskLabel.setBorder(border);
		
		// the panel with list on the left side
		listPanel.add(userLabel); 
		listPanel.add(listWithUsers);
		listPanel.add(Box.createRigidArea(new Dimension(0,20)));
		listPanel.add(taskLabel);
		listPanel.add(listWithTasks);
		listPanel.setBackground(Color.white);
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		
		// the panel with buttons on the top
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.white);
		topPanel.add(buttonPanel, BorderLayout.LINE_END);
		topPanel.add(selectTaskButton, BorderLayout.LINE_START);
		plannerFrame.add(topPanel, BorderLayout.PAGE_START);
		plannerFrame.add(listPanel, BorderLayout.LINE_START); 
		
		// show a JFrame for edit user, when we click on the user in User's list
		listWithUsers.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evtU) {
				//JFrame to edit User
				JFrame editUserFrame = new JFrame("Edit the User");
				editUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				editUserFrame.setSize(300, 200);
				editUserFrame.setLocation(600, 200);
				// the text field
				JTextField userName = new JTextField(25);
				JTextField userSurname = new JTextField(25);
				JPanel userPanel = new JPanel();
				JPanel okCancelPanel = new JPanel();
			    JButton deleteUser = new JButton("Delete User");
			    JButton okButton = new JButton("OK");
			    JButton cancelButton = new JButton("Cancel");
			    User editUser = (User)listWithUsers.getSelectedValue();
			    
			    if (listWithUsers.getSelectedValue() != null) {
		    		userName.setText(((User)listWithUsers.getSelectedValue()).getName());
		    		userSurname.setText(((User)listWithUsers.getSelectedValue()).getSurname());
			    }

			    userPanel.add(new JLabel("Edit name:"));
			    userPanel.add(userName);
			    userPanel.add(Box.createVerticalStrut(15)); // a spacer
			    userPanel.add(new JLabel("Edit surname:"));
			    userPanel.add(userSurname);
			    userPanel.add(deleteUser);
			    userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));

				okButton.setEnabled(false);
				cancelButton.setEnabled(true);
				okCancelPanel.add(okButton);
				okCancelPanel.add(cancelButton);
				okCancelPanel.setLayout(new FlowLayout());
				userPanel.add(Box.createRigidArea(new Dimension(0,20)));
				userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
				
				editUserFrame.add(userPanel, BorderLayout.CENTER);
				editUserFrame.add(okCancelPanel, BorderLayout.PAGE_END);
				
				if (evtU.getValueIsAdjusting() == false && listWithUsers.getSelectedValue() != null) {
					System.out.println("set it visible");
					editUserFrame.setVisible(true);
				}
				
				// button OK is clicable, when all of the JTextFields are filled
				enableOKButtonUser(userName, userSurname, okButton);
				
				userName.addKeyListener(new KeyAdapter() {
			        public void keyReleased(KeyEvent e) {
			        	enableOKButtonUser(userName, userSurname, okButton);
			        }
				});
				userSurname.addKeyListener(new KeyAdapter() {
			        public void keyReleased(KeyEvent e) {
			        	enableOKButtonUser(userName, userSurname, okButton);
			        }
				});
				
				// button Cancel close the frame to edit user
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						editUserFrame.dispose();
					    }
				});
				
				// button OK to save the changed user's name and/or surname
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println("Name: " + userName.getText());
					    System.out.println("Surname: " + userSurname.getText());
					    editUser.setName(userName.getText());
					    editUser.setSurname(userSurname.getText());
					    User u = UserDAO.updateUser(editUser);
					    if (u != null) {
					    	editUser.setName(u.getName());
						    editUser.setSurname(u.getSurname());
					    }
					    editUserFrame.dispose();
					    }
				});
				
				// button to delete the user from the list of users
			    deleteUser.addActionListener(new ActionListener() {
			    	@Override
					public void actionPerformed(ActionEvent arg0) {
			    		int i = usersList.getIndexOf(editUser);
			    		boolean result = UserDAO.deleteUser(editUser); 
			    		if (result == true) {
			    			usersList.removeElementAt(i);
			    		}
			    		editUserFrame.dispose();
			    	}
				});
			}
		});
		
		// show a dialog for edit task, when we click on the task- to change it to JFrame!
		listWithTasks.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evtT) {
				//JFrame to edit User
				JFrame editTaskFrame = new JFrame("Edit the task");
				editTaskFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //clicking on X - do nothing
				editTaskFrame.setSize(300, 300);
				editTaskFrame.setLocation(600, 200);
				JComboBox selectTask = new JComboBox(tasksList);
				JComboBox assignedTo = new JComboBox(usersList);
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
				
				if (listWithTasks.getSelectedValue() != null) {
		    		taskName.setText(((Task)listWithTasks.getSelectedValue()).getNameTask());
		    		taskDescription.setText(((Task)listWithTasks.getSelectedValue()).getDescriptionTask());
				}

			    taskPanel.add(new JLabel("Edit name of task:"));
			    taskPanel.add(taskName);
			    taskPanel.add(Box.createVerticalStrut(15)); // a spacer
			    taskPanel.add(new JLabel("Edit description of task:"));
			    taskPanel.add(taskDescription);
			    taskPanel.add(new JLabel("Choose the user:"));
			    taskPanel.add(assignedTo);
			    taskPanel.add(new JLabel("Edit start time. Enter dd/mm/yyyy hh:mm")); 
			    taskPanel.add(start); // change to field where user can select the date and time
			    taskPanel.add(new JLabel("Edit end time. Enter dd/mm/yyyy hh:mm"));
			    taskPanel.add(end); // change to field where user can select the date and time
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
				
				// button OK to save the changed user's name and/or surname
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub

						editTask.setNameTask(taskName.getText());
						editTask.setDescriptionTask(taskDescription.getText());
						editTask.setStartTime(start.getText());
						editTask.setEndTime(end.getText());
						System.out.println("Name of task: " + taskName.getText());
						System.out.println("Description of task: " + taskDescription.getText());
						System.out.println("Start: " + editTask.getStartTime());
						System.out.println("End: " + editTask.getEndTime());
						System.out.println("Assigned to: " + editTask.getAssignedTo());
						Task t = TaskDAO.updateTask(editTask);
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
				
				// button to delete the user from the list of users
			    deleteTask.addActionListener(new ActionListener() {
			    	@Override
					public void actionPerformed(ActionEvent arg0) {
			    		int i = tasksList.getIndexOf(editTask);
			    		tasksList.removeElementAt(i);
			    		boolean result = TaskDAO.deleteTask(editTask); 
			    		if (result == true) {
			    			tasksList.removeElementAt(i);
			    		}
			    		editTaskFrame.dispose();
			    	}
				});
			    System.out.println("Selected from " + evtT.getFirstIndex() + " to " + evtT.getLastIndex());	 
			}
		});	
		
		// JTable for calendar
		String[] columnNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		model = new DefaultTableModel(null, columnNames);
		JTable calendar = new JTable(model);
	    monthLabel.setHorizontalAlignment(SwingConstants.CENTER);

		calendar.setRowHeight(70);
		calendar.setCellSelectionEnabled(true); // cells are clicable
		calendar.setShowGrid(true); 
		calendar.setGridColor(Color.LIGHT_GRAY);
		JScrollPane sp=new JScrollPane(calendar);
		int rowCount = 5;
		model.setRowCount(rowCount);
		
		JButton buttonLow = new JButton("<-");
			buttonLow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					cal.add(Calendar.MONTH, -1);
					updateMonth();
				}
		    });
			
		JButton buttonHight = new JButton("->");
			buttonHight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					cal.add(Calendar.MONTH, +1);
					updateMonth();
				}
		    });
		
		// panel for changing the months and the calendar
		changeMonthPanel.add(buttonLow, BorderLayout.WEST);
		changeMonthPanel.add(monthLabel, BorderLayout.NORTH);
		changeMonthPanel.add(buttonHight, BorderLayout.EAST);
		changeMonthPanel.setBackground(Color.GREEN);
		calPanel.add(changeMonthPanel);
		calPanel.add(sp);
		calPanel.setLayout(new BoxLayout(calPanel, BoxLayout.Y_AXIS));
		plannerFrame.add(calPanel);
		
		this.updateMonth();
	}
	
	//method to update month 
	void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		     
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = cal.get(Calendar.YEAR);
		monthLabel.setText(month + " " + year);
		     
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		model.setRowCount(0);
		model.setRowCount(weeks);
		
		int i = startDay-1;
		for(int day=1;day<=numberOfDays;day++){
			model.setValueAt(day, i/7 , i%7 );    
			i = i + 1;
		}
	}     
	
	// method to set the OK button enabled- JFrame to edit users
	void enableOKButtonUser (JTextField userName, JTextField userSurname, JButton okButton) {
		if (userName.getText().length() == 0 || userSurname.getText().length() == 0) {
			okButton.setEnabled(false);
		} else {
			okButton.setEnabled(true);
		}
	}
	
	// method to set the OK button enabled- JFrame to edit tasks
	void enableOKButtonTask (JTextField taskName, JTextField taskDescription, JTextField start, JTextField end, JButton okButton) {
		if (taskName.getText().length() == 0 || taskDescription.getText().length() == 0
    			|| start.getText().length() == 0 || end.getText().length() == 0) {
    		okButton.setEnabled(false);
    	} else {
    		okButton.setEnabled(true);
    	}
	}
}
