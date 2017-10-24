import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Scrollbar;
import java.awt.GridLayout;

public class GraphComponents extends JFrame {
	
	Choice days;
	
	public GraphComponents() {
		super( "Learn IT Girl" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocation(200, 200);
		setLayout(new GridLayout(4, 4));
		
		// the checkboxes
		add(new JCheckBox("One"));
		add(new JCheckBox("Two"));
		add(new JCheckBox("Three"));
		
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


