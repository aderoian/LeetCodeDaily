public class JuneSolutions {

	/**
	 * Problem 2259
	 * Date: 06/28/2024
	 */
	public String removeDigit(String number, char digit) {
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

	public String largestNumber(String a, String b) {
		if (a.length() > b.length()) return a;
		else if (a.length() < b.length()) return b;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) > b.charAt(i)) return a;
			else if (a.charAt(i) < b.charAt(i)) return b;
		}

		return a;
	}

	/**
	 * Problem 1688
	 * Date: 06/29/2024
	 */
	public int numberOfMatches(int n) {
		if (n == 1) return 0;

		if (n % 2 == 1) return ((n - 1) / 2) + numberOfMatches((n - 1) / 2 + 1);
		else return (n / 2) + numberOfMatches(n / 2);
	}

	/**
	 * Problem 1550
	 * Date: 06/30/2024
	 */
	public boolean threeConsecutiveOdds(int[] arr) {
		int oddCounter = 0;
		for (int i : arr) {
			if (i % 2 == 1) oddCounter++;
			else oddCounter = 0;
			if (oddCounter >= 3) return true;
		}
		return false;
	}
}
