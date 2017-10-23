import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class CountWords {
	
	public CountWords() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lonleyDay = "Such a lonely day and it's mine, the most loneliest day of my life. Such a lonely day.";
		HashMap<String, Integer> hm = new HashMap();
		String[] words = lonleyDay.split(" ,.?!'");
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		ArrayList<String> words = {"Such", "a", "lonley", "day", "and", "it", "s", "day", "the", "most"};
		for (int j = 0; j < words.length; j++) {
			word = words.get(j);
			if (hm.containsKey(word)) {
				hm.put(word, hm.get(word)+1);
				// first time encountering a word
			} else {
				hm.put(word, 1);
			}

		}
	}

}
