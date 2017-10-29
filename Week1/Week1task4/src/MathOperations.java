
public class MathOperations {

	public static void main(String[] args) {
		System.out.println("Sum of 10 and 20 = " + sum(10, 20));
		System.out.println("Difference of 10 and 20 = " + difference(10, 20));
		System.out.println("Average of 10 and 20 = " + average(10, 20));
		System.out.println();
		System.out.println("Sum of 34 and 48 = " + sum(34, 48));
		System.out.println("Difference of 34 and 48 = " + difference(34, 48));
		System.out.println("Average of 34 and 48 = " + average(34, 48));
		System.out.println();
		System.out.println("Sum of 99 and 66 = " + sum(99, 66));
		System.out.println("Difference of 99 and 66 = " + difference(99, 66));
		System.out.println("Average of 99 and 66 = " + average(99, 66));
		System.out.println();
		System.out.println("Sum of 78 and 25 = " + sum(78, 25));
		System.out.println("Difference of 78 and 25 = " + difference(78, 25));
		System.out.println("Average of 78 and 25 = " + average(78, 25));
		System.out.println();

	}
	public static int sum(int x, int y) {
		int sum = x + y;
		return sum;
	}
	public static int difference(int x, int y) {
		int diff = x - y;
		return diff;
	}
	public static int average(int x, int y) {
		int aver = (x + y)/2;
		return aver;
	}

}
