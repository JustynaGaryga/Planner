import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

class CellRenderer implements TableCellRenderer {
	
	JTextArea textArea;
    JScrollPane scrollPane;
    JList taskList;
    JPanel panel;
    Date today = Calendar.getInstance().getTime();
    Calendar cal;
    ArrayList<Task> tasks;
    DefaultComboBoxModel<Task> cellTasks;

    public CellRenderer(ArrayList<Task> tasks, Calendar cal) {
        cellTasks = new DefaultComboBoxModel<>();
        taskList = new JList(cellTasks);
        textArea = new JTextArea();
        panel = new JPanel();
        panel.add(textArea);
        panel.add(taskList);
        scrollPane = new JScrollPane(panel);
        this.cal = cal;
        this.tasks = tasks;
    }

  public static final DefaultTableCellRenderer DEFAULT_RENDERER =
    new DefaultTableCellRenderer();

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    Component renderer =
      DEFAULT_RENDERER.getTableCellRendererComponent(table, value,
      isSelected, hasFocus, row, column);
  
    Color foreground = null, background = null;
    if (isSelected) {
      foreground = Color.YELLOW;
      background = Color.GRAY;
    }  
    
    Integer day = (Integer) value;
    int month = cal.get(Calendar.MONTH);
	int year = cal.get(Calendar.YEAR);
    System.out.println("Day " + day);
    System.out.println("Month " + month);
    System.out.println("Year " + year);
    System.out.println("Today is " + today);
    if (value != null) {
    	Date cellDate = new GregorianCalendar(year, month, day).getTime();
    	Date firstDate = getZeroTimeDate(cellDate);
    	Date secondDate = getZeroTimeDate(today);
    	if (firstDate.equals(secondDate)) {
    		foreground = Color.RED;
    		background = Color.GREEN;
    		System.out.println("Is that equal?");
    	}
    	System.out.println("Cell date: " + cellDate);
    	for (Task t : tasks) {
    		Date taskDate = getZeroTimeDate(t.getStartTime());
    		if (firstDate.equals(taskDate)) {
    			cellTasks.addElement(t);
    			System.out.println("t " + t);
    		}
    	}
    }
    renderer.setForeground(foreground);
    renderer.setBackground(background);
    return renderer;
   
    /*
    if(null != value)
        textArea.setText(value.toString());

    return scrollPane;
    */
  }
  
  public static Date getZeroTimeDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}
}
