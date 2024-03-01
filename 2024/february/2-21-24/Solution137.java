import java.util.ArrayList;

public class Solution137 {

	public static void main(String[] args) {
		var solution = new Solution137();
		System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
		System.out.println(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
	}

	public int singleNumber(int[] nums) {
		var numbers = new ArrayList<Integer>();
		for (int num : nums) {
			if (numbers.contains(num))
				numbers.remove((Object) num);
			else {
				numbers.add(num); numbers.add(num);
			}
		}

		return numbers.get(0);
	}
}
