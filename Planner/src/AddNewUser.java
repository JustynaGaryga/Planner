import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewUser implements ActionListener {
	
	DefaultComboBoxModel<User> usersList = new DefaultComboBoxModel<>();
	
	// button for adding new users
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
			User userCreated = UserDAO.insertUser(newUser);
			usersList.addElement(userCreated);
		}};
}
