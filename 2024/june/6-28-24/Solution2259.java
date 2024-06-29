public class Solution2259 {

	public static void main(String[] args) {

	}

	public static String removeDigit(String number, char digit) {
		int occurrences = 0;
		for (char c : number.toCharArray())
			if (c == digit) occurrences++;

		if (occurrences == 1) return number.replace(String.valueOf(digit), "");

		String largestNumber = "0";
		int index = number.indexOf(digit);
		for (int i = 0; i < occurrences; i++) {
			largestNumber = largestNumber(number.substring(0, index) + number.substring(index + 1), largestNumber);
			index = index + number.substring(index + 1).indexOf(digit) + 1;
		}

		return largestNumber;
	}

	public static String largestNumber(String a, String b) {
		if (a.length() > b.length()) return a;
		else if (a.length() < b.length()) return b;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) > b.charAt(i)) return a;
			else if (a.charAt(i) < b.charAt(i)) return b;
		}

		return a;
	}
}
