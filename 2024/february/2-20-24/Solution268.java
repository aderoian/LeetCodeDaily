import java.util.Arrays;

public class Solution268 {

	public static void main(String[] args) {
		var solution = new Solution268();
		//System.out.println(solution.missingNumber(new int[] {3,0,1}));
		//System.out.println(solution.missingNumber(new int[] {0,1}));
		//System.out.println(solution.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
		System.out.println(solution.missingNumber(new int[]{0}));
	}

	public int missingNumber(int[] nums) {
		if (nums.length < 1) {
			return 0;
		} else if (nums.length < 2) {
			return nums[0] > 0 ? nums[0] + 1 : 1;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1; i++) {
			var diff = nums[i + 1] - nums[i];
			if (diff > 1) {
				return nums[i] + 1;
			}
		}

		return nums[nums.length - 1] + 1;
	}
}
