public class Solution1544 {

	public static void main(String[] args) {
		System.out.println(makeGood("leEeetcode"));
		System.out.println(makeGood("abBAcC"));
		System.out.println(makeGood("s"));
	}

	public static String makeGood(String s) {
		if (s.length() < 2) return s;

		for (int i = 0; i <= s.length() - 2; i++) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i + 1);

			if ((String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))) && !(Character.isLowerCase(c1) && Character.isLowerCase(c2) || Character.isUpperCase(c1) && Character.isUpperCase(c2))) {
				return makeGood(s.substring(0, i) + s.substring(i + 2));
			}
		}

		return s;
	}
}
