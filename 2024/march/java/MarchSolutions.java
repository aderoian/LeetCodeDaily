import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarchSolutions {

	/**
	 * Problem 2788
	 * Date: 03/01/2024
	 */
	public List<String> splitWordsBySeparator(List<String> words, char separator) {
		var output = new ArrayList<String>();
		for (String word : words)
			output.addAll(Arrays.stream(word.split("\\" + separator)).filter(s -> !s.isEmpty()).toList());

		return output;
	}

	/**
	 * Problem 2864
	 * Date: 03/01/2024
	 */
	public String maximumOddBinaryNumber(String s) {
		var freqMap = new int[]{0, 0};
		for (char c : s.toCharArray()) {
			if (c == '0') freqMap[0]++;
			else freqMap[1]++;
		}

		if (freqMap[1] == 1) {
			return "0".repeat(freqMap[0]) + "1";
		} else {
			return "1".repeat(freqMap[1] - 1) + "0".repeat(freqMap[0]) + "1";
		}
	}

	/**
	 * Problem 1750
	 * Date: 03/05/2024
	 */
	public int minimumLength(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return right - left + 1;
			}
			char c = s.charAt(left);
			while (left <= right && s.charAt(left) == c) {
				left++;
			}
			while (left <= right && s.charAt(right) == c) {
				right--;
			}
		}
		return right - left + 1;
	}

	/**
	 * Problem 3005
	 * Date: 03/07/2024
	 */
	public int maxFrequencyElements(int[] nums) {
		boolean[] visited = new boolean[101];

		int maxCount = 0;
		int maxCountNum = 0;
		for (int num : nums) {
			if (visited[num]) {
				continue;
			}

			visited[num] = true;
			int count = 0;
			for (int i : nums) {
				if (num == i) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				maxCountNum = count;
			} else if (count == maxCount) {
				maxCountNum += count;
			}
		}
		return maxCountNum;
	}

	/**
	 * Problem 387
	 * Date: 03/018/2024
	 */
	public int firstUniqChar(String s) {
		int[] count = new int[26];
		Arrays.fill(count, 0);
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}
