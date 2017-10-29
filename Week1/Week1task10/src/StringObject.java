public class StringObject {
	
	public static void main(String[] args) {
		// creating two Strings 
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