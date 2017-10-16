import java.util.Arrays;
public class MinMax {

	public static void main(String[] args) {
		// creating an array
		int[] myArray = {5, 81, 9, 55, 62, 100, 64, 79, 27, 15};
		System.out.println(Arrays.toString(myArray));
		System.out.println("Min value = " + getMin(myArray));
		System.out.println("Max value = " + getMax(myArray));
	}
	// computing min value 
	public static int getMin(int[] myArray) {
		int min = myArray[0];
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] < min) {
				min = myArray[i];
			}
		}
		return min;
	}	
	// computing min value 
	public static int getMax(int[] myArray) {
		int max = myArray[0];
		for (int j = 0; j < myArray.length; j++) {
			if (myArray[j] > max) {
				max = myArray[j];
			}
		}
		return max;
	}	
}
