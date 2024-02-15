public class Solution389 {

	public static void main(String[] args) {
		var solution = new Solution389();
		System.out.println(solution.findTheDifference("abcd", "abcde"));
		System.out.println(solution.findTheDifference("", "y"));
	}

	public char findTheDifference(String s, String t) {
		for (char c : t.toCharArray()) {
			if (!s.contains(String.valueOf(c))) return c;
			s = s.replaceFirst(String.valueOf(c), "");
		}

		// Code should not reach this point due to problem constraints
		return ' ';
	}
}
