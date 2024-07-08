public class Solution1823 {

	public static void main(String[] args) {
		System.out.println(findTheWinner(5, 2));
		System.out.println(findTheWinner(6, 5));
	}

	public static int findTheWinner(int n, int k) {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = (ans + k) % i;
		}
		return ans + 1;
	}
}
