import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedVector vector1 = new SortedVector();
		SortedVector vector2 = new SortedVector();
		vector1.addElement("Hello");
		vector1.addElement("Andreea");
		vector1.addElement("Justyna");
		System.out.println(vector1.toString());
		
		vector1.insertElementAt("Friday", 3);
		vector1.insertElementAt("Sunday", 4);
		System.out.println(vector1.toString());
	}
}
