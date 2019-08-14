import static org.junit.Assert.assertEquals;
import org.junit.*;

public class NumberToEnglishKata {
	
	// nothing here
	public static void main(String[] args) {}
	
	@Test
	public void runUnitTests() {
		assertEquals(numberToEnglish(765), "seven hundred and sixty-five");
		assertEquals(numberToEnglish(442), "four hundred and fourty-two");
		assertEquals(numberToEnglish(99), "ninety-nine");
		assertEquals(numberToEnglish(5), "five");
	}
	
	public static String numberToEnglish(int number) {
		final StringBuilder sb = new StringBuilder();
		if (number > 1000) {
			int temp = (int)Math.floor(number/1000);
			while (number > 1000) {
				number -= 1000;
			}
			sb.append(" " + temp + " thousand");
		}
		if (number > 100) {
			int temp = (int)Math.floor(number/100);
			while (number > 100) {
				number -= 100;
			}
			sb.append(" " + temp + " hundred");
		}
		if (number > 0) {
			if (sb.length() > 0) {
				sb.append(" and%s" + number + " ");
			} else {
				sb.append(number + " ");
			}
		}
		String result = sb.toString();
		// replace whole numbers with their English equivalent
		result = result.replace("1 ", "one ");
		result = result.replace("2 ", "two ");
		result = result.replace("3 ", "three ");
		result = result.replace("4 ", "four ");
		result = result.replace("5 ", "five ");
		result = result.replace("6 ", "six ");
		result = result.replace("7 ", "seven ");
		result = result.replace("8 ", "eight ");
		result = result.replace("9 ", "nine ");
		// replace whole numbers with their English equivalent, again
		result = result.replace(" 1", " one");
		result = result.replace(" 2", " two");
		result = result.replace(" 3", " three");
		result = result.replace(" 4", " four");
		result = result.replace(" 5", " five");
		result = result.replace(" 6", " six");
		result = result.replace(" 7", " seven");
		result = result.replace(" 8", " eight");
		result = result.replace(" 9", " nine");
		// replace partial numbers...
		result = result.replace("1", "ten-");
		result = result.replace("2", "twenty-");
		result = result.replace("3", "thirty-");
		result = result.replace("4", "fourty-");
		result = result.replace("5", "fifty-");
		result = result.replace("6", "sixty-");
		result = result.replace("7", "seventy-");
		result = result.replace("8", "eighty-");
		result = result.replace("9", "ninety-");
		// re-add spaces
		result = result.replace("%s", " ");
		return result.trim();
	}
}
