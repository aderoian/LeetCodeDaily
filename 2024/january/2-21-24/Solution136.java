import java.util.ArrayList;

public class Solution136 {

	public static void main(String[] args) {
		var solution = new Solution136();
		System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
		System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
		System.out.println(solution.singleNumber(new int[]{1}));
	}

	public int singleNumber(int[] nums) {
		var numbers = new ArrayList<Integer>();
		for (int num : nums) {
			if (numbers.contains(num))
				numbers.remove((Object) num);
			else numbers.add(num);
		}

		return numbers.get(0);
	}
}
