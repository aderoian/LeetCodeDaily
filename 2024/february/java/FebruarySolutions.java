import java.util.*;

public class FebruarySolutions {

	/**
	 * Problem 49
	 * Date: 02/06/2024
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		var sortedWords = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			var sortedWord = sortWord(str);
			if (!sortedWords.containsKey(sortedWord)) {
				sortedWords.put(sortedWord, new ArrayList<String>());
			}
			sortedWords.get(sortedWord).add(str);
		}

		return new ArrayList<>(sortedWords.values());
	}

	public String sortWord(String word) {
		var charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	/**
	 * Problem 451
	 * Date: 02/07/2024
	 */
	public String frequencySort(String s) {
		Map<Character, Integer> charCount = new HashMap<>();
		for (char c : s.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		charCount.entrySet().stream()
				.sorted((e1, e2) -> e2.getValue() - e1.getValue())
				.forEach(e -> {
					sb.append(String.valueOf(e.getKey()).repeat(Math.max(0, e.getValue())));
				});

		return sb.toString();
	}

	/**
	 * Problem 279
	 * Date: 02/08/2024
	 */
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}

	/**
	 * Problem 389
	 * Date: 02/14/2024
	 */
	public char findTheDifference(String s, String t) {
		for (char c : t.toCharArray()) {
			if (!s.contains(String.valueOf(c))) return c;
			s = s.replaceFirst(String.valueOf(c), "");
		}

		// Code should not reach this point due to problem constraints
		return ' ';
	}

	/**
	 * Problem 392
	 * Date: 02/14/2024
	 */
	public boolean isSubsequence(String s, String t) {
		int i = 0;
		for (char c : t.toCharArray()) {
			if (i < s.length() && c == s.charAt(i))
				i++;
		}

		return i == s.length();
	}

	/**
	 * Problem 1480
	 * Date: 02/15/2024
	 */
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

