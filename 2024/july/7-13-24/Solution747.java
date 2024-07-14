public class Solution747 {

	public static void main(String[] args) {
		System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
		System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
	}

	public static int dominantIndex(int[] nums) {
		int largest = -1;
		int largestIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > largest) {
				largest = nums[i];
				largestIndex = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i == largestIndex) continue;

			if (nums[i] * 2 > largest) return -1;
		}

		return largestIndex;
	}
}
