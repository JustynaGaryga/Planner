
public class ComplexNumber {

	public ComplexNumber() {
		// TODO Auto-generated constructor stub
	}

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
	public String toString() {
		String format = (this.real + "+" + this.im + "*" + "i");  
		return format;
	}
	// testing if two complex numbers are equal
	public static boolean equals(ComplexNumber num1, ComplexNumber num2) {
		if (num1.real == num2.real) {
			if (num1.im == num2.im) {
				return true;
			}
		}
		return false;
	}
	
	public void add(ComplexNumber num1) {
		this.real = this.real + num1.real;
		this.im = this.im + num1.im;
	}
	public void product(ComplexNumber num1) {
		this.real = (num1.real*this.real - num1.im*this.im);
		this.im = (num1.real*this.im + this.real*num1.im);
	}
	public boolean equals(ComplexNumber num1) {
		if (num1.real == this.real) {
			if (num1.im == this.im) {
				return true;
			}
		}
		return false;
	}
}
