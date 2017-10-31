import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Users extends JFrame implements ActionListener {

	public Users() {
		super ("Planner");
		setLayout(new FlowLayout());
		setSize(800, 600);
		setLocation(200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton user = new JButton("Add new User");
		JButton task = new JButton("Add new Task");
		String[] userList = {"Justyna", "Piter", "Kris", "Basia"};
		String[] taskList = {"Wash clothes", "Shopping", "Wash a car", "Prepare breakfast", 
				"Prepare dinner", "Visit parents"};
		user.addActionListener(this);
		panel.add(user);
	    panel.add(task);
		add(panel);
		add(new JList<String>(userList));
		add(new JList<String>(taskList));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Frame frame = null;
		String name = JOptionPane.showInputDialog(frame, "Enter new user name: ");
		
	}

	
}
