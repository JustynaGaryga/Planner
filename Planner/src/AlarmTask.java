import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlarmTask extends TimerTask  {
	
	DefaultComboBoxModel<Task> tasksToday;
	Date today;
	
	public AlarmTask(DefaultComboBoxModel<Task> tasksToday){

		   this.tasksToday= tasksToday;

	   }
	public void showDialog(Task t, long elapsedMinutes) {
		// dialog/JFrame
		   JFrame frame = new JFrame();
		   JPanel alarmPanel = new JPanel();
		   JLabel alarmLabel = new JLabel("Task :");
		   JTextField alarmTextField = new JTextField(30);
		   alarmTextField.setText(t.getNameTask() + " starts in " + elapsedMinutes + " minutes.");
		   alarmTextField.setEditable(false);
		   alarmPanel.add(alarmLabel);
		   alarmPanel.add(alarmTextField);
		   JOptionPane.showMessageDialog(frame, alarmPanel, "Alarm" , 
		   JOptionPane.INFORMATION_MESSAGE);
	} 
	
	   public void run() {
		   try {
			   today = Calendar.getInstance().getTime();
			   for (int i = 0; i < tasksToday.getSize(); i++) {
				   Task t = tasksToday.getElementAt(i);
				   long different = t.getStartTime().getTime() - today.getTime();
				   long secondsInMilli = 1000;
				   long minutesInMilli = secondsInMilli * 60;
				   long hoursInMilli = minutesInMilli * 60;
				   long elapsedHours = different / hoursInMilli;
				   different = different % hoursInMilli;
				   long elapsedMinutes = different / minutesInMilli;
				   different = different % minutesInMilli;
				   System.out.println("Elapsed minutes " + elapsedMinutes + "====================================");
				   if (elapsedMinutes > 0 && elapsedMinutes > 5 && elapsedMinutes < 10) {
					   // dialog/JFrame
					   showDialog(t, elapsedMinutes);
				   }
				   if (elapsedMinutes > 0 && elapsedMinutes > 10 && elapsedMinutes < 15) {
					   showDialog(t, elapsedMinutes);
				   }
				   if (elapsedMinutes > 0 && elapsedMinutes < 5) {
					   showDialog(t, elapsedMinutes);
				   }
			   	}
		   	} catch (Exception ex) {

	            	System.out.println("error running thread " + ex.getMessage());
	    }
	}
	   
}
