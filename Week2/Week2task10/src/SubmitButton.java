import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubmitButton extends JFrame {
	public SubmitButton() {
		super( "Learn IT Girl" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocation(200, 200);
		setLayout(new GridLayout(1, 4));
		
		// the text field
		JPanel panel = new JPanel();
		JTextField nameField = new JTextField(getText());
		nameField.setBounds(20, 50, 200, 25);
		JTextField surnameField = new JTextField(" ");
		JTextField emailField = new JTextField(" ");
		JLabel name = new JLabel("Name: ");
	    JLabel surname = new JLabel("Surname: ");
	    JLabel email = new JLabel("E-mail: ");
	    panel.add(name);
	    panel.add(nameField);
	    panel.add(surname);
		panel.add(surnameField);
		panel.add(email);
		panel.add(emailField);
		add(panel);
		add(new JButton("Submit"));
		nameField.getText();
		
		setVisible(true);
	}

	private String getText() {
		// TODO Auto-generated method stub
		String name = " ";
		return name;
	}
}