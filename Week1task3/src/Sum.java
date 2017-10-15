
public class Sum {

	public static void main(String[] args) {
		System.out.println("Sum 1+2+3+...+n, n = 16 : " + sumN(16));
		System.out.println("Sum 1+2+3+...+n, n = 5 : " + sumN(5));
		System.out.println("Sum 1+2+3+...+n, n = 23 : " + sumN(23));
		System.out.println("Sum 1+2+3+...+n, n = 23 : " + sumN(10));
		System.out.println("Sum 1+2+3+...+n, n = 23 : " + sumN(45));
		System.out.println("Sum 1+2+3+...+n, n = 23 : " + sumN(13));
	}
	public static int sumN(int n) {
		int sum = 0;
		while (n > 0) {
			sum = sum + n;
			n--;
		}
		return sum;
	}

}
