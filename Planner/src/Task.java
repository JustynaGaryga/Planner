import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;


public class Task {
	String nameTask;
	String descriptionTask;
	String startTask;
	String endTask;
	
	/**
	 * @param nameTask
	 * @param descriptionTask
	 */
	
	public Task(String nameTask, String descriptionTask) {
		super();
		this.nameTask = nameTask;
		this.descriptionTask = descriptionTask;
	}
	public String getNameTask() {
		return nameTask;
	}
	public void setNameTask(String nameTask) {
		this.nameTask = nameTask;
	}
	public String getDescriptionTask() {
		return descriptionTask;
	}
	public void setDescriptionTask(String descriptionTask) {
		this.descriptionTask = descriptionTask;
	}
	public String toString() {
		return nameTask;
	}
	public String getStartTask() {
		return startTask;
	}
	public void setStartTask(String startTask) {
		this.startTask = startTask;
	}
	public String getEndTask() {
		return endTask;
	}
	public void setEndTask(String endTask) {
		this.endTask = endTask;
	}
	
	public void date() {
	
	/*
	I should use: org.joda.time.format.DateTimeFormat;
	DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
	DateTime dt = formatter.parseDateTime(string);
	*/

	}
}
