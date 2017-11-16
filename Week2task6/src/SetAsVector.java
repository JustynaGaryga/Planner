import java.util.Vector;
import java.util.Collections;
import java.util.List;

public class SetAsVector extends Vector {
	public SetAsVector() {
		super();
	}
	public boolean contains(String s) {
		if (super.contains(s)) {
			return true;
		}
		return false;
	}
	public boolean add(String s) {
		if (super.contains(s)) {
			return false;
		}
		super.add(s);
			return true;
	}
	public boolean remove(String s) {
		if (super.contains(s)) {
			super.remove(s);
		}
		return true;
	}
}
