import java.util.Arrays;

public class Solution1480 {

	public static void main(String[] args) {
		var solution = new Solution1480();
		System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 2, 3, 4})));
		System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 1, 1, 1, 1})));
		System.out.println(Arrays.toString(solution.runningSum(new int[]{3, 1, 2, 10, 1})));
		System.out.println(Arrays.toString(solution.runningSum(new int[]{})));
		System.out.println(Arrays.toString(solution.runningSum(new int[]{2})));
		System.out.println(Arrays.toString(solution.runningSum(new int[]{2, 4})));
		System.out.println(Arrays.toString(solution.runningSum(new int[]{2, 4, 4})));

	}

	public int[] runningSum(int[] nums) {
		if (nums.length == 0) return new int[0];

		var sums = new int[nums.length];
		sums[0] = nums[0];
		if (nums.length < 2) return sums;

		for (int i = 1; i < sums.length; i++) {
			var sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += (nums[j]);
			}
			sums[i] = sum;
		}

		return sums;
	}
}
