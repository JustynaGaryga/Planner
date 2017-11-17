import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Planner extends JFrame {
	JFrame plannerFrame = new JFrame("Planner. Learn IT, Girl!");
	JPanel listPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JButton addUserButton = new JButton("Add new User");
	JButton addTaskButton = new JButton("Add new Task");
	JButton selectTaskButton = new JButton("Choose new task");
	JLabel userLabel = new JLabel (" USERS: ", SwingConstants.LEFT);
	JLabel taskLabel = new JLabel (" TASKS: ", SwingConstants.LEFT);
	
	DefaultComboBoxModel<User> usersList = new DefaultComboBoxModel<>();
	DefaultComboBoxModel<Task> tasksList = new DefaultComboBoxModel<>();
	JList listWithUsers = new JList(usersList);
	JList listWithTasks = new JList(tasksList);
	
	public Planner() {
		super ("Planner. Learn IT, Girl!");
		plannerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plannerFrame.setSize(800, 600);
		plannerFrame.setLocation(200, 100);
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
				
		//add buttons to panelButtons
		buttonPanel.add(addUserButton);
	    buttonPanel.add(addTaskButton);
	    buttonPanel.setSize(200, 200);
	    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		// User's list
		User user1 = new User("Justyna", "Garyga");
		User user2 = new User("Piter", "Garyga");
		User user3 = new User("Kris", "Garyga");
		User user4 = new User("Barbara", "Garyga");
		
		usersList.addElement(user1);
		usersList.addElement(user2);
		usersList.addElement(user3);
		usersList.addElement(user4);
		
		// Task's list
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
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		userLabel.setBorder(border); 
		taskLabel.setBorder(border);
		
		listPanel.add(userLabel); 
		listPanel.add(listWithUsers);
		listPanel.add(Box.createRigidArea(new Dimension(0,20)));
		listPanel.add(taskLabel);
		listPanel.add(listWithTasks);
		listPanel.setBackground(Color.white);
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setAlignmentY(LEFT_ALIGNMENT); // correct alignment to the left (labels!) 
		
		// layout
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.white);
		topPanel.add(buttonPanel, BorderLayout.LINE_END);
		topPanel.add(selectTaskButton, BorderLayout.LINE_START);
		plannerFrame.add(topPanel, BorderLayout.PAGE_START);
		plannerFrame.add(listPanel, BorderLayout.LINE_START);
		
		//show a dialog when we click on the user in User's list
		listWithUsers.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evtU) {
				JTextField userName = new JTextField(25);
			    JTextField userSurname = new JTextField(25);
			    JPanel userPanel = new JPanel();
			    userPanel.add(new JLabel("Edit name:"));
			    userPanel.add(userName);
			    userPanel.add(Box.createVerticalStrut(15)); // a spacer
			    userPanel.add(new JLabel("Edit surname:"));
			    userPanel.add(userSurname);
			    userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
				if (evtU.getValueIsAdjusting() == false) {
					 int result = JOptionPane.showConfirmDialog(null, userPanel, 
				               "Edit the User", JOptionPane.OK_CANCEL_OPTION);
					 if (result == JOptionPane.OK_OPTION) {
				         System.out.println("Name: " + userName.getText());
				         System.out.println("Surname: " + userSurname.getText());
				         User editUser = (User)listWithUsers.getSelectedValue();
				         editUser.setName(userName.getText());
				         editUser.setSurname(userSurname.getText());
					 }
				}
			}
		});
		
		//show a dialog when we click on the task
		listWithTasks.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evtT) {
				JComboBox selectTask = new JComboBox(tasksList);
				JComboBox assignedTo = new JComboBox(usersList);
				JTextField start = new JTextField(30);
			    JTextField end = new JTextField(30);
				JTextField taskName = new JTextField(25);
			    JTextField taskDescription = new JTextField(30);
				JPanel taskPanel = new JPanel();
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
			    taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
				if (evtT.getValueIsAdjusting() == false) {
					 int result = JOptionPane.showConfirmDialog(null, taskPanel, 
				               "Edit the task", JOptionPane.OK_CANCEL_OPTION);
					 if (result == JOptionPane.OK_OPTION) {
				         Task editTask = (Task)listWithTasks.getSelectedValue();
				         editTask.setNameTask(taskName.getText());
				         editTask.setStartTime(start.getText());
				         editTask.setEndTime(end.getText());
				         System.out.println("Name of task: " + taskName.getText());
				         System.out.println("Description of task: " + taskDescription.getText());
				         System.out.println("Start: " + editTask.getStartTime());
				         System.out.println("End: " + editTask.getEndTime());
				         System.out.println("Assigned to: " + editTask.getAssignedTo());
					 }
				}
				System.out.println("Selected from " + evtT.getFirstIndex() + " to " + evtT.getLastIndex());
			}
		});
	}      
}
