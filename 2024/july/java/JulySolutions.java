import java.util.*;

public class JulySolutions {

	/**
	 * Problem 350
	 * Date: 07/01/2024
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		int[] arr = new int[1001];  // To count frequencies of elements in nums1
		int[] result = new int[1001];  // To store the result

		// Count the frequencies of each number in nums1
		for (int num : nums1) {
			arr[num]++;
		}

		int ctr = 0;  // Counter for the result array
		// Traverse nums2 to find common elements
		for (int num : nums2) {
			if (arr[num] > 0) {
				result[ctr++] = num;
				arr[num]--;
			}
		}

		// Return only the filled portion of the result array
		return Arrays.copyOfRange(result, 0, ctr);
	}

	/**
	 * Problem 1509
	 * Date: 07/03/2024
	 */
	public int minDifference(int[] nums) {
		if (nums.length <= 4) {
			return 0;
		}
		Arrays.sort(nums);
		int ans = nums[nums.length - 1] - nums[0];
		for (int i = 0; i <= 3; i++) {
			ans = Math.min(ans, nums[nums.length - (3 - i) - 1] - nums[i]);
		}
		return ans;
	}

	/**
	 * Problem 2058
	 * Date: 07/04/2024
	 */
	public int[] nodesBetweenCriticalPoints(ListNode head) {
		List<Integer> criticalPoints = new ArrayList<>();
		ListNode prev = head;
		ListNode curr = head.next;
		int position = 1;

		while (curr.next != null) {
			if ((curr.val > prev.val && curr.val > curr.next.val) ||
					(curr.val < prev.val && curr.val < curr.next.val)) {
				criticalPoints.add(position);
			}
			prev = curr;
			curr = curr.next;
			position++;
		}

		if (criticalPoints.size() < 2) {
			return new int[]{-1, -1};
		}

		int minDistance = Integer.MAX_VALUE;
		int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

		for (int i = 1; i < criticalPoints.size(); i++) {
			minDistance = Math.min(minDistance, criticalPoints.get(i) - criticalPoints.get(i - 1));
		}

		return new int[]{minDistance, maxDistance};
	}

	/**
	 * Problem 2181
	 * Date: 07/04/2024
	 */
	public ListNode mergeNodes(ListNode head) {
		while (head.next.val != 0) {
			head.val += head.next.val;
			head.next = head.next.next;
		}

		if (head.next.next != null)
			head.next = mergeNodes(head.next);
		else head.next = null;

		return head;
	}

	/**
	 * Problem 2582
	 * Date: 07/05/2024
	 */
	public int passThePillow(int n, int time) {
		int chunks = time / (n - 1);
		return chunks % 2 == 0 ? (time % (n - 1) + 1) : (n - time % (n - 1));
	}

	/**
	 * Problem 1518
	 * Date: 07/06/2024
	 */
	public int numWaterBottles(int numBottles, int numExchange) {
		int drank = numBottles;

		while (numBottles >= numExchange) {
			int exchanged = numBottles / numExchange;
			drank += exchanged;

			numBottles -= numExchange * exchanged;
			numBottles += exchanged;
		}

		return drank;
	}

