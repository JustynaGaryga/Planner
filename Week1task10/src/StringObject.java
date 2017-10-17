
public class StringObject {
	
	String one;
	String two;

	/**
	 * @param one
	 * @param two
	 */
	public StringObject(String one, String two) {
		super();
		this.one = one;
		this.two = two;
	}

	public StringObject() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		StringObject name = new StringObject();
		StringObject surname = new StringObject();
		name.one = "Justyna";
		surname.two = "Garyga";
		StringObject connected = new StringObject();
		// I don't know, what's next
		// methods name.concat(surname) and length(connected) don't work
		
		// solution of task without Objects
		String stringOne= "abcdefghij";
		String stringTwo = "klmnoprstquwyz";
		System.out.println("String one: " + stringOne);
		System.out.println("String two: " + stringTwo);
		// concatenating stringOne and stringTwo
		String stringNew = stringOne.concat(stringTwo);
		System.out.println("After concatenating: " + stringNew);
		// length of resulting String
		System.out.println("Length of new String: " + stringNew.length());
	}

}
