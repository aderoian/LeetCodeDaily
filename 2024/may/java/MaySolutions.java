public class MaySolutions {

	/**
	 * Problem 2600
	 * Date: 05/05/2024
	 */
	public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
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
