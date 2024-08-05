import java.util.*;

public class AugustSolutions {

	/**
	 * Problem 1460
	 * Date: 08/02/2024
	 */
	public boolean canBeEqual(int[] target, int[] arr) {
		int[] freqMap = new int[1001];
		for (int i : target)
			freqMap[i]++;

		for (int i : arr) {
			freqMap[i]--;
			if (freqMap[i] < 0) return false;
		}

		return true;
	}

	/**
	 * Problem 1508
	 * Date: 08/03/2024
	 */
	public int rangeSum(int[] nums, int n, int left, int right) {
		List<Integer> sums = new ArrayList<>();
		int subSum;
		for (int i = 0; i < nums.length; i++) {
			subSum = 0;
			for (int j = 0; j < nums.length - i; j++) {
				subSum += nums[i + j];
				sums.add(subSum);
			}
		}

		Collections.sort(sums);

		int sum = 0;
		for (int i = left - 1; i < right; i++) {
			sum = (sum + sums.get(i)) % 1000000007;
		}
		return sum;
	}

	/**
	 * Problem 2053
	 * Date: 08/04/2024
	 */
	public String kthDistinct(String[] arr, int k) {
		Map<String, Integer> freqMap = new HashMap<>();

		for (String s : arr) {
			freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
		}

		if (freqMap.size() < k) return "";

		int distincts = 0;
		for (String s : arr) {
			if (freqMap.get(s) == 1) distincts++;
			if (distincts == k) return s;
		}

		return "";
	}
}
