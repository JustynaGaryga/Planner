import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class toArrayList {

	public static void main(String[] args) {
		// creating an ArrayList
		ArrayList<Integer> al = new ArrayList<>();
		al.add(25);
		al.add(89);
		al.add(23);
		al.add(56);
		al.add(11);
		al.add(3);
		System.out.println("Min value: " + Collections.min(al));
		System.out.println("Max value: " + Collections.max(al));
		System.out.println("Sorting list: ");
		Collections.sort(al);
		System.out.println(al.toString());
	}

}
