import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Planner extends JFrame {
	JFrame plannerFrame = new JFrame("Planner. Learn IT, Girl!");
	Calendar cal = new GregorianCalendar(Locale.ENGLISH);
	String month;
	int year;
	DefaultTableModel model;
	JPanel listPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel changeMonthPanel = new JPanel();
	JPanel calPanel = new JPanel();
	JButton addUserButton = new JButton("Add new User");
	JButton addTaskButton = new JButton("Add new Task");
	JLabel userLabel = new JLabel (" USERS: ", SwingConstants.LEFT);
	JLabel taskLabel = new JLabel (" TASKS: ", SwingConstants.LEFT);
	JLabel taskTodayLabel = new JLabel (" Today's TASKS: ", SwingConstants.LEFT);
	JLabel monthLabel = new JLabel();
	Date today = Calendar.getInstance().getTime();
	
	DefaultComboBoxModel<User> usersList = new DefaultComboBoxModel<>();
	DefaultComboBoxModel<Task> tasksList = new DefaultComboBoxModel<>();
	DefaultComboBoxModel<Task> tasksToday = new DefaultComboBoxModel<>();
	JList listWithUsers = new JList(usersList);
	JList listWithTasks = new JList(tasksList);
	
	public Planner() {
		super ("Planner. Learn IT, Girl!");
		plannerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plannerFrame.setSize(800, 600);
		plannerFrame.setLocation(300, 50);
		plannerFrame.getContentPane().setBackground(Color.yellow); // temporary color
		plannerFrame.setVisible(true);
		
		// create the ArrayLists of users and tasks
		ArrayList<User> users = UserDAO.getUsers();
		for (User u : users) {
			usersList.addElement(u);
		}
		System.out.println(users.toString());
		
		ArrayList<Task> tasks = TaskDAO.getTasks(users);
		for (Task t : tasks) {
			tasksList.addElement(t);
		}
		System.out.println(tasks.toString());
		
		// button for adding new users - it WORKS
		AddNewUser newUser = new AddNewUser(usersList);
		addUserButton.addActionListener(newUser);
		
		// button for adding new task
		AddNewTask newTask = new AddNewTask(usersList, tasks, users, tasksToday);
		addTaskButton.addActionListener(newTask);
		
		// add buttons to panelButtons
		buttonPanel.add(addUserButton);
		buttonPanel.add(addTaskButton);
		buttonPanel.setSize(200, 200);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		// list with today's tasks
		JList listWithTasksToday= new JList(tasksToday);
		ArrayList<Task> tasksTod = new ArrayList<Task>();
		for (Task t : tasks) {
			Date firstDate = CellRenderer.getZeroTimeDate(t.getStartTime());
			Date secondDate = CellRenderer.getZeroTimeDate(today);
			if (firstDate.equals(secondDate)) {
				tasksToday.addElement(t);
			}
		}	
		System.out.println("=============================================================================== ");
		System.out.println(tasksToday.toString());
		
		// show a dialog for edit user, when we click on the user
		ListUserListener listListenerU = new ListUserListener(usersList, listWithUsers);
		listWithUsers.addListSelectionListener(listListenerU);
		
		// show a dialog for edit task, when we click on the task
		ListTaskListener listListenerT = new ListTaskListener(usersList, tasksToday, listWithTasksToday, users);
		listWithTasks.addListSelectionListener(listListenerT);
		listWithTasksToday.addListSelectionListener(listListenerT);
	
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

		Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		userLabel.setBorder(border); 
		taskLabel.setBorder(border);
		taskTodayLabel.setBorder(border);
		
		// the panel with list on the left side
		listPanel.add(userLabel); 
		listPanel.add(listWithUsers);
		listPanel.add(Box.createRigidArea(new Dimension(0,20)));
		//listPanel.add(taskLabel);
		//listPanel.add(listWithTasks);
		listPanel.add(taskTodayLabel);
		listPanel.add(listWithTasksToday);
		listPanel.setBackground(Color.white);
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		
		// the panel with buttons on the top
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.white);
		topPanel.add(buttonPanel, BorderLayout.LINE_END);
		plannerFrame.add(topPanel, BorderLayout.PAGE_START);
		plannerFrame.add(listPanel, BorderLayout.LINE_START); 
		
		// JTable for calendar
		String[] columnNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		model = new DefaultTableModel(null, columnNames);
		JTable calendar = new JTable(model);
	    monthLabel.setHorizontalAlignment(SwingConstants.CENTER);

		calendar.setRowHeight(70);
		calendar.setCellSelectionEnabled(true); // cells are clicable
		calendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		calendar.setShowGrid(true); 
		calendar.setGridColor(Color.LIGHT_GRAY);
		JScrollPane sp=new JScrollPane(calendar);
		int rowCount = 5;
		model.setRowCount(rowCount);
		
		// cells renderer 
		calendar.setDefaultRenderer(Object.class, new CellRenderer(tasks, cal));
		
		// cells listeners
		CellListener cellListen = new CellListener(usersList, tasks, users, tasksToday, calendar, cal);
		ListSelectionModel cellSelectionModel = calendar.getSelectionModel();
	    cellSelectionModel.addListSelectionListener(cellListen);
	    calendar.getColumnModel().getSelectionModel().addListSelectionListener(cellListen);

		// last month
		JButton buttonLow = new JButton("<-");
			buttonLow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					cal.add(Calendar.MONTH, -1);
					updateMonth();
				}
		    });
		
		// next month
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
		changeMonthPanel.setBackground(Color.lightGray);
		calPanel.add(changeMonthPanel);
		calPanel.add(sp);
		calPanel.setLayout(new BoxLayout(calPanel, BoxLayout.Y_AXIS));
		plannerFrame.add(calPanel);
		
		this.updateMonth();
		
		// display today's date
		System.out.println("Today is: " + today);
		JTextField todayField = new JTextField(today.toString());
		plannerFrame.add(todayField, BorderLayout.PAGE_END);
	}

	//method to update month 
	void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		     
		month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		year = cal.get(Calendar.YEAR);
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
}
