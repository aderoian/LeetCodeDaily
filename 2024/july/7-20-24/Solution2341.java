import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2341 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})));
		System.out.println(Arrays.toString(numberOfPairs(new int[]{1, 1})));
		System.out.println(Arrays.toString(numberOfPairs(new int[]{0})));
	}

	public static int[] numberOfPairs(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums)
			freq.put(num, freq.getOrDefault(num, 0) + 1);

		int[] answer = new int[2];
		for (int count : freq.values()) {
			answer[0] += (count / 2);
			answer[1] += (count % 2);
		}

		return answer;
	}
}
