import java.util.Arrays;

public class Solution387 {

	public static void main(String[] args) {
		Solution387 s = new Solution387();
		System.out.println(s.firstUniqChar("aadadaad"));
		System.out.println(s.firstUniqChar("loveleetcode"));
		System.out.println(s.firstUniqChar("aabb"));
		System.out.println(s.firstUniqChar("z"));
		System.out.println(s.firstUniqChar("aadadaad"));
	}

	public int firstUniqChar(String s) {
		int[] count = new int[26];
		Arrays.fill(count, 0);
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}
