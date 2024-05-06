public class Solution2600 {

	public static void main(String[] args) {
		System.out.println(kItemsWithMaximumSum(6, 6, 6, 13));
	}

	public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
		int sum = 0;
		if (numOnes <= k) {
			sum += numOnes;
			k -= numOnes;
		} else
			return k;

		k -= numZeros;
		if (k <= 0) return sum;

		return sum - k;
	}
}
