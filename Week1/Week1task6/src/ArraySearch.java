import java.util.Arrays;
public class ArraySearch {

	public static void main(String[] args) {
		//initialising an array
		int[] number = {38, 15, 42, 78, 49, 11, 61, 19, 90, 3};
		System.out.println("Unsorted Array: " + Arrays.toString(number));
		
		// sorting array
		Arrays.sort(number);
		System.out.println("Sorted Array: " + Arrays.toString(number));
		
		// searching an existing value in the array
		int searchValue = 49;
		int foundValue = Arrays.binarySearch(number, searchValue);
		System.out.println("Searching existing value: " + searchValue);
		System.out.println("Found value: " + number[foundValue]);
		System.out.println("Index of value " + number[foundValue] + " : " + foundValue);
		
		// searching an unexisting value in the array
		int searchValue2 = 2;
		int foundValue2 = Arrays.binarySearch(number, searchValue2);
		System.out.println("Searching unexisting value: " + searchValue2);
		System.out.println(foundValue2);
		if (foundValue2 != -1 && foundValue2 < number.length) {
			System.out.println(number[foundValue2]);
		}
		else {
			System.out.println("The value " + searchValue2 + " does not exist in the array");
		}
	}
}	
		
	
	
	
	

