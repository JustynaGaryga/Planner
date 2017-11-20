
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetAsVector vector1 = new SetAsVector();
		SetAsVector vector2 = new SetAsVector();
		vector1.addElement("January");
		vector1.addElement("February");
		vector1.addElement("March");
		vector1.addElement("April");
		vector1.addElement("May");
		System.out.println("Vector: " + vector1.toString());
		
		vector1.add("November");
		System.out.println("Vector with added element: " + vector1.toString());
		
		vector1.add("November");
		System.out.println("Try to add the same item the second time: " + vector1.toString());
		System.out.println(vector1.add("November"));
	
		vector1.remove("January");
		System.out.println("Remove an existing item: " + vector1.toString());
		System.out.println(vector1.remove("January"));
		
		vector1.remove("June");
		System.out.println("Remove an unexisting item: " + vector1.toString());
		System.out.println(vector1.remove("June"));
		
		System.out.println("If vector contains an existing element? " + vector1.contains("March"));
		
	}
}
