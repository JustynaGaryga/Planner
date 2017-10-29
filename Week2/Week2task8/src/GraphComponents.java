import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Choice;
import java.awt.Scrollbar;
import java.awt.GridLayout;

public class GraphComponents extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Choice days;
	
	public GraphComponents() {
		super( "Learn IT Girl" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocation(200, 200);
		setLayout(new GridLayout(4, 4));
		JPanel panel = new JPanel();
		
		// the checkboxes
		panel.add(new JCheckBox("One"));
		panel.add(new JCheckBox("Two"));
		panel.add(new JCheckBox("Three"));
		add(panel);
		
		// the list
		String[] data = {"One", "Two", "Three"};
		add(new JList<String>(data));
		
		// the choice field
		days = new Choice();
		days.addItem("Monday");
		days.addItem("Tuesday");
		days.addItem("Wednesday");
		days.addItem("Thursday");
		days.addItem("Friday");
		days.addItem("Saturday");
		days.addItem("Sunday");
		add(days);
		
		//the scroll bar
		add(new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 50));
		
		// the text field
		JTextField nameField = new JTextField("Learn IT Girl Program");
		add(nameField);
		
		setVisible(true);
	}
}