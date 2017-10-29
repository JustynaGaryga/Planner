import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClickOnButton extends JFrame  implements ActionListener {
	int numClicks = 0;
	
	public ClickOnButton() {
		super( "Learn IT Girl" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocation(400, 200);
		setLayout(new FlowLayout(70, 50, 50));
		JButton b = new JButton("Click me!");
		b.addActionListener(this);
		add(b);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// show a dialog with the message
		numClicks++;
		Frame frame = null;
		JOptionPane.showMessageDialog(frame, "You have clicked the button " + numClicks + " times.");
	}
}
