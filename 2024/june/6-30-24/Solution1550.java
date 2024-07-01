public class Solution1550 {

	public static void main(String[] args) {
		System.out.println(threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
		System.out.println(threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
	}

	public static boolean threeConsecutiveOdds(int[] arr) {
		int oddCounter = 0;
		for (int i : arr) {
			if (i % 2 == 1) oddCounter++;
			else oddCounter = 0;
			if (oddCounter >= 3) return true;
		}
		return false;
	}
}
