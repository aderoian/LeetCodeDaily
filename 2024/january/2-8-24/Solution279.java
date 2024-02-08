public class Solution279 {

	public static void main(String[] args) {
		var solution = new Solution279();
		System.out.println(solution.numSquares(12));
		System.out.println(solution.numSquares(13));
	}

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
}
