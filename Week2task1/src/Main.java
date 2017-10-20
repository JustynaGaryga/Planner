
public class Main {

		
	public static void main(String[] ags) {
		// TODO Auto-generated method stub
		//my examples of complex numbers
		ComplexNumber num1 = new ComplexNumber(5, 3);
		ComplexNumber num2 = new ComplexNumber(6, 9); 
		
		System.out.println("Complex number 1: " + "(" + num1.real + ", " + num1.im + ")");
		System.out.println("Complex number 2: " + "(" + num2.real + ", " + num2.im + ")");
		System.out.println("Sum of complex numbers: " + ComplexNumber.sum(num1, num2).toString());
		System.out.println("Product of complex numbers: " + ComplexNumber.product(num1, num2).toString());
		System.out.println("Complex number 1= " + num1.toString());
		System.out.println("Complex number 2= " + num2.toString());
		System.out.println(ComplexNumber.equals(num1, num2));
		
		num1.equals(num2);
		num1.add(num2);
		System.out.println(num1);
		
		
	}
}
