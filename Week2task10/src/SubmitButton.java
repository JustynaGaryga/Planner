import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SubmitButton extends JFrame {
	JFrame frame = new JFrame();
	JButton submit = new JButton("Submit");
	
	public SubmitButton() {
		super( "Learn IT Girl" );
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocation(200, 200);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		// the text field
		JPanel panel = new JPanel();
		JTextField nameField = new JTextField(30);
		JTextField surnameField = new JTextField(30);
		JTextField emailField = new JTextField(30);
		JLabel name = new JLabel("Name: ");
	    JLabel surname = new JLabel("Surname: ");
	    JLabel email = new JLabel("E-mail: ");
	    submit.setPreferredSize(new Dimension(40, 40));
	    submit.setEnabled(false);
	    panel.add(name);
	    panel.add(nameField);
	    panel.add(Box.createRigidArea(new Dimension(0,20)));
	    panel.add(surname);
		panel.add(surnameField);
		panel.add(Box.createRigidArea(new Dimension(0,20)));
		panel.add(email);
		panel.add(emailField);
		panel.add(Box.createRigidArea(new Dimension(0,20)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel, BorderLayout.CENTER);
		frame.add(submit, BorderLayout.PAGE_END);
		
		//button become clickable when all the text fields have been completed
		nameField.addKeyListener(new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	        	if (nameField.getText().length() == 0 || surnameField.getText().length() == 0 
	        		|| emailField.getText().length() == 0) {
	        				submit.setEnabled(false);
	        	} else {
	        		submit.setEnabled(true);
	        	}
	        }
		});
		surnameField.addKeyListener(new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	        	if (nameField.getText().length() == 0 || surnameField.getText().length() == 0 
		        		|| emailField.getText().length() == 0) {
	        				submit.setEnabled(false);
	        	} else {
	        		submit.setEnabled(true);
	        	}
	        }
		});
		emailField.addKeyListener(new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	        	if (nameField.getText().length() == 0 || surnameField.getText().length() == 0 
		        		|| emailField.getText().length() == 0) {
	        				submit.setEnabled(false);
	        	} else {
	        		submit.setEnabled(true);
	        	}
	        }
		});
		
		//after clicking button, window show up displaying the texts that have beed added in the 
		//text fields
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JPanel buttonPanel = new JPanel(); 
			    buttonPanel.add(name);
			    buttonPanel.add(nameField);
			    buttonPanel.add(Box.createVerticalStrut(15)); // a spacer
			    buttonPanel.add(surname);
			    buttonPanel.add(surnameField);
			    buttonPanel.add(Box.createVerticalStrut(15)); // a spacer
			    buttonPanel.add(email);
			    buttonPanel.add(emailField);
			    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

			    int result = JOptionPane.showConfirmDialog(null, buttonPanel, 
			               "New User", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION) {
			         System.out.println("Name: " + nameField.getText());
			         System.out.println("Surname: " + surnameField.getText());
			         System.out.println("E-mail: " + emailField.getText());
			    }}});
	}
}