import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		// my arrays
		int[] array1 = {5, 3, 8, 10, 1, 6, 2};
		int[] array2 = {11, 19, 3, 2, 17, 15, 8, 10, 1};
		int[] array3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		// calling the method bubbleSort for my arrays
		System.out.println("Array 1: " + Arrays.toString(array1));
		int[] newArray1 = Sort.bubbleSort(array1);
		System.out.println("Sorted array 1: " + Arrays.toString(newArray1));
		System.out.println();
		System.out.println("Array 2: " + Arrays.toString(array2));
		int[] newArray2 = Sort.bubbleSort(array2);
		System.out.println("Sorted array 2: " + Arrays.toString(newArray2));
		System.out.println();
		System.out.println("Array 3: " + Arrays.toString(array3));
		int[] newArray3 = Sort.bubbleSort(array3);
		System.out.println("Sorted array 3: " + Arrays.toString(newArray3));
	}	

}
