public class Solution997 {

	public static void main(String[] args) {
		var solution = new Solution997();
		System.out.println(solution.findJudge(2, new int[][]{{1, 2}}));
		System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
		System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
	}

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
}
