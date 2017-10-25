import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

	public class TwoButtons extends JFrame {
		public TwoButtons() {
			super( "Learn IT Girl" );
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(300, 200);
			setLocation(100, 100);
			setLayout(new FlowLayout(50, 50, 50));

			add(new JButton("OK"));
			add(new JButton("Cancel"));

			setVisible(true);
		}
	}