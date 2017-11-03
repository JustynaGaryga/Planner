import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Planner extends JFrame {
	JFrame plannerFrame = new JFrame();
	JPanel listPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel panelButtons = new JPanel();
	JButton addUserButton = new JButton("Add new User");
	JButton addTaskButton = new JButton("Add new Task");
	DefaultListModel<User> usersList = new DefaultListModel<>();
	DefaultListModel<Task> tasksList = new DefaultListModel<>();
	JList listWithUsers = new JList(usersList);
	JList listWithTasks = new JList(tasksList);
	
	public Planner() {
		super ("Planner. Learn IT, Girl!");
		plannerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plannerFrame.setSize(600, 600);
		plannerFrame.setLocation(200, 100);
		plannerFrame.getContentPane().setBackground(Color.YELLOW);
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
				JTextField taskName = new JTextField(25);
			    JTextField taskDescription = new JTextField(50);
			    JPanel taskPanel = new JPanel();
			    taskPanel.add(new JLabel("Task's name:"));
			    taskPanel.add(taskName);
			    taskPanel.add(Box.createVerticalStrut(15)); // a spacer
			    taskPanel.add(new JLabel("Task's description:"));
			    taskPanel.add(taskDescription);

			    int result = JOptionPane.showConfirmDialog(null, taskPanel, 
			               "Create a new Task", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION) {
			         System.out.println("Task's name: " + taskName.getText());
			         System.out.println("Task's description: " + taskDescription.getText());
			         Task newTask = new Task(taskName.getText(), taskDescription.getText());
			         tasksList.addElement(newTask);
			    }}});
		
		//add buttons to panelButtons
		panelButtons.add(addUserButton);
	    panelButtons.add(addTaskButton);
	    panelButtons.setSize(200, 200);
	    panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		
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
		
		listPanel.add(listWithUsers);
		listPanel.add(listWithTasks);
		listPanel.setBackground(Color.white);
		
		// layout
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.white);
		topPanel.add(panelButtons, BorderLayout.LINE_END);
		plannerFrame.add(topPanel, BorderLayout.PAGE_START);
		plannerFrame.add(listPanel, BorderLayout.LINE_START);
	}      
}
