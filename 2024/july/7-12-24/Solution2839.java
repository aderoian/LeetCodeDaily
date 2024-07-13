public class Solution2839 {

	public static void main(String[] args) {
		System.out.println(canBeEqual("abcd", "cdab"));
		System.out.println(canBeEqual("abcd", "dacb"));
	}

	public static boolean canBeEqual(String s1, String s2) {
		char[] ch = new char[4];
		for (int i = 0; i < 4; i++) ch[i] = s2.charAt(i);
		for (int i = 0; i < 4; i++) {
			if (ch[i] == s1.charAt(i)) continue;
			else if (i + 2 < 4 && ch[i + 2] == s1.charAt(i)) {
				char c = ch[i + 2];
				ch[i + 2] = ch[i];
				ch[i] = c;
			} else return false;
		}
		return true;
	}
}
