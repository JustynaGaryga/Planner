import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Name person = new Name ("Anna", "Wick");
		Name person1 = new Name("Justyna", "Garyga"); 
		Name person2 = new Name("Anna", "Smith"); 
		
		// create ArrayList, sort and print sorted list
		List<Name> people = new ArrayList<>();
		people.add(person);
		people.add(person1);
		people.add(person2);
	
		Collections.sort(people);
		//Arrays.sort and Collections.sort don't work
	
		System.out.println("List of people: " + people.toString());
		System.out.println("Comparison of two Name objects: " + person1.equals(person2));
		person1.compareTo(person2);
		
		
		
	
	}
}
