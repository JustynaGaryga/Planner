import java.util.Arrays;
public class Array {

	public static void main(String[] args) {
		//initialising an array
		int[] number = {2, 20, 16, 8, 10, 6, 4, 14, 12, 18};
		printArray(number);

	}
	public static void printArray(int[] number) {
		// printing array in a single line
		for (int i = 0; i < number.length; i++) {
			System.out.print(" " + number[i]);
		}
		System.out.println();
		
		// printing sorted array in a single line
		Arrays.sort(number);
		for (int i = 0; i < number.length; i++) {
			System.out.print(" " + number[i]);
		}
		System.out.println();
	}

}
