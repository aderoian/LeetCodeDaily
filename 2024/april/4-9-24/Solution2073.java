public class Solution2073 {

	public static void main(String[] args) {
		Solution2073 solution = new Solution2073();
		System.out.println(solution.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
	}

	public int timeRequiredToBuy(int[] tickets, int k) {
		int time = 0;

		while (tickets[k] != 0) {
			for (int i = 0; i < tickets.length; i++) {
				if (tickets[i] == 0) continue;

				tickets[i]--;
				time++;

				if (i == k && tickets[i] == 0) return time;
			}
		}

		return time;
	}
}
