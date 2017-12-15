import java.util.ArrayList;

import javax.swing.ListModel;

public class User {
	String name;
	String surname;
	int id;
	
	//public static ListModel<User> usersList;
	
	/**
	 * @param name
	 * @param surname
	 */
	public User(String name, String surname, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
	}
	public User(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = -1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
