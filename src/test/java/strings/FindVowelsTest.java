package strings;

public class FindVowelsTest {

	public static void main(String[] args) {

		String str = "Testing";
		if (str.toLowerCase().matches(".*[aeiou]*") == true) {
			System.out.println("String contains vowel.");
		} else {
			System.out.println("String doesn't contain vowel.");
		}

	}
}
