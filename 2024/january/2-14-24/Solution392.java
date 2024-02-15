public class Solution392 {

	public static void main(String[] args) {
		var solution = new Solution392();
		System.out.println(solution.isSubsequence("abc", "ahbgdc"));
		System.out.println(solution.isSubsequence("axc", "ahbgdc"));
	}

	public boolean isSubsequence(String s, String t) {
		int i = 0;
		for (char c : t.toCharArray()) {
			if (i < s.length() && c == s.charAt(i))
				i++;
		}

		return i == s.length();
	}
}
