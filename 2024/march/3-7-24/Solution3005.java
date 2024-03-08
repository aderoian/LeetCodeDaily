public class Solution3005 {

	public static void main(String[] args) {
		Solution3005 s = new Solution3005();
		System.out.println(s.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));

	}

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
}