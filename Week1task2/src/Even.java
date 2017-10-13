
public class Even {

	public static void main(String[] args) {
		System.out.println("Is number 16 even? - " + isEven(16));
		System.out.println("Is number 11 even? - " + isEven(11));
		System.out.println("Is number 101 even? - " + isEven(101));
		System.out.println("Is number 22 even? - " + isEven(22));
		System.out.println("Is number 55 even? - " + isEven(55));
		System.out.println("Is number 68 even? - " + isEven(68));
	}
	public static boolean isEven(int number) {
		if (number % 2 == 0) {	
			return true;	
		} else { 
			return false;
		}
	}

}