	/**
	 * Problem 1481
	 * Date: 02/15/2024
	 */
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int x : arr) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> elements = new ArrayList<>(map.entrySet());

		elements.sort(Comparator.comparingInt(Map.Entry::getValue));

		for (Map.Entry<Integer, Integer> entry : elements) {
			if (entry.getValue() <= k) {
				k -= entry.getValue();
				map.remove(entry.getKey());
			} else {
				break;
			}
		}
		return map.size();
	}

	/**
	 * Problem 1642
	 * Date: 02/16/2024
	 */
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> p = new PriorityQueue<>((x, z) -> z - x);

		int i = 0, diff = 0;
		for (i = 0; i < heights.length - 1; i++) {
			diff = heights[i + 1] - heights[i];

			if (diff <= 0) {
				continue;
			}

			bricks -= diff;
			p.offer(diff);

			if (bricks < 0) {
				bricks += p.poll();
				ladders--;
			}

			if (ladders < 0) {
				break;
			}
		}

		return i;
	}

	/**
	 * Problem 20
	 * Date: 02/17/2024
	 */
	public boolean isValid(String s) {
		var charOpenQueue = new LinkedList<Character>();
		var openFreq = new int[]{0, 0, 0};
		for (Character c : s.toCharArray()) {
			var first = charOpenQueue.peek();
			switch (c) {
				case '(':
					openFreq[0]++;
					charOpenQueue.addFirst(c);
					break;
				case '[':
					openFreq[1]++;
					charOpenQueue.addFirst(c);
					break;
				case '{':
					openFreq[2]++;
					charOpenQueue.addFirst(c);
					break;
				case ')':
					openFreq[0]--;
					if (!Character.valueOf('(').equals(first)) return false;
					else charOpenQueue.pollFirst();
					break;
				case ']':
					openFreq[1]--;
					if (!Character.valueOf('[').equals(first)) return false;
					else charOpenQueue.pollFirst();
					break;
				case '}':
					openFreq[2]--;
					if (!Character.valueOf('{').equals(first)) return false;
					else charOpenQueue.pollFirst();
					break;
			}

			if (openFreq[0] < 0 || openFreq[1] < 0 || openFreq[2] < 0) return false;
		}

		return charOpenQueue.isEmpty();
	}

	/**
	 * Problem 21
	 * Date: 02/17/2024
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				list1.next = mergeTwoLists(list1.next, list2);
				return list1;
			} else {
				list2.next = mergeTwoLists(list1, list2.next);
				return list2;
			}
		}
		if (list1 == null)
			return list2;

		return list1;
	}

	/**
	 * Problem 830
	 * Date: 02/18/2024
	 */
	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> result = new ArrayList<>();
		if (s.isEmpty()) return result;

		var chars = s.toCharArray();
		Character currChar = chars[0];
		int currLength = 0;
		for (int i = 0; i < chars.length; i++) {
			if (!currChar.equals(chars[i])) {
				if (currLength > 2)
					result.add(List.of(i - currLength, i - 1));

				currChar = chars[i];
				currLength = 1;
			} else if (i == chars.length - 1) {
				currLength++;
				if (currLength > 2)
					result.add(List.of(i + 1 - currLength, i));
			} else currLength++;


		}

		//result.sort(Comparator.comparingInt(a -> a.get(1) - a.get(0)));
		return result;
	}

	/**
	 * Problem 268
	 * Date: 02/20/2024
	 */
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

	/**
	 * Problem 136
	 * Date: 02/21/2024
	 */
	public int singleNumber136(int[] nums) {
		var numbers = new ArrayList<Integer>();
		for (int num : nums) {
			if (numbers.contains(num))
				numbers.remove((Object) num);
			else numbers.add(num);
		}

		return numbers.get(0);
	}

	/**
	 * Problem 137
	 * Date: 02/21/2024
	 */
	public int singleNumber137(int[] nums) {
		var numbers = new ArrayList<Integer>();
		for (int num : nums) {
			if (numbers.contains(num))
				numbers.remove((Object) num);
			else {
				numbers.add(num);
				numbers.add(num);
			}
		}

		return numbers.get(0);
	}

	/**
	 * Problem 997
	 * Date: 02/22/2024
	 */
	public int findJudge(int n, int[][] trust) {
		var outgoing = new int[n + 1];
		var incoming = new int[n + 1];

		for (int[] t : trust) {
			outgoing[t[0]]++;
			incoming[t[1]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (outgoing[i] == 0 && incoming[i] == n - 1) return i;
		}

		return -1;
	}

	/**
	 * Problem 783
	 * Date: 02/23/2024
	 */
	List<Integer> values = new ArrayList<>();

	public int minDiffInBST(TreeNode root) {
		readNodeValue(root);

		Collections.sort(values);

		int min = (int) (10e6 + 1);
		for (int i = 0; i < values.size() - 1; i++)
			min = Math.min(min, Math.abs(values.get(i) - values.get(i + 1)));

		return min;
	}

	public void readNodeValue(TreeNode node) {
		values.add(node.val);
		if (node.left != null) readNodeValue(node.left);
		if (node.right != null) readNodeValue(node.right);
	}

	/**
	 * Problem 2089
	 * Date: 02/24/2024
	 */
	public List<Integer> targetIndices(int[] nums, int target) {
		Arrays.sort(nums);
		var output = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) output.add(i);
		}

		return output;
	}

	/**
	 * Problem 2094
	 * Date: 02/24/2024
	 */
	public int[] findEvenNumbers(int[] digits) {
		ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == 0) continue;
			for (int j = 0; j < digits.length; j++) {
				if (i == j) continue;
				for (int k = 0; k < digits.length; k++) {
					if (j == k || i == k) continue;

					int number = Integer.parseInt("" + digits[i] + digits[j] + digits[k]);
					if (number % 2 == 0 && !output.contains(number)) output.add(number);
				}
			}
		}

		var outputArray = output.stream().mapToInt(i -> i).toArray();
		Arrays.sort(outputArray);
		return outputArray;
	}

	/**
	 * Problem 415
	 * Date: 02/26/2024
	 */
	public String addStrings(String num1, String num2) {
		StringBuilder output = new StringBuilder();
		int carry = 0;
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) sum += num1.charAt(i--) - '0';
			if (j >= 0) sum += num2.charAt(j--) - '0';
			output.append(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0) output.append(carry);
		return output.reverse().toString();
	}

	/**
	 * Problem 724
	 * Date: 02/28/2024
	 */
	public int pivotIndex(int[] nums) {
		for (int i = -1; i < nums.length; i++) {
			int leftSum = 0;
			for (int j = 0; j <= i && j >= 0; j++) {
				leftSum += nums[j];
			}

			int rightSum = 0;
			for (int k = i + 2; k < nums.length; k++) {
				rightSum += nums[k];
			}

			if (leftSum == rightSum && i + 1 < nums.length) return i + 1;
		}

		return -1;
	}

	/**
	 * Problem 804
	 * Date: 02/28/2024
	 */
	public final String[] morseCodes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

	public int uniqueMorseRepresentations(String[] words) {
		var morseWords = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			var morseWord = new StringBuilder();
			for (int j = 0; j < words[i].length(); j++) {
				morseWord.append(morseCodes[words[i].charAt(j) - 'a']);
			}
			morseWords[i] = morseWord.toString();
		}

		return (int) Arrays.stream(morseWords).distinct().count();
	}

	/**
	 * Utility Classes
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
