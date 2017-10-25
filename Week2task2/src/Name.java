public class Name implements Comparable<Name> {
	
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
	
	// checks if one Name object is equal to another Name object
	public boolean equals(Name person1) {
		if (person1.name.equals(this.name)) {
			if (person1.surname.equals(this.surname)) {
				return true;
			}
		}
		return false;
	}
	
	// compares the pair of Name Objects
	public int compareTo(Name person1) {
		int diff = this.name.compareTo(person1.name);
		int diff2 = this.surname.compareTo(person1.surname);
		if (diff == 0) {
			if (diff2 == 0) {
				return 0;
			}
		} else if (diff < 0) {
			if (diff2 < 0 || diff2 ==0) {
				return -1;
			} 
			if (diff2 > 0) {
				return 1;
			}
		} else if (diff > 0) {
			if (diff2 > 0 || diff2 == 0) {
				return 1;
			}
			if (diff2 < 0) {
				return -1;
			}
		}
		return 1;
	}
	// returns the string representation of the object
	public String toString() {
		String people = (this.name + " " + this.surname);
		return people;
	}
}
