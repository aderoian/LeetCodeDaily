public class Solution896 {

	public static void main(String[] args) {
		var solution = new Solution896();
		System.out.println(solution.isMonotonic(new int[]{1, 2, 2, 3}));
		System.out.println(solution.isMonotonic(new int[]{6, 5, 4, 4}));
		System.out.println(solution.isMonotonic(new int[]{1, 3, 2}));
	}

	public boolean isMonotonic(int[] nums) {
		if (nums.length < 3) return true;

		for (int i = 1; i < nums.length - 1; i++) {
			if (!((nums[i - 1] <= nums[i] && nums[i + 1] >= nums[i]) || (nums[i - 1] >= nums[i] && nums[i + 1] <= nums[i])))
				return false;
		}

		return true;
	}
}
