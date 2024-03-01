public class Solution724 {

	public static void main(String[] args) {
		var solution = new Solution724();
		//System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
		//System.out.println(solution.pivotIndex(new int[]{1, 2, 3}));
		//System.out.println(solution.pivotIndex(new int[]{2, 1, -1}));
		System.out.println(solution.pivotIndex(new int[]{-1, -1, -1, 1, 1, 1}));
	}

	public int pivotIndex(int[] nums) {
		for (int i = -1; i < nums.length; i++) {
			int leftSum = 0;
			for (int j = 0; j <= i && j >= 0; j++) {
				leftSum += nums[j];
			}

			int rightSum = 0;
			for (int k = i + 2; k < nums.length; k++) {
				rightSum += nums[k];
			}

			if (leftSum == rightSum && i + 1 < nums.length) return i + 1;
		}

		return -1;
	}
}
