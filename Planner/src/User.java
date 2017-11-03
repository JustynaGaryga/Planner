import java.util.ArrayList;

import javax.swing.ListModel;

public class User {
	String name;
	String surname;
	//public static ListModel<User> usersList;
	
	/**
	 * @param name
	 * @param surname
	 */
	public User(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String toString() {
		return surname + " " + name;
	}
}
