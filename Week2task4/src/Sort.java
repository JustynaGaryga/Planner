
public class Sort {

	public Sort() {
		// TODO Auto-generated constructor stub
	}
	public static int[] bubbleSort(int[] array) {
		for (int i = 0; i<array.length; i++) {
			for (int j = 1; j<array.length; j++) {
				if (array[j] < array[j-1]) {
					int bigger = array[j-1];
					array[j-1] = array[j];
					array[j] = bigger;
				}
			}
		}
		return array;
	}	
}
