import java.util.ArrayList;

public class Task {
	String nameTask;
	String descriptionTask;
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
}
