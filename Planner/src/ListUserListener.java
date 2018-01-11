import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListUserListener implements ListSelectionListener {

	DefaultComboBoxModel<User> usersList = new DefaultComboBoxModel<>();
	DefaultComboBoxModel<Task> tasksList = new DefaultComboBoxModel<>();
	JList listWithUsers = new JList(usersList);
	JList listWithTasks = new JList(tasksList);
	ArrayList<User> users;
	
	// show a JFrame for edit user, when we click on the user in User's list
	
	public void valueChanged(ListSelectionEvent evtU) {
		
		users = UserDAO.getUsers();
		for (User u : users) {
			usersList.addElement(u);
		}
		
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
				try {
					boolean result = UserDAO.deleteUser(editUser); 
					if (result == true) {
						usersList.removeElementAt(i);
					}
				} catch (SQLException e) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,
							"This user can not be deleted as it has one more tasks assigned to him.",
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				} finally {
					editUserFrame.dispose();
				}
			}
		});
	}
	// method to set the OK button enabled- JFrame to edit users
	void enableOKButtonUser (JTextField userName, JTextField userSurname, JButton okButton) {
		if (userName.getText().length() == 0 || userSurname.getText().length() == 0) {
			okButton.setEnabled(false);
		} else {
			okButton.setEnabled(true);
		}
	}
};

