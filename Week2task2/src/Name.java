
public class Name {
	
	String name;
	String surname;
	/**
	 * @param name
	 * @param surname
	 */
	public Name(String name, String surname) {
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

	public Name() {
		// TODO Auto-generated constructor stub
	}
	
	public Name(Name person) {
		name = person.name;
		surname = person.surname;
	}
	
	// check if one Name object is equal to another Name object
	public boolean equal(Name person1) {
		if (person1.name.equals(this.name)) {
			if (person1.surname.equals(this.surname)) {
				return true;
			}
		}
		return false;
	}
	
	//
	public int compareTo(Name person1) {
		int diff = person1.name.compareTo(this.name);
		if (diff == 0) {
			System.out.println("Names are equals.");
		}	else if (diff < 0) {
			return 1;
		} else if (diff > 0) { 
			return -1;
		}
	
	}
	
	// 
	public String toString() {
		String people = (this.name + " " + this.surname);
		return people;
	}
	
}
