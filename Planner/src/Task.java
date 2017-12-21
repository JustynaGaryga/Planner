import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task {
	String nameTask;
	String descriptionTask;
	Date startTime;
	Date endTime;
	User assignedTo;
	int taskID;
	
	/**
	 * @param nameTask
	 * @param descriptionTask
	 */
	
	public Task(String nameTask, String descriptionTask) {
		super();
		this.nameTask = nameTask;
		this.descriptionTask = descriptionTask;
	}
	
	public Task(String nameTask, String descriptionTask, Date startTime, Date endTime, User assignedTo, int taskID) {
		super();
		this.nameTask = nameTask;
		this.descriptionTask = descriptionTask;
		this.startTime = startTime;
		this.endTime = endTime;
		this.assignedTo = assignedTo;
		this.taskID = taskID;
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		Date startDate;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
			this.startTime = startDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			this.startTime = null;
		}
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		Date endDate;
		try {
			endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
			this.endTime = endDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			this.endTime = null;
		}
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public User getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
}
