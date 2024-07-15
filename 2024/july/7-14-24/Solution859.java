import java.util.HashSet;

public class Solution859 {

	public static void main(String[] args) {
		System.out.println(buddyStrings("ab", "ba"));
		System.out.println(buddyStrings("ab", "ab"));
		System.out.println(buddyStrings("aa", "aa"));
	}

	public static boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		if (s.equals(goal)) {
			HashSet<Character> set = new HashSet<>();
			for (char c : s.toCharArray()) {
				if (!set.add(c)) {
					return true;
				}
			}
			return false;
		}

		int dif = 0;
		Character swapS = null;
		Character swapG = null;
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char gChar = goal.charAt(i);
			if (sChar != gChar) {
				if (dif == 2 || (dif == 1 && (swapS != gChar || swapG != sChar))) {
					return false;
				}
				swapS = sChar;
				swapG = gChar;
				dif++;
			}
		}
		return dif == 2;
	}
}
