import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import java.util.Timer;
import java.util.concurrent.TimeUnit;

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
	DefaultTableModel modelCalendar;
	JPanel listPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel changeMonthPanel = new JPanel();
	JPanel calPanel = new JPanel();
	JButton addUserButton = new JButton("Add new User");
	JButton addTaskButton = new JButton("Add new Task");
	JLabel userLabel = new JLabel (" USERS: ", SwingConstants.LEFT);
	JLabel taskLabel = new JLabel ("All TASKS: ", SwingConstants.LEFT);
	JLabel taskTodayLabel = new JLabel (" Today's TASKS: ", SwingConstants.LEFT);
	JLabel taskTomorrowLabel = new JLabel (" Tomorrow's TASKS: ", SwingConstants.LEFT);
	JLabel monthLabel = new JLabel();
	Date today = Calendar.getInstance().getTime();
	Date tomorrow = new Date(); 
	DefaultComboBoxModel<User> usersList = new DefaultComboBoxModel<>();
	DefaultComboBoxModel<Task> tasksList = new DefaultComboBoxModel<>();
	DefaultComboBoxModel<Task> tasksToday = new DefaultComboBoxModel<>();
	DefaultComboBoxModel<Task> tasksTomorrow = new DefaultComboBoxModel<>();
	JList listWithUsers = new JList(usersList);
	JList listWithTasks = new JList(tasksList);
	
	public Planner() {
		super ("Planner. Learn IT, Girl!");
		plannerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plannerFrame.setSize(1000, 600);
		plannerFrame.setLocation(300, 50);
		plannerFrame.getContentPane().setBackground(Color.LIGHT_GRAY); 
		plannerFrame.setVisible(true);
		
		// create the ArrayLists of users and tasks
		ArrayList<User> users = UserDAO.getUsers();
		for (User u : users) {
			usersList.addElement(u);
		}
		
		ArrayList<Task> tasks = TaskDAO.getTasks(users);
		for (Task t : tasks) {
			tasksList.addElement(t);
		}
		
		// button for adding new users
		AddNewUser newUser = new AddNewUser(usersList);
		addUserButton.addActionListener(newUser);
		
		// button for adding new task
		AddNewTask newTask = new AddNewTask(usersList, tasks, users, tasksToday, tasksList);
		addTaskButton.addActionListener(newTask);
		
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
		
		// alarm
		Timer time = new Timer();
		time.schedule(new AlarmTask(tasksToday), 0, TimeUnit.MINUTES.toMillis(1));
		
		// list with tomorrow's tasks
		Calendar calTomorrow = Calendar.getInstance();
		calTomorrow.setTime(tomorrow);
		calTomorrow.add(Calendar.DATE, 1);
		tomorrow = calTomorrow.getTime();
		JList listWithTasksTomorrow= new JList(tasksTomorrow);
		ArrayList<Task> tasksTom = new ArrayList<Task>();
		for (Task t : tasks) {
			Date firstDate = CellRenderer.getZeroTimeDate(t.getStartTime());
			Date secondDate = CellRenderer.getZeroTimeDate(tomorrow);
			if (firstDate.equals(secondDate)) {
				tasksTomorrow.addElement(t);
			}
		}	
		
		String[] columnNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		modelCalendar = new DefaultTableModel(null, columnNames);
		
		// show a dialog for edit user, when we click on the user
		ListUserListener listListenerU = new ListUserListener(usersList, listWithUsers);
		listWithUsers.addListSelectionListener(listListenerU);
		
		// show a dialog for edit task, when we click on the today's task
		ListTaskListener listListenerT = new ListTaskListener(usersList, tasksToday, listWithTasksToday, users, tasks, tasksList, modelCalendar);
		listWithTasksToday.addListSelectionListener(listListenerT);
		
		// show a dialog for edit task, when we click on the tomorrow's task
		ListTaskListener listListenerTomorrow = new ListTaskListener(usersList, tasksTomorrow, listWithTasksTomorrow, users, tasks, tasksList, modelCalendar);
		listWithTasksTomorrow.addListSelectionListener(listListenerTomorrow);
		
		// show a dialog for edit task, when we click on the task (list with all the tasks)
		ListTaskListener listListenerTask = new ListTaskListener(usersList, tasksList, listWithTasks, users, tasks, tasksList, modelCalendar);
		listWithTasks.addListSelectionListener(listListenerTask);

		Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		userLabel.setBorder(border); 
		taskLabel.setBorder(border);
		taskTodayLabel.setBorder(border);
		taskTomorrowLabel.setBorder(border);
		
		// the panel with buttons for adding users and tasks
		buttonPanel.add(addUserButton);
		buttonPanel.add(addTaskButton);
		buttonPanel.setSize(200, 200);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		JScrollPane scrollPaneListU = new JScrollPane();
		scrollPaneListU.setViewportView(listWithUsers);
		JScrollPane scrollPaneListT = new JScrollPane();
		scrollPaneListT.setViewportView(listWithTasks);
		JScrollPane scrollPaneListToday = new JScrollPane();
		scrollPaneListToday.setViewportView(listWithTasksToday);
		JScrollPane scrollPaneListTomorrow = new JScrollPane();
		scrollPaneListTomorrow.setViewportView(listWithTasksTomorrow);
		
		// the panel with list on the left side
		listPanel.add(userLabel); 
		listPanel.add(scrollPaneListU);
		listPanel.add(Box.createRigidArea(new Dimension(0,20)));
		listPanel.add(taskTodayLabel);
		listPanel.add(scrollPaneListToday);
		listPanel.add(Box.createRigidArea(new Dimension(0,20)));
		listPanel.add(taskTomorrowLabel);
		listPanel.add(scrollPaneListTomorrow);
		listPanel.add(Box.createRigidArea(new Dimension(0,20)));
		listPanel.add(taskLabel);
		listPanel.add(scrollPaneListT);
		listPanel.setBackground(Color.LIGHT_GRAY);
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		
		// the panel with buttons on the top
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.DARK_GRAY);
		topPanel.add(buttonPanel, BorderLayout.LINE_END);
		plannerFrame.add(topPanel, BorderLayout.PAGE_START);
		plannerFrame.add(listPanel, BorderLayout.LINE_START); 
		
		// JTable for calendar
		
		JTable calendar = new JTable(modelCalendar);
	    monthLabel.setHorizontalAlignment(SwingConstants.CENTER);

		calendar.setRowHeight(80);
		calendar.setCellSelectionEnabled(true); // cells are clicable
		calendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		calendar.setShowGrid(true); 
		calendar.setGridColor(Color.LIGHT_GRAY);
		JScrollPane sp=new JScrollPane(calendar);
		int rowCount = 5;
		modelCalendar.setRowCount(rowCount);
		
		// cells renderer 
		calendar.setDefaultRenderer(Object.class, new CellRenderer(tasks, cal));
		
		// cells listeners
		CellListener cellListen = new CellListener(usersList, tasks, users, tasksList, tasksToday, tasksTomorrow, calendar, cal);
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
		changeMonthPanel.setBackground(Color.LIGHT_GRAY);
		calPanel.add(changeMonthPanel);
		calPanel.add(sp);
		calPanel.setBackground(Color.LIGHT_GRAY);
		calPanel.setLayout(new BoxLayout(calPanel, BoxLayout.Y_AXIS));
		plannerFrame.add(calPanel);
		
		this.updateMonth();
		
		// display today's date
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
		
		modelCalendar.setRowCount(0);
		modelCalendar.setRowCount(weeks);
		
		int i = startDay-1;
		for(int day=1;day<=numberOfDays;day++){
			modelCalendar.setValueAt(day, i/7 , i%7 );    
			i = i + 1;
		}
	}     
}
