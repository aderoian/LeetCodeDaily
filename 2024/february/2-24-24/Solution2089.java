import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2089 {

	public static void main(String[] args) {
		var solution = new Solution2089();
		System.out.println(solution.targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
		System.out.println(solution.targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
		System.out.println(solution.targetIndices(new int[]{1, 2, 5, 2, 3}, 5));
	}

	public List<Integer> targetIndices(int[] nums, int target) {
		Arrays.sort(nums);
		var output = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) output.add(i);
		}

		return output;
	}
}
