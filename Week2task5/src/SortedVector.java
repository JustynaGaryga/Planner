import java.util.Vector;
import java.util.Collections;
import java.util.List;

public class SortedVector  extends Vector {

	public SortedVector() {
		// TODO Auto-generated constructor stub
		super();
	}
	public void addElement(String s) {
		this.addElement(s);
		Collections.sort(this);
	}
		
	public void insertElementAt(String s, int pos) {
		this.insertElementAt(s, pos);
		Collections.sort(this);
	}
	
	
}

