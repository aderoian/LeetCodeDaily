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

	/**
	 * Problem 3016
	 * Date: 08/05/2024
	 */
	public int minimumPushes(String word) {
		var res = 0;
		var cnt = 0;
		var freq = new int[26];

		for (var c : word.toCharArray())
			freq[c - 'a']++;

		Arrays.sort(freq);

		for (var i = 25; i >= 0; i--)
			if (freq[i] > 0)
				res += freq[i] * (cnt++ / 8 + 1);

		return res;
	}

	/**
	 * Problem 326
	 * Date: 08/06/2024
	 */
	public boolean isPowerOfThree(int n) {
		if (n == 0) return false;
		while (n % 3 == 0) n /= 3;
		return n == 1;
	}

	/**
	 * Problem 929
	 * Date: 08/07/2024
	 */
	public int numUniqueEmails(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();
		for (String email : emails) {
			String[] parts = email.split("@");
			String local = parts[0];
			String domain = parts[1];
			StringBuilder sb = new StringBuilder();
			for (char c : local.toCharArray()) {
				if (c == '+') break;
				if (c == '.') continue;
				sb.append(c);
			}
			uniqueEmails.add(sb + "@" + domain);
		}
		return uniqueEmails.size();
	}

	/**
	 * Problem 703
	 * Date: 08/11/2024
	 */
	class KthLargest {

		private final int k;
		private final PriorityQueue<Integer> minHeap;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			minHeap = new PriorityQueue<>(k);
			for (int num : nums) {
				if (minHeap.size() < k) {
					minHeap.offer(num);
				} else if (num > minHeap.peek()) {
					minHeap.offer(num);
					if (minHeap.size() > k) {
						minHeap.poll();
					}
				}
			}
		}

		public int add(int val) {
			if (minHeap.size() < k) {
				minHeap.offer(val);
			} else if (val > minHeap.peek()) {
				minHeap.offer(val);
				minHeap.poll();
			}
			return minHeap.peek();
		}
	}
}
