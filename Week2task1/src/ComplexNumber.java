
public class ComplexNumber {
	Integer real;
	Integer im;
	/**
	 * @param real
	 * @param im
	 */
	public ComplexNumber(Integer real, Integer im) {
		super();
		this.real = real;
		this.im = im;
	}

	public ComplexNumber() {
		// TODO Auto-generated constructor stub
	
	}
	
	public Integer getReal() {
		return real;
	}

	public void setReal(Integer real) {
		this.real = real;
	}

	public Integer getIm() {
		return im;
	}

	public void setIm(Integer im) {
		this.im = im;
	}
	// receiving as argument another ComplexNumber and doing the sum of the numbers
	public static ComplexNumber sum(ComplexNumber num1, ComplexNumber num2) {
		ComplexNumber sum = new ComplexNumber();
		sum.real = num1.real + num2.real;
		sum.im = num1.im + num2.im;
		return sum;
	}
	// receiving as param another ComplexNumber and doing the product of the numbers
	public static ComplexNumber product(ComplexNumber num1, ComplexNumber num2) {
		ComplexNumber product = new ComplexNumber();
		product.real = (num1.real*num2.real - num1.im*num2.im);
		product.im = (num1.real*num2.im + num2.real*num1.im);
		return product;
	}
	// printing the complex number in the format: a + bi (real + "+" + im + "*" + "i")
	public String toString(ComplexNumber num1, ComplexNumber num2) {
		String format = (real + "+" + im + "*" + "i");  
		return format;
	}
	// testing if two complex numbers are equal
	public static void equals(ComplexNumber num1, ComplexNumber num2) {
		if (num1.real == num2.real) {
			if (num1.im == num2.im) {
			System.out.println("The complex numbers are equals.");
			}
		}else {
		System.out.println("The complex numbers are not equals.");
		}
	}
	
	public static void main(String[] ags) {
		// TODO Auto-generated method stub
		//my examples of complex numbers
		ComplexNumber num1 = new ComplexNumber(5, 3);
		ComplexNumber num2 = new ComplexNumber(6, 9); 
		
		System.out.println("Complex number 1: " + "(" + num1.real + ", " + num1.im + ")");
		System.out.println("Complex number 2: " + "(" + num2.real + ", " + num2.im + ")");
		System.out.println("Sum of complex numbers: " + sum(num1, num2));
		System.out.println("Product of complex numbers: " + product(num1, num2));
		System.out.println("Complex number 1= " + num1.toString(num1, num2));
		System.out.println("Complex number 2= " + num2.toString(num1, num2));
		equals(num1, num2);
	}
}
