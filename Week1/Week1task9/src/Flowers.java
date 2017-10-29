
public class Flowers {

	public static void main(String[] args) {
	
		String roses = "I like roses. Yesterday I bought some roses. I have many roses in my garden.";
		System.out.println(roses);
		roses.replaceAll("roses", "flowers");
		String finalVersion = roses.replaceAll("roses", "flowers");
		System.out.println(finalVersion);
	}
}


	