	/**
	 * Problem 1823
	 * Date: 07/07/2024
	 */
	public int findTheWinner(int n, int k) {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = (ans + k) % i;
		}
		return ans + 1;
	}

	/**
	 * Problem 1701
	 * Date: 07/08/2024
	 */
	public double averageWaitingTime(int[][] customers) {
		double[] waitTimes = new double[customers.length];
		int currentTime = 0;
		int idleTime = 0;
		for (int i = 0; i < customers.length; i++) {
			int[] customer = customers[i];
			idleTime = Math.max(0, customer[0] - currentTime);
			currentTime += idleTime + customer[1];
			waitTimes[i] = (currentTime) - customer[0];
		}

		return Arrays.stream(waitTimes).sum() / waitTimes.length;
	}

	/**
	 * Problem 1598
	 * Date: 07/09/2024
	 */
	public int minOperations(String[] logs) {
		int depth = 0;
		for (String log : logs) {
			switch (log) {
				case "./":
					break;
				case "../":
					if (depth == 0) break;
					depth--;
					break;
				default:
					depth++;
			}
		}

		return depth;
	}

	/**
	 * Problem 1190
	 * Date: 07/10/2024
	 */
	public String reverseParentheses(String s) {
		Deque<String> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push("(");
			} else if (c == ')') {
				StringBuilder rev = new StringBuilder();
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					rev.append(new StringBuilder(stack.pop()).reverse());
				}
				stack.pop(); // Remove the '('
				stack.push(rev.toString());
			} else {
				stack.push(String.valueOf(c));
			}
		}

		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.insert(0, stack.pop());
		}

		return result.toString();
	}

	/**
	 * Problem 1717
	 * Date: 07/11/2024
	 */
	public int maximumGain(String s, int x, int y) {
		Deque<Character> deque = new ArrayDeque<>();
		int ans = solve(s, x > y ? "ab" : "ba", Math.max(x, y), deque);
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			sb.append(deque.pollLast());
		}
		return ans + solve(sb.toString(), x > y ? "ba" : "ab", Math.min(x, y), deque);
	}

	public int solve(String s, String t, int score, Deque<Character> deque) {
		for (char ch : s.toCharArray()) {
			if (!deque.isEmpty() && t.equals("" + deque.peek() + ch)) {
				deque.pop();
			} else {
				deque.push(ch);
			}
		}
		return score * (s.length() - deque.size()) / 2;
	}

	/**
	 * Problem 2839
	 * Date: 07/12/2024
	 */
	public boolean canBeEqual(String s1, String s2) {
		char[] ch = new char[4];
		for (int i = 0; i < 4; i++) ch[i] = s2.charAt(i);
		for (int i = 0; i < 4; i++) {
			if (ch[i] == s1.charAt(i)) continue;
			else if (i + 2 < 4 && ch[i + 2] == s1.charAt(i)) {
				char c = ch[i + 2];
				ch[i + 2] = ch[i];
				ch[i] = c;
			} else return false;
		}
		return true;
	}

	/**
	 * Problem 747
	 * Date: 07/13/2024
	 */
	public int dominantIndex(int[] nums) {
		int largest = -1;
		int largestIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > largest) {
				largest = nums[i];
				largestIndex = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i == largestIndex) continue;

			if (nums[i] * 2 > largest) return -1;
		}

		return largestIndex;
	}

	/**
	 * Problem 859
	 * Date: 07/14/2024
	 */
	public boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		if (s.equals(goal)) {
			HashSet<Character> set = new HashSet<>();
			for (char c : s.toCharArray()) {
				if (!set.add(c)) {
					return true;
				}
			}
			return false;
		}

		int dif = 0;
		Character swapS = null;
		Character swapG = null;
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char gChar = goal.charAt(i);
			if (sChar != gChar) {
				if (dif == 2 || (dif == 1 && (swapS != gChar || swapG != sChar))) {
					return false;
				}
				swapS = sChar;
				swapG = gChar;
				dif++;
			}
		}
		return dif == 2;
	}

	/**
	 * Problem 1441
	 * Date: 07/18/2024
	 */
	public List<String> buildArray(int[] target, int n) {
		int stack = 1;
		List<String> operations = new ArrayList<>();
		for (int num : target) {
			while (stack < num) {
				stack++;
				operations.add("Push");
				operations.add("Pop");
			}

			operations.add("Push");
			stack++;
		}

		return operations;
	}

	/**
	 * Problem 1380
	 * Date: 07/19/2024
	 */
	public List<Integer> luckyNumbers(int[][] matrix) {
		int N = matrix.length, M = matrix[0].length;

		List<Integer> rowMin = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int rMin = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				rMin = Math.min(rMin, matrix[i][j]);
			}
			rowMin.add(rMin);
		}

		List<Integer> colMax = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int cMax = Integer.MIN_VALUE;
			for (int j = 0; j < N; j++) {
				cMax = Math.max(cMax, matrix[j][i]);
			}
			colMax.add(cMax);
		}

		List<Integer> luckyNumbers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == rowMin.get(i) && matrix[i][j] == colMax.get(j)) {
					luckyNumbers.add(matrix[i][j]);
				}
			}
		}

		return luckyNumbers;
	}

	/**
	 * Problem 2341
	 * Date: 07/20/2024
	 */
	public int[] numberOfPairs(int[] nums) {
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

	/**
	 * Problem 2418
	 * Date: 07/21/2024
	 */
	public String[] sortPeople(String[] names, int[] heights) {
		boolean swapped;
		int tempHeight;
		String tempName;
		for (int i = 0; i < heights.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < heights.length - i - 1; j++) {
				if (heights[j] < heights[j + 1]) {
					tempHeight = heights[j];
					tempName = names[j];
					heights[j] = heights[j + 1];
					names[j] = names[j + 1];
					heights[j + 1] = tempHeight;
					names[j + 1] = tempName;

					swapped = true;
				}
			}

			if (!swapped) break;
		}

		return names;
	}

	/**
	 * Problem 1450
	 * Date: 07/22/2024
	 */
	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int students = 0;
		for (int i = 0; i < startTime.length; i++) {
			if (startTime[i] <= queryTime && endTime[i] >= queryTime) students++;
		}
		return students;
	}

	/**
	 * Problem 1447
	 * Date: 07/22/2024
	 */
	public List<String> simplifiedFractions(int n) {
		List<String> fractions = new ArrayList<>();

		List<Float> createdFractions = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				float fraction = (float) j / i;
				if (createdFractions.contains(fraction)) continue;

				createdFractions.add(fraction);
				fractions.add(j + "/" + i);
			}
		}

		return fractions;
	}

	/**
	 * Problem 2319
	 * Date: 07/23/2024
	 */
	public boolean checkXMatrix(int[][] grid) {
		int n = grid.length;
		boolean[][] check = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					if (grid[i][j] == 0 || grid[i][n - j - 1] == 0) {
						return false;
					} else {
						check[i][j] = true;
						check[i][n - 1 - j] = true;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) {
					if (grid[i][j] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Problem 605
	 * Date: 07/24/2024
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0) {
			return true;
		}
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				n--;
				if (n == 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Problem 1290
	 * Date: 07/25/2024
	 */
	public int getDecimalValue(ListNode head) {
		StringBuilder binaryString = new StringBuilder(head.val + "");
		while (head.next != null) {
			binaryString.append(head.next.val);
			head.next = head.next.next;
		}

		return Integer.parseInt(binaryString.toString(), 2);
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

		@Override
		public String toString() {
			return "ListNode{val=" + val + ", next=" + next + "}";
		}
	}
}
